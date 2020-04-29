package in.gajanan.crudapi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.gajanan.crudapi.models.Employee;
@Repository
public class EmployeeDaoImplementation implements EmployeeDao {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> get() {
     
      Session currentSession= entityManager.unwrap(Session.class);
     Query<Employee> query= currentSession.createQuery("from Employee",Employee.class);
     List<Employee> list=query.getResultList();
     return list;
	}

	@Override
	public Employee get(int id) {
		Session currentsSession= entityManager.unwrap(Session.class);
		Employee employeeObj=currentsSession.get(Employee.class, id);
		return employeeObj;
	}

	@Override
	public void save(Employee employee) {
		 Session currentSession= entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(employee);
		
	}

	@Override
	public void delete(int id) {
		Session currentsSession= entityManager.unwrap(Session.class);
		Employee employeeObj=currentsSession.get(Employee.class, id);
		currentsSession.delete(employeeObj);
	}

}
