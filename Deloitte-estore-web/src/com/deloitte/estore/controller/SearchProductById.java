package com.deloitte.estore.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deloitte.estore.model.Product;
import com.deloitte.estore.service.ProductService;
import com.deloitte.estore.service.ProductServiceImpl;

/**
 * Servlet implementation class SearchProductById
 */
@WebServlet("/SearchProduct")
public class SearchProductById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductService service= new ProductServiceImpl();
		try
		{
			int productId= Integer.parseInt(request.getParameter("txtprodId"));
			Product product= service.getProductById(productId);
			request.getSession().setAttribute("product",product);
			response.sendRedirect("search-product.jsp");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
