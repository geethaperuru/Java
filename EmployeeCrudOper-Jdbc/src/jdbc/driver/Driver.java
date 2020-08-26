/**
 * 
 */
package jdbc.driver;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import jdbc.Model.Employee;
import jdbc.layer.EmpServInterface;
import jdbc.layer.EmplServImpl;

/**
 * @author geetha
 *
 */
public class Driver {

	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws SQLException {
		EmpServInterface service = new EmplServImpl();
		
		int choice = 0;
		do
		{
			System.out.println("1)Create Employee\n2)Display Employees\n3)Get Employee Details\n4)Update Employee Details\n5)Delete Employee\n");
			choice = sc.nextInt();
			switch(choice)
			{
				case 1:
				{
					System.out.println("Employee Id : ");
					int id = sc.nextInt();
					System.out.println("Employee First Name : ");
					String fname = sc.next();
					System.out.println("Employee Last name : ");
					String lname = sc.next();
					System.out.println("Employee email : ");
					String email = sc.next();
					if(service.createEployee(new Employee(id, fname, lname, email)))
						System.out.println("Employee created successfully");
					else
						System.out.println("Wrong details enteres");
					break; 
				}
				case 2:
				{
					List<Employee> list = service.getAllEmpoyees();
					for (Employee e : list) {
						System.out.printf("\n%d\t%s\t%s\t%s", e.getEmpId(), e.getFirstName(), e.getLastName(), e.getEmail());
					}
					break;
				}
				case 3:
				{
					System.out.println("Enter the Employee Id : ");
					int idno = sc.nextInt();
					Employee e = service.getEmpById(idno);
					if( e != null)
					{
						System.out.printf("\n%d\t%s\t%s\t%s", e.getEmpId(), e.getFirstName(), e.getLastName(), e.getEmail());
					}
					else
						System.out.println("Wrong details entered");
					break;
				}
				case 4:
				{
					System.out.println("Enter the Employee Id : ");
					int idno = sc.nextInt();
					System.out.println("Please enter the choice you wanted to update:\na)First Nameb)Last Name\nc)Email\nNote:Employee Id cannot be updated");
					char ch='a';
					switch(ch)
					{
						case 'a':
						{
							String val = sc.next();
							
							if(service.update(1, idno, val))
								System.out.println("Details updated Successfully");
							else
								System.out.println("Wrong details submitted!");
							break;
						}
						case 'b':
						{
							String val = sc.next();
							if(service.update(1, idno, val))
								System.out.println("Details updated Successfully");
							else
								System.out.println("Wrong details submitted!");
							break;
						}
						case 'c':
						{
							String val = sc.next();
							if(service.update(1, idno, val))
								System.out.println("Details updated Successfully");
							else
								System.out.println("Wrong details submitted!");
							break;
						}
						default:
						{
							System.out.println("Wrong option selected");
							break;
						}
					}	
				}
				case 5:
				{
					System.out.println("Enter the Employee Id : ");
					int idno = sc.nextInt();
					if(service.deleteEmployee(idno))
						System.out.println("Employee deleted successfully");
					else
						System.out.println("Wrong details entered");
					break;
				}
				default:
				{
					System.out.println("Wrong Option selected, Please restart the application");
					sc.close();
					System.exit(0);
				}
			}
		}
		while(choice != 0);
		sc.close();
	}

}
