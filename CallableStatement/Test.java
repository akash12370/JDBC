package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
public static void main(String[] args) throws ClassNotFoundException,SQLException{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/b200","root","@Akash2003");
	
	CallableStatement cs = con.prepareCall("{call m_data(?,?,?,?)}");
	
	cs.setInt(1, 160);
	cs.setString(2, "Lovely Singh");
	cs.setInt(3, 50);
	cs.setInt(4, 159);
	
	cs.execute();
	cs.close();
	System.out.println("Stored procedure called..");
	
	
}
}
