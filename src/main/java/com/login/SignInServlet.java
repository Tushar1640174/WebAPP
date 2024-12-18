package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baseclass.User;


@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SignInServlet() {
       System.out.println("Sign in servlet loaded");
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("uemail");
		String password=request.getParameter("upassword");
		
		
		try {
			Connection connection=SignInOperations.createConnection();
			User user=new User();
			user.setEmail(email);
			user.setPassword(password);
			
			int i=SignInOperations.checkEmailInDB(connection, user);
			if(i==1)
			{
				response.sendRedirect("/JDBC_Servlep_RegistrationAPP/MainPage.html");
			}
			else if(i==0)
			{
				
			}
			else
			{
				
			}
			
			
		} catch (SQLException e) {
			System.out.println("Something went wrong while creating the connection....");
			
		}
		
		
	}

}
