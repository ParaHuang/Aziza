package com.amazon.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.amazon.bean.Order;
import com.amazon.bean.User;
import com.amazon.dao.OrderDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/order.html")
public class OrderServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("user");
		List<Order> list = new OrderDao().getOrdersByUsername(u.getUsername());
		req.setAttribute("orderList", list);
		req.getRequestDispatcher("order.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}

