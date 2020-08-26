package jdbc.methods;

import java.util.List;

import jdbc.Model.Employee;

public interface EmpInterface {
	public boolean createEmp(Employee emp);
	public List<Employee> getAllEmpoyees();
	public Employee getEmpById(int id);
	public boolean update(int ch,int id,String value);
	public boolean delete(int id);
}
