package Practice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver class loaded");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b200","root","@Akash2003");
		System.out.println("Connection Established");
		
		String insertData = "select * from student";
		String deleteData = "delete from student where roll=41";
		
		Statement smt = con.createStatement();
		smt.execute(deleteData);
		ResultSet rs = smt.executeQuery(insertData);
		
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
			System.out.println("-------------------");
		}
		
		smt.close();
		con.close();

	}

}
