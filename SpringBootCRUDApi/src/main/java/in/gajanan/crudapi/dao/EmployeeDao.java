package in.gajanan.crudapi.dao;

import java.util.List;

import in.gajanan.crudapi.models.Employee;

public interface EmployeeDao {
	List<Employee> get();
	Employee get(int id);
	void save(Employee employee);
	void delete(int id);
}
