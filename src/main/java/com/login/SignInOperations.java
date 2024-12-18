package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.baseclass.User;

public class SignInOperations 

{
	static
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			System.out.println("Something wrong with JDBC Driver....");
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
	
	public static int checkEmailInDB(Connection connection, User user) throws SQLException
	{
		String query="select * from users where email=?";
		PreparedStatement ps1=connection.prepareStatement(query);
		ps1.setString(1, user.getEmail());
		ResultSet rs1=ps1.executeQuery();
		if(rs1.next())
		{
			String password=rs1.getString(4);
			if(password.equals(user.getPassword()))
			{
				System.out.println("You are registered with us....user should be allowed to login");
				return 1;
			}
			else
			{
				System.out.println("User entered wrong password, Please ask user to re-enter the password");
				return -1;
			}
		}
		else
		{
			System.out.println("You are not registered with us, Please register first");
			return 0;
		}
	}
}
