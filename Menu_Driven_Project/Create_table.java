/*
Author ~ Saurabh
Step 01:Creating table Employee 
*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Menu_JDBC {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws SQLException {
		Connection con =null;
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		PreparedStatement pst =null;
		ResultSet res=null;
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
      //user and password
		con =DriverManager.getConnection(url,"user","password");
		 System.out.println("Connection stablished.");
		
		String sql="Create Table Employee "+"(EMPLOYEE_ID int Not null Primary key ,"+ "EMPLOYEE_NAME varchar(20),"+"EMPLOYEE_SALARY double precision)";
		
		 pst=con.prepareStatement(sql);
	     res =pst.executeQuery();
	     con.close();
		System.out.println("Table Student Created");
		
		}
		catch(ClassNotFoundException e) {
		 System.out.println("No driver found");	
		}
	} 
}
