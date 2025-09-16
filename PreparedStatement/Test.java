package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
	
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b200","root","@Akash2003");
		System.out.println("Connection Established");
		
		String insertData = "insert into student values (?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(insertData);
		
//		System.out.println("Enter roll number:");
		ps.setInt(1, 111);
//		System.out.println("Enter name:");
		ps.setString(2, "Zoro");
		ps.setFloat(3, 90.01f);
		
		ps.execute();
		
		ps.close();
		con.close();
		
	}
}
