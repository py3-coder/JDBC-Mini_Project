/* 
Author ~ Saurabh
Main file of operation in Database...
Menu Driven
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
public class DBOperations {
	
	public static Connection establishConnection() throws SQLException {
		Connection conn=null;
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
    ///enter your user and password
		String user="--------";
		String password="-------";
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn =DriverManager.getConnection(url, user, password);
		
		}
		catch(ClassNotFoundException e) {
		System.out.println("Driver Not Found");	
		}
		return conn;
	}
	@SuppressWarnings("unused")
	public void store() throws SQLException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		PreparedStatement pst =null;
		Connection conn =null;
		conn =establishConnection();
		ResultSet res=null;
		if(conn != null) {
			System.out.println("Enter Data:");
	        System.out.println("Enter id: ");
	        String id1 =sc.nextLine();
	        int id =Integer.parseInt(id1);
	        System.out.println("Enter Name:");
	        String name=sc.nextLine();
	        System.out.println("Enter Salary:");
	        double salary=sc.nextDouble();
			String sql ="Insert into Employee"+" values ("+id+","+"'"+name+"'"+","+salary+" )";
			
			pst=conn.prepareStatement(sql);
			res=pst.executeQuery();
			System.out.println("------Stored Successfully-------");
		}
		else{
			System.out.println("Check Connection .. Not Found");
		}
		
	}
	@SuppressWarnings("unused")
	public static boolean IDindb(int id) throws SQLException {
		Connection conn =establishConnection();
		PreparedStatement pst =null;
		ResultSet res=null;
		if(conn != null) {
			String sql ="Select EMPLOYEE_ID from EMPLOYEE "+" where EMPLOYEE_ID="+id;
			return true;
		}
		return false;
	}
	@SuppressWarnings({ "unused", "resource" })
	public int updateSalary( ) throws SQLException {
		Connection conn =establishConnection();
		PreparedStatement pst =null;
		Scanner sc = new Scanner(System.in);
		ResultSet res=null;
		if(conn != null) {
			System.out.println("Enter Id:");
			int id = sc.nextInt();
	        System.out.println("Enter Salary:");
			double salary =sc.nextDouble();
			if(IDindb(id)==true) {
			String sql ="Update Employee "+" Set EMPLOYEE_SALARY= "+salary+" where  EMPLOYEE_ID ="+id;
			pst=conn.prepareStatement(sql);
			res=pst.executeQuery();
			System.out.println("Salary updated of Id:"+id);
			return 1;
			}
		}
		else {
			System.out.println("Check Connection .. Not Found");
		}
		return -1;
		
	}
	@SuppressWarnings("unused")
	public int deletebyID() throws SQLException {
		Connection conn =establishConnection();
		PreparedStatement pst =null;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		ResultSet res=null;
		if(conn != null) {
			System.out.println("Enter id");
			int id =sc.nextInt();
			if(IDindb(id)==true) {
			String sql ="Delete From Employee"+" where EMPLOYEE_ID="+id;
			pst=conn.prepareStatement(sql);
			res=pst.executeQuery();
			System.out.println("Data deleted of Id:"+id);
			return 1;
			}
		}
		else {
			System.out.println("Check Connection .. Not Found");
		}
		return -1;
	}
	@SuppressWarnings("resource")
	public int fetchbyID( ) throws SQLException {
		Connection conn =establishConnection();
		PreparedStatement pst =null;
		Scanner sc = new Scanner(System.in);
		ResultSet res=null;
		if(conn != null) {
			System.out.println("Enter id");
			int id =sc.nextInt();
			if(IDindb(id)==true) {
			String sql ="Select * From Employee"+" where EMPLOYEE_ID="+id;
			pst=conn.prepareStatement(sql);
			res=pst.executeQuery();
			while(res.next())
				System.out.println(res.getInt("EMPLOYEE_ID")+" "+res.getString("EMPLOYEE_NAME")+" "+res.getDouble("EMPLOYEE_SALARY"));
			return 1;
			}
		}
		else {
			System.out.println("Check Connection .. Not Found");
		}
		return -1;
	}
	public void  Menu() {
		System.out.println("1: Store");
		System.out.println("2: Display by id");
		System.out.println("3: Delete by id");
		System.out.println("4: Update salary by id");
		System.out.println("5: Exit");
		System.out.println("Enter options:-");
	}
	
	@SuppressWarnings("resource")
	public static boolean selectOption(DBOperations obj) throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		obj.Menu();
		int option=sc.nextInt();
	    switch(option) {
	    case 1:
	    	obj.store();
	    	selectOption(obj);
	    	break;
	    case 2:
	    	obj.fetchbyID();
	    	selectOption(obj);
	    	break;
	    case 3:
	    	obj.deletebyID();
	    	selectOption(obj);
	    	break;
	    case 4:
	    	obj.updateSalary();
	    	selectOption(obj);
	    	break;
	    case 5:
	    	return true;
	    
	    }
	    return false;
	}
	
	
	public static void main(String[] args) throws SQLException {
		DBOperations obj = new DBOperations();
		selectOption(obj);
		System.out.println("End of Menu");
		
	}

}
