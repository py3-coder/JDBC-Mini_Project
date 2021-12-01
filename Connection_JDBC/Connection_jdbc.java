/*Author ~ Saurabh Kumar
@copyright 2021
*/
/*Define a Java Class Main and in main method write code to load driver and establish connection
with database.*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_TEST {

	public static void main(String[] args) {
	
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet res=null;
		
		try {
       Class.forName("oracle.jdbc.driver.OracleDriver");
        conn =DriverManager.getConnection(url,"username","password");
       System.out.println("Connection stablished");
       
       /*Write Quarry in this part 
       my database have table student fetching data from student 
       running a simple quarry..*/
      
       /*String sql ="Select * From Student";
       pst=conn.prepareStatement(sql);
       res =pst.executeQuery();
       while(res.next())
    	   System.out.println(res.getInt(1)+" "+res.getString(2));*/
       conn.close();
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver Not found");
		}
		catch(SQLException e) {
			System.out.println("Connection not Found");
		}
	}

}
