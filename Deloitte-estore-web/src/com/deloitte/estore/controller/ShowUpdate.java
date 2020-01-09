package com.deloitte.estore.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.estore.model.Product;
import com.deloitte.estore.service.ProductService;
import com.deloitte.estore.service.ProductServiceImpl;

/**
 * Servlet implementation class ShowUpdate
 */
@WebServlet("/ShowUpdate")
public class ShowUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int productId= Integer.parseInt(request.getParameter("uid"));
		String productName= request.getParameter("uname");
		float productPrice= Float.parseFloat(request.getParameter("uprice"));
		Product p1= new Product(productId,productName,productPrice);
		ProductService ps= new ProductServiceImpl();

		try {
			if(ps.updateProduct(p1))
			{
				response.sendRedirect("getall");
				//response.getWriter().println("<h1>Updated Product<h1>");
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
