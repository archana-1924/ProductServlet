package com.deloitte.estore.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deloitte.estore.model.Product;
import com.deloitte.estore.service.ProductService;
import com.deloitte.estore.service.ProductServiceImpl;

@WebServlet("/getall")
public class GetAllProductsController extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	{
		ProductService service= new ProductServiceImpl();
		try
		{
			List<Product> products= service.getAllProducts();
			System.out.println(products);
			HttpSession ssn= req.getSession();
			ssn.setAttribute("products", products);
			res.sendRedirect("showall.jsp");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
