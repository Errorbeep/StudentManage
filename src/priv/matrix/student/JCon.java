package priv.matrix.student;

import java.sql.*;
//import org.junit.Test;

public class JCon 
{
	//@Test
	
	public  static Connection  getConnection()
	//public  void  getConnection()
	{
		String connection = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "student_info";
		String password = "student_info";
		
		Connection con = null;
		
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("驱动加载失败!");
			e.printStackTrace();
		}
		
		System.out.println("驱动加载成功!");
		try 
		{
			con = DriverManager.getConnection(connection, username, password);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("连接失败!");
			e.printStackTrace();
		}
		
		return con;
		
	}
	

}
