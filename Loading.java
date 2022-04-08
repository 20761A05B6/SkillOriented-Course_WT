import java.sql.*;
import java.util.*;
class Loading
{
public static void main(String args[]) throws SQLException,ClassNotFoundException
{
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
System.out.println("Loaded");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","IPC116","IPC116");
System.out.println("Established");
		Statement sct=con.createStatement();
Scanner s=new Scanner(System.in);
String sql="SELECT * from college";
	ResultSet rs=sct.executeQuery(sql);
	boolean result=false;
	int block=s.nextInt();
		while(rs.next())
	{
		//to check rows line by line until all records are completed
		//verify input with emp number
		if(block==rs.getInt(1))
		{
			System.out.println("Valid block number");
			System.out.println("Welcome to, "+rs.getString(2));
			result=true;
			break;
		}
	}
	if(result==false)
	{
		System.out.println("Invalid branch");
	}
}
catch(Exception e)
{
System.out.println(e);
}
}
}