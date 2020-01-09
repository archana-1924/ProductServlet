package com.deloitte.estore.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.estore.model.Product;
import com.deloitte.estore.service.ProductService;
import com.deloitte.estore.service.ProductServiceImpl;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteProductController extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		int prodId= Integer.parseInt(req.getParameter("pid"));
		ProductService service= new ProductServiceImpl();
		Product p1;
		try {
			p1= service.getProductById(prodId);
			if(service.deleteProduct(p1))
			{
				res.sendRedirect("getall");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
