package jdbc.layer;

import java.util.List;

import jdbc.Model.Employee;

public interface EmpServInterface {
	public boolean createEployee(Employee emp);
	public boolean deleteEmployee(int id);
	public boolean update(int ch,int id,String value);
	public List<Employee> getAllEmpoyees();
	public Employee getEmpById(int id);
}
