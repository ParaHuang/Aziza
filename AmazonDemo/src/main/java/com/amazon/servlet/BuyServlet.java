package com.amazon.servlet;

import java.io.IOException;

import com.amazon.bean.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//username(from session)
		HttpSession session = req.getSession();
		//get user object by the name in session
		User u= (User) session.getAttribute("user");
		System.out.println(u.getUsername());
		//productno,price(in detail.jsp) 
		String pNo = req.getParameter("pNo");
		String price = req.getParameter("price");
		
		System.out.println("a request comes from client by location.href");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}

