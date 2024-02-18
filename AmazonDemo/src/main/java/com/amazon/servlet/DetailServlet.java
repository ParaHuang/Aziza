package com.amazon.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.amazon.bean.Product;
import com.amazon.bean.User;
import com.amazon.dao.ProductDao;
import com.amazon.dao.UserDao;

@WebServlet("/detail.htm")
public class DetailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.get the product no
		String no = req.getParameter("no");
		
		//2.get the product object by no(query database)
		ProductDao dao = new ProductDao();
		Product p = dao.queryProductByNo(no);		
		
		//3.save product object in request then forward it into detail.jsp
		req.setAttribute("product", p);
		req.getRequestDispatcher("detail.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
