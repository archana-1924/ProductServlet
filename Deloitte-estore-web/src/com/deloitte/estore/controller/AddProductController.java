package com.deloitte.estore.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.estore.model.Product;
import com.deloitte.estore.service.ProductService;
import com.deloitte.estore.service.ProductServiceImpl;

@WebServlet("/addproduct")
public class AddProductController extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws NumberFormatException 
	{
		
		int productId= Integer.parseInt(req.getParameter("txtpid"));
		String productName= req.getParameter("txtname");
		float productPrice= Float.parseFloat(req.getParameter("txtprice"));
		Product p1= new Product(productId,productName,productPrice);
		ProductService ps= new ProductServiceImpl();

		try {
			if(ps.addProduct(p1))
			{
				res.sendRedirect("getall");
			}
			else
			{
				res.sendRedirect("error.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
