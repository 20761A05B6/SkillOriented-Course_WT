import java.sql.*;
import java.util.*;
class UserPassword
{
	public static void main(String args[]) throws SQLException,ClassNotFoundException
	{
	try
	{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	System.out.println("Loaded");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","IPC116","IPC116");
	System.out.println("Established");
	Scanner s=new Scanner(System.in);
	System.out.println("Enter employee id");
	int empno=s.nextInt();
	Statement sct=con.createStatement();
	String sql="SELECT * from emp";
	ResultSet rs=sct.executeQuery(sql);
	boolean result=false;
	while(rs.next())
	{
		//to check rows line by line until all records are completed
		//verify input with emp number
		if(empno==rs.getInt(1))
		{
			System.out.println("You are valid user");
			System.out.println("Hello, "+rs.getString(2));
			result=true;
			break;
		}
	}
	if(result==false)
	{
		System.out.println("Invalid User");
	}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
}