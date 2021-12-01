/*Author ~ Saurabh Kumar
@Copyright 2021
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC2 {
	public static void main(String[] args) throws SQLException {
		Connection con =null;
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		PreparedStatement pst =null;
		ResultSet res=null;
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
      ///user and password according to your database
		con =DriverManager.getConnection(url,"user","password");
		 System.out.println("Connection stablished.");
		
		String sql="Insert All "+
		            "into Student values(100,'Ann','Electronics',70.5) "+
				     "into Student values(101,'Ben','Computers',71.3) "+
				     "into Student values(102,'Ken','Mech',60 ) "+
				     "into Student values(103,'Ram','Computers',90) "+
				     "into Student values(104,'Bhim','Mech',72) "+
				     "into Student values(105,'Shyam','Computers',86) "+
				     "Select * From dual ";
		
		 pst=con.prepareStatement(sql);
	     res =pst.executeQuery();
		System.out.println("6 row inserted");
		con.close();
		
		}
		catch(ClassNotFoundException e) {
		 System.out.println("No driver found");	
		}

	}

}


