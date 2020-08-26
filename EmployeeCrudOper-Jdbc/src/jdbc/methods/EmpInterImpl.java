package jdbc.methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


import jdbc.Model.Employee;
import jdbc.connection.ConnectionFactory;

public class EmpInterImpl implements EmpInterface
{
	
	private ConnectionFactory factory = null;
	private Connection con = null;
	private PreparedStatement ps = null;
	private Statement stmt = null;
	private ResultSet rs= null;
	
	public EmpInterImpl() throws SQLException {
		super();
		factory = ConnectionFactory.createObject();
		con = factory.getConnection();
	}

	@Override
	public boolean createEmp(Employee emp) {
		// TODO Auto-generated method stub
		try{
			ps = con.prepareStatement("insert into employees values(?,?,?,?)");
			ps.setInt(1, emp.getEmpId());
			ps.setString(2, emp.getFirstName());
			ps.setString(3,emp.getLastName());
			ps.setString(4, emp.getEmail());
			ps.execute();
			return true;
		}
		catch(SQLException e)
		{
			System.out.println("Please reenter the details");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Employee> getAllEmpoyees() {
		// TODO Auto-generated method stub
		
		List<Employee> list = new ArrayList<Employee>();
		
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from employees");
			while(rs.next())
			{
				list.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Employee getEmpById(int id) {
		// TODO Auto-generated method stub
		
		try
		{
			stmt = con.createStatement();
			//String q= "select * from employees where id='"+id+"'";
			rs= stmt.executeQuery("select * from employees where empId='"+id+"'");
			if(rs.next())
			{
				return new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(int ch,int id, String value) {
		// TODO Auto-generated method stub
		
		//switch using java 14 updations
//		String query = switch(ch)
//				{
//					case 1 ->
//						"update employee set firstName=? where id=?";
//	
//					case 2 ->
//						"update employee set lastName=? where id=?";
//					case 3 ->
//						"update employee set email=? where id=?";
//					default -> "..."
//				};
		
		String query="";
		switch(ch)
		{
			case 1:
			{
				query = "update employees set firstName=? where empId=?";
				break;
			}
			case 2:
			{
				query = "update employees set lastName=? where empId=?";
				break;
			}
			case 3:{
				query = "update employees set email=? where empId=?";
				break;
			}
			default:{
				break;
			}
		}
		
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, value);
			ps.setInt(2,id);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Id not updated");
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		try{
			ps = con.prepareStatement("delete from employees where empId=?");
			ps.setInt(1,id);
			ps.execute();
			return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	

}
