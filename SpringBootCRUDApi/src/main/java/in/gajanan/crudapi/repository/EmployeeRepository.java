package in.gajanan.crudapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.gajanan.crudapi.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
