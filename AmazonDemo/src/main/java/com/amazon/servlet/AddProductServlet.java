package com.amazon.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import com.amazon.dao.ProductDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		//save the picture in server
		Part p = req.getPart("picture");
		System.out.println(p.getSubmittedFileName());
//		p.write("/Users/parahuang/Desktop/Mike/x.png");
		//get the server path of this application
		String root = req.getServletContext().getRealPath("");
		//try to give the file you uploaded a unique name
		String picName = p.getSubmittedFileName();
		String suffix = picName.substring(picName.lastIndexOf("."));
		String uniqueName = UUID.randomUUID().toString()+suffix;
		//all product pictures are saved in upload
		p.write(root+"/upload/"+uniqueName);
		System.out.println(root);
		
		//save all information including picture path into database
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String description = req.getParameter("description");
		System.out.println(name);
		System.out.println(price);
		System.out.println(description);
		
		ProductDao dao = new ProductDao();
		int row = dao.addProduct(name,price,uniqueName,description);
		PrintWriter out = resp.getWriter();
		if(row>0) {
			out.print("upload product successfully. <a href='login.jsp'>back to login</a>");
		}else {
			out.print("failed");
		}
		
		out.flush();
		out.close();
	}
}













