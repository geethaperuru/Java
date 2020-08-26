package jdbc.layer;

import java.sql.SQLException;
import java.util.List;

import jdbc.Model.Employee;
import jdbc.methods.EmpInterImpl;
import jdbc.methods.EmpInterface;

public class EmplServImpl implements EmpServInterface{
	private EmpInterface dao = null;

	public EmplServImpl() throws SQLException{
		super();
		dao = new EmpInterImpl();
	}

	@Override
	public boolean createEployee(Employee emp) {
		// TODO Auto-generated method stub
		return dao.createEmp(emp);
	}

	@Override
	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public boolean update(int ch, int id, String value) {
		// TODO Auto-generated method stub
		return dao.update(ch, id, value);
	}

	@Override
	public List<Employee> getAllEmpoyees() {
		// TODO Auto-generated method stub
		return dao.getAllEmpoyees();
	}

	@Override
	public Employee getEmpById(int id) {
		// TODO Auto-generated method stub
		return dao.getEmpById(id);
	}
	
	
}
