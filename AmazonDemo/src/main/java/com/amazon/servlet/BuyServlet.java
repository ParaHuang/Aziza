package com.amazon.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.amazon.bean.User;
import com.amazon.dao.OrderDao;

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
		User u = (User) session.getAttribute("user");
		String username = u.getUsername();
		
		//productno,price(in detail.jsp) 
		String pNo = req.getParameter("pNo");
		String price = req.getParameter("price");
		
		//user addOrder() of OrderDao
		int rows = new OrderDao().addOrder(username, pNo, price);
		//output information to client directly
		PrintWriter out = resp.getWriter();
		if(rows>0) {
			out.println("<h1 style='color:green'>purchased successfully!</h1><a href='IndexServlet'>click here keep shopping</a>");
		}else {
			out.println("<h1 style='color:red'>failed</h1>");
		}
		out.flush();
		out.close();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}

