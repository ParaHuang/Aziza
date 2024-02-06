package com.amazon.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.amazon.dao.UserDao;


//this is the annotation for the url of this Servelt
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//String theValue = request.getParameter("the name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String location = request.getParameter("location");
		UserDao dao = new UserDao();
		int row = dao.addUser(username, password, phoneNumber, name, email, location);
		if(row>0){
			//out.println("add user Successfully");
			//response to a differet page
			response.sendRedirect("userManagement.jsp");
		}else{
			//get the output stream of response
			PrintWriter out = response.getWriter();//in jsp, this code will be generated 
			//therefore, in jsp , we can use out directrly
			//but in Servelt, we have to write that code by ourselves
			out.println("failed");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
