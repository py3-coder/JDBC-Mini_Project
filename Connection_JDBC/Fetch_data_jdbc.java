/*
Author ~ Saurabh
@Copyright 2021
*/
///Fetch data from table

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;
@SuppressWarnings("unused")
public class JDBC3 {
public static void main(String args[]) throws SQLException{
	
	Connection conn =null;
	String url ="jdbc:oracle:thin:@localhost:1521:xe";
	PreparedStatement pst =null;
	ResultSet res=null;
	
	try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
    //user and password
	conn =DriverManager.getConnection(url,"user","password");
	System.out.println("Connection Stablished");
	
	String sql ="Select * From Student "+" Where BRANCH='Computers' and PERCENTAGE > 85 ";
	pst = conn.prepareStatement(sql);
	res =pst.executeQuery();
	while(res.next()) {
		System.out.println(res.getInt("STUDENTID")+" "+res.getString("STUDENTNAME")+" "+res.getString("BRANCH")+" "+res.getInt("PERCENTAGE"));
	}
	conn.close();
	
	}
	catch(ClassNotFoundException e) {
		System.out.print("Driver Not Found");
	}
}
}
