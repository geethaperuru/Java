package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection connection;
	private static ConnectionFactory factory = null;
	
//	private static class SingletonObject	
//	{
//		private static final ConnectionFactory con = new ConnectionFactory();
//	}
	
	private ConnectionFactory() throws SQLException
	{
		connection = DriverManager.getConnection("****","****","*****");
	}
	
	//singleton Object
	public static ConnectionFactory createObject() throws SQLException{
		if(factory==null) {
			factory=new ConnectionFactory();
		}
		return factory;
	}
	public Connection getConnection()throws SQLException{
		return connection;
	}
	
	
//	public static ConnectionFactory getInstance()
//	{
//		return SingletonObject.con;
//	}
	
}
