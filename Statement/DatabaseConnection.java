package Statement;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver class loaded");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/b200","root","@Akash2003");
		System.out.println("Connection Established");

		String insertData = "insert into student values (101,'Akash',67),(102,'Gargi',69),(103,'Mayur',55)";
		System.out.println("Query constructed");
		
		String deleteData = "delete from student where roll=102";
		System.out.println("Delete query executed");
		
		String updateData = "update student set roll=104 where roll=103";
		System.out.println("Update query executed");
		
		Statement smt = con.createStatement();
		System.out.println("REf created");
		
//		smt.execute(insertData);
//		System.out.println("Insert query Submitted");
		
//		smt.execute(deleteData);
//		System.out.println("Delete query submitted");
		
		smt.execute(updateData);
		
		smt.close();
		con.close();
		System.out.println("Resources closed");
	}

}
