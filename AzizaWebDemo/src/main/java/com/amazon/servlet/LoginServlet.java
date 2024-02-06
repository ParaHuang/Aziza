package com.amazon.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.amazon.dao.UserDao;


public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.obtain the username and password come with request
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2.use those two information, to check database
		//to see if they exist
		UserDao dao = new UserDao();
		boolean result = dao.loginByUsernamePassword(username,password);
		
		
		if(result) {
			//3.if exist, go to main page
			response.sendRedirect("userManagement.jsp");
		}else {
			//4.otherwise, show error message in the browser
			//get the output stream of response
			PrintWriter out = response.getWriter();
			out.println("invalid username or password");
		
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
