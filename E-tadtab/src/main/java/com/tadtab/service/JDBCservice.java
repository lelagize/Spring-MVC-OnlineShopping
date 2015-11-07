package com.tadtab.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.tadtab.top.Product;

public class JDBCservice {
	
	private DataSource dataSource;
	
	@Autowired
	public JDBCservice(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	public void insert(Product product){
		String sql = "INSERT INTO Product (productName, productPrice) " + "values(?,?)";
		
		Connection con = null;
		try{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getProductName());
			ps.setFloat(2, product.getProductPrice());
			ps.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(con != null){
				try{
					con.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}
	

	
	public Product retrievePro(int id){
		
		String sql = "SELECT * FROM product where productId=?";
		Connection con = null;
		
		try{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			Product product = null;
			ResultSet rs = ps.getResultSet();
			System.out.println("creating ...");
			if(rs.next()){
				product = new Product();
				product.setProductName(rs.getString("productName"));
				product.setProductPrice(rs.getFloat("productPrice"));
			}
			
			rs.close();
			ps.close();
			return product;
		}catch(SQLException e){
			e.printStackTrace();
			 throw new RuntimeException(e);
		}finally{
			if(con != null){
				try{
					con.close();
				}catch(SQLException e){
						
			}
		}
		
		
		
	}
		}

	public void delete(Product product){
		String sql = "DELETE FROM product WHERE productId=?";
		Connection con = null;
		try{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setFloat(1, product.getProductId());
			ps.execute();
			ps.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			if(con != null){
				try{
					con.close();
				}catch(SQLException e){}
			}
		}
	}
	
	public void update(Product product){
		String sql = "UPDATE product SET productName = ?, productPrice = ?, where productPrice = ?";
				
		Connection con = null;
		try{
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getProductName());
			ps.setFloat(2, product.getProductPrice());
			ps.setInt(3, product.getProductId());
			ps.execute();
		}catch(SQLException e){
			throw new RuntimeException();
		}finally{
			if(con != null){
				try{
					con.close();
				}catch(SQLException e){}
			}
		}
	}
	
}
