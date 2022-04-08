import java.sql.*;
import java.util.*;
class PreparedStmt
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
PreparedStatement ps=con.prepareStatement("insert into emp values(?,?,?)");
Scanner s=new Scanner(System.in);
int empno=s.nextInt();
String ename=s.next();
int age=s.nextInt();
ps.setInt(1,empno);
ps.setInt(3,age);
ps.setString(2,ename);
ps.executeUpdate();
}
catch(Exception e)
{
System.out.println(e);
}
}
}