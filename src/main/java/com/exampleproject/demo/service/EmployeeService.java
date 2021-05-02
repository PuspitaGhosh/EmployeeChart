package com.exampleproject.demo.service;
import org.springframework.stereotype.Component;
import java.util.*;
import com.exampleproject.demo.model.Employee;
@Component
public class EmployeeService {
	private static List<Employee> emplist = new ArrayList<Employee>();
	static {
		Employee a=new Employee(123,"Tom");
		emplist.add(a);
		Employee b=new Employee(456,"Sam");
		emplist.add(b);
		Employee c=new Employee(789,"Roo");
		emplist.add(c);
	}

	public List<Employee> retrieveAllEmployees() {
		return emplist;
	}

	public Employee retrieveEmployee(int id) {
		for (Employee e : emplist) {
			if (e.getEmpid()==id) {
				return e;
			}
		}
		return null;
	}
	
	public void addEmployees(Employee employee)
	{
		emplist.add(employee);
	}
	
	public void updateNameEmployee(int id,String name) {
		for (Employee e : emplist) {
			if (e.getEmpid()==id) {
				e.setEmpname(name);
			}
		}
	}
	public int deleteASpecificEmployee(int id)
	{
		for(Employee e:emplist) {
			if(e.getEmpid()==id)
			{
				emplist.remove(e);
				return 1;
			}
		}
		return 0;
	}

}
