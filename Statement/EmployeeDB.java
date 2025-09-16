package Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDB {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver class loaded");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b200","root","@Akash2003");
		System.out.println("Connection established");
		
		
		String insertData = "insert into employee values (101,'aman',20000),(102,'akash',21000),(103,'gargi',25000),(104,'Shakti',51000),(105,'rushab',12000),(106,'luffy',24000),(107,'zoro',14000),(108,'naruto',54000),(109,'jumbo',45000),(110,'suzy',14000)";
		System.out.println("Data Inserted");
		
//		String insert = "insert into employee values (103,'suzy',25000),(104,'Shakti',51000),(105,'rushab',12000),(106,'luffy',24000),(107,'zoro',14000),(108,'naruto',54000),(109,'jumbo',45000)";
		
		String updateData = "update employee set eid=110 where eid=105";
		System.out.println("Data updated");
		
		String deleteData = "delete from employee where eid=104";
		System.out.println("Data deleted");
		
		Statement smt = con.createStatement();
		System.out.println("References created");
		
//		smt.execute(insertData);
//		System.out.println("Insert query executed");
		
		boolean status = smt.execute(updateData);
		System.out.println(status);
		System.out.println("Update query executed");
		
		smt.execute(deleteData);
		System.out.println("Delete query executed");
		

		

		
		smt.close();
		con.close();

	}

}
