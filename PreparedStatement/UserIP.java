package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserIP {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		Scanner s = new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
	
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b200","root","@Akash2003");
		System.out.println("Connection Established");
		
		String insertData = "insert into student values (?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(insertData);
		
		System.out.println("Enter roll number:");
		ps.setInt(1,s.nextInt());
		
		System.out.println("Enter name:");
		ps.setString(2,s.nextLine()+s.next());
		
		System.out.println("Enter marks:");
		ps.setInt(3,s.nextInt());
		
		ps.execute();
		
		ps.close();
		con.close();

	}

}
