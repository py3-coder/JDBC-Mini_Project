/*
Author ~ Saurabh
Step 02 : Inserting same data to table for operation
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Menu_JDBC_Insert {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws SQLException {
		Connection con =null;
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		PreparedStatement pst =null;
		ResultSet res=null;
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
      //user and password of worksapce in orcale
		con =DriverManager.getConnection(url,"user","password");
		 System.out.println("Connection stablished.");
		
		String sql="Insert All "+
		            "into  Employee values(100,'Harish',28000) "+
				     "into Employee values(101,'Vijay',25000) "+
				     "into Employee values(102,'Ajay',31000) "+
				     "Select * From dual ";
		
		 pst=con.prepareStatement(sql);
	     res =pst.executeQuery();
		System.out.println("3 row inserted");
		con.close();
		
		}
		catch(ClassNotFoundException e) {
		 System.out.println("No driver found");	
		}

	}

}


