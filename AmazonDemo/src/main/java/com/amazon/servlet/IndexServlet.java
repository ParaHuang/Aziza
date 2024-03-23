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

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("page");//null
		int start = 0;
		if(page!=null) {
			int p = Integer.parseInt(page);
			start = (p-1)*10;
		}
		int count = 10;
		ProductDao dao = new ProductDao();
		List<Product> list = dao.queryAllProducts(start,count);
		req.setAttribute("list", list);
		int totalCount = dao.getTotalCounts();
		int totalPages = totalCount/count;
		if(totalCount%count>0) {
			totalPages+=1;
		}
		req.setAttribute("totalPages", totalPages);
		
		//redirect
//		resp.sendRedirect("index.jsp");
		//forward
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
