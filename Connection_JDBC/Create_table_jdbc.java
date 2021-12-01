/*Author ~ Saurabh Kumar
@Copyright 2021*/
 


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC1 {
	public static void main(String[] args) throws SQLException {
		Connection con =null;
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		PreparedStatement pst =null;
		ResultSet res=null;
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
			//user password ---taken care
		con =DriverManager.getConnection(url,"user","password");
		 System.out.println("Connection stablished.");
		
		String sql="Create Table Student "+"(studentId int Not null Primary key ,"+ "StudentName varchar(10),"+"Branch varchar(20), "+"Percentage double precision )";
		
		 pst=con.prepareStatement(sql);
	     res =pst.executeQuery();
		System.out.println("Table Student Created");
		
		}
		catch(ClassNotFoundException e) {
		 System.out.println("No driver found");	
		}

	}

}
