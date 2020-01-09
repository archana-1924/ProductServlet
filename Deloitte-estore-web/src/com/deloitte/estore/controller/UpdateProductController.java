package com.deloitte.estore.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.estore.model.Product;
import com.deloitte.estore.service.ProductService;
import com.deloitte.estore.service.ProductServiceImpl;

/**
 * Servlet implementation class UpdateProductController
 */
@WebServlet("/update")
public class UpdateProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pid= Integer.parseInt(request.getParameter("pid"));
		Product p1;
		ProductService ps= new ProductServiceImpl();
		try
		{
			p1= ps.getProductById(pid);	
			request.getSession().setAttribute("product",p1);
			response.sendRedirect("updateTable.jsp");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
