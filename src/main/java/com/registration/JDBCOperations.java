package com.registration;
import com.baseclass.*;
import java.sql.*;

public class JDBCOperations {

	
	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("JDBC Driver loaded");
		} catch (ClassNotFoundException e) {
			System.out.println("Something is wrong with the JDBC Driver");
		}
	}
	
	public static Connection createConnection() throws SQLException
	{
		String url="jdbc:mysql://localhost:3306/onlineAppDB";
		String user="root";
		String password="Batra82@";
		
		Connection connection=DriverManager.getConnection(url,user,password);
		System.out.println("Connection created...");
		return connection;
	}
	
	public static boolean registerUser(Connection connection,User user) throws SQLException
	{
		String query="insert into users(pk,name,email,password) values(?,?,?,?);";
		PreparedStatement ps=connection.prepareStatement(query);
		ps.setLong(1, user.getPk());
		ps.setString(2, user.getName());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getPassword());
		
		int i=ps.executeUpdate();
		if(i==1)
		{
			System.out.println("User is registered successfully");
			return true;
		}
		else
		{
			System.out.println("There is some issue with the system");//connection issue
			return false;
		}
		
		
	}
	
	public static boolean checkAlreadyRegisteredUser(Connection connection,User user)throws SQLException
	{
		String query="select email from users where email=?; ";
		PreparedStatement ps=connection.prepareStatement(query);
		ps.setString(1, user.getEmail());
		
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			if(user.getEmail().equals(rs.getString(1)))
			{
				System.out.println("User is already registered");
				return false;
			}
			else
			{
				return true;
			}
		}
		else
		{
			registerUser(connection, user);
			return true;
		}
		
		
		
		
		
		
	}
}
