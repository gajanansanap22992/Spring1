package in.gajanan.crudapi.service;

import java.util.List;

import in.gajanan.crudapi.models.Employee;

public interface EmployeeService {
	List<Employee> get();
	Employee get(int id);
	void save(Employee employee);
	void delete(int id);

}
