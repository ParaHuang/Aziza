package com.amazon.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.amazon.bean.User;
import com.amazon.dao.UserDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.obtain the username and password come with request
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2.use those two information, to check database
		//to see if they exist
		UserDao dao = new UserDao();
		User user = dao.loginByUsernamePassword(username,password);
		
		
		//getXxx   setXxx
		if(user!=null) {
			//3.if exist, save user infomation into session,go to main page
			//get session
			HttpSession session = request.getSession();
			//save infomation in session
//			session.setAttribute("name of infoamtion", infomation you want to save);
//			session.setAttribute("name", user.getName());
			session.setAttribute("user", user);
//			session.setAttribute("hello", "new infomation");
			
			//save personal infomation in cookie
			Cookie cookie1 = new Cookie("username", username);
			Cookie cookie2 = new Cookie("password", password);
			cookie1.setMaxAge(7*24*3600*1000);
			cookie2.setMaxAge(7*24*3600*1000);
			
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			response.sendRedirect("IndexServlet");//put this in the end
		}else {
			//4.otherwise, show error message in the browser
			//get the output stream of response
			PrintWriter out = response.getWriter();
			out.println("invalid username or password");
		
		}
	}

}
