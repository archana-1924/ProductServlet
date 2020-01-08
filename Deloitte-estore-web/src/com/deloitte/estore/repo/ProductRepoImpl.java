package com.deloitte.estore.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.deloitte.estore.model.Product;

public class ProductRepoImpl implements ProductRepo{

	@Override
	public boolean addProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
	    Connection con= getDbConnection();
		PreparedStatement pstmt= con.prepareStatement("insert into product values (?,?,?)");
		pstmt.setInt(1, product.getProductId());
		pstmt.setString(2, product.getProductName());
		pstmt.setFloat(3, product.getPrice());
		
		return pstmt.executeUpdate()>0;
		
	}

	@Override
	public boolean deleteProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		Connection con= getDbConnection();
		PreparedStatement pstmt = con.prepareStatement("delete from product where pid=?");
		pstmt.setInt(1, product.getProductId());
		
		return pstmt.executeUpdate()>0;
		
	}

	@Override
	public boolean updateProduct(Product product) throws Exception {
		Connection con= getDbConnection();
		PreparedStatement psmt1 = con.prepareStatement("update product set pname=?, price =? where pid=?");
		psmt1.setString(1, product.getProductName());
		psmt1.setFloat(2, product.getPrice());
		psmt1.setInt(3, product.getProductId());
		
	    return psmt1.executeUpdate()>0;	
	}

	@Override
	public Product getProductById(int productId) throws SQLException {
        Connection con= getDbConnection();
        PreparedStatement pstmt= con.prepareStatement("select * from product where pid=?" );
        pstmt.setInt(1, productId);
        ResultSet rs= pstmt.executeQuery();
        if(rs.next())
        {
        Product prod= new Product();
        prod.setProductId(productId);
        prod.setProductName(rs.getString("pname"));
        prod.setPrice(rs.getFloat("price"));
	    return prod;
        }
        return null;
	}

	@Override
	public List<Product> getAllProducts() throws Exception {
		Connection con= getDbConnection();
		List<Product> prod= new ArrayList<>();
		PreparedStatement pstmt= con.prepareStatement("select * from product");
		ResultSet rs= pstmt.executeQuery();
		while(rs.next())
		{
			Product product= new Product();
			 product.setProductId(rs.getInt("pid"));
		     product.setProductName(rs.getString("pname"));
		     product.setPrice(rs.getFloat("price"));
            prod.add(product);
		}
		return prod;
	}

	@Override
	public Connection getDbConnection() throws SQLException {
		Connection con= DriverManager.getConnection(
				        "jdbc:oracle:thin:@localhost:1521:xe",
				        "system", "admin"
				        );
		return con;
		
	}
 
}
