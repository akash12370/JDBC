package ResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayData {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
	
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b200","root","@Akash2003");
		System.out.println("Connection Established");
		
		String displayData = "select * from student";
		
		Statement smt = con.createStatement();
		
		ResultSet rs = smt.executeQuery(displayData);
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
			System.out.println("-------------------------");
		}
		
		smt.close();
		con.close();
		
		

	}

}
