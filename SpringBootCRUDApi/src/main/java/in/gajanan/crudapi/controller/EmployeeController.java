package in.gajanan.crudapi.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.gajanan.crudapi.models.Employee;
import in.gajanan.crudapi.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/list")
	public List<Employee> get()
	{
		return employeeService.get();
	}
	
	
	@PostMapping("/create")
	public Employee save(@RequestBody Employee employeeObj)
	{
		employeeService.save(employeeObj);
		return employeeObj;
	}
	
	@RequestMapping("/{id}")
	public Employee get(@PathVariable int id)
	{
		Employee employeeObj= employeeService.get(id);
		if(employeeObj==null)
		{
			throw new RuntimeException("Employee with id "+id+" not found");
		}
		else {
		return employeeObj;
		}
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id)
	{
		employeeService.delete(id);
		return "employee has been deleted successfully";
	}
//	@PutMapping("/update/{id}")
//	public Employee update(@RequestBody Employee employeeObj)
//	{
//		employeeService.save(employeeObj);
//		return employeeObj;
//	}
	@PutMapping("/update/{id}")
	public Employee update(@RequestBody Employee employeeObj,@PathVariable int id)
	{
		
			
				employeeService.save(employeeObj);
				return employeeObj;
//		        
		
	}
}
