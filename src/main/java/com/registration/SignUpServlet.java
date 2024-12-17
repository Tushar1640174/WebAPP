package com.registration;
import com.baseclass.*;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public SignUpServlet() {
        System.out.println("Signup Servlet is loaded");
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String uname=request.getParameter("uname");
		String uemail=request.getParameter("uemail");
		String upassword=request.getParameter("upassword");
		
		
		PrintWriter printWriter=response.getWriter();
		
		
		//response.sendRedirect("/JDBC_Servlep_RegistrationAPP/RegistrationSuccessful.html");
		
		
		
		System.out.println("Control under SignUp Servlet");
		try {
			Connection con=JDBCOperations.createConnection();
			User user=new User(uname,uemail,upassword);
			
			boolean b=JDBCOperations.checkAlreadyRegisteredUser(con, user);
			if(b==true)
			{
				response.sendRedirect("/JDBC_Servlep_RegistrationAPP/RegistrationSuccessful.html");
			}
			else
			{
				response.sendRedirect("/JDBC_Servlep_RegistrationAPP/RegistrationFailed.html");
			}
			
		} catch (SQLException e) {
		
			System.out.println("Something went wrong with DB connection.....!!!!!!");
		}
		
		
	}

}
