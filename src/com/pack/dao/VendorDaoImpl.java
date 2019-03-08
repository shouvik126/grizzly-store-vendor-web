package com.pack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pack.DBUtility;
import com.pack.model.Login;
import com.pack.model.Product;
import com.pack.model.Profile;

public class VendorDaoImpl implements VendorDao {

	@Override
	public Login fetchLogin(String usr, String pass) {
		Connection con=null;
		PreparedStatement ps=null;
		Login l=null;
		try
		{
			//con=DbUtility.getConnection();
			con=DBUtility.getDatasourse().getConnection();
			con.setAutoCommit(false);
			ps=con.prepareStatement("select id,password,status,usertype from login where id=? and password=?");
			ps.setString(1, usr);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				l=new Login();
				l.setId(rs.getString("id"));
				l.setPassword(rs.getString("password"));
				l.setStatus(rs.getString("status"));
				l.setUsertype(rs.getString("usertype"));
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally{
			try{
				if(con!=null)
				{
					con.close();
					ps.close();
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		return l;
	}
	
	@Override
	public Login fetchLoginByUser(String usr) {
		Connection con=null;
		PreparedStatement ps=null;
		Login l=null;
		try
		{
			//con=DbUtility.getConnection();
			con=DBUtility.getDatasourse().getConnection();
			con.setAutoCommit(false);
			ps=con.prepareStatement("select id,password,status,usertype from login where id=?");
			ps.setString(1, usr);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				l=new Login();
				l.setId(rs.getString("id"));
				l.setPassword(rs.getString("password"));
				l.setStatus(rs.getString("status"));
				l.setUsertype(rs.getString("usertype"));
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally{
			try{
				if(con!=null)
				{
					con.close();
					ps.close();
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		return l;
	}
	
	@Override
	public int setLoginStatus(Login l) {
		int i=0;
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			//con=DbUtility.getConnection();
			con=DBUtility.getDatasourse().getConnection();
			con.setAutoCommit(false);
			//String status=l.getStatus();
			String status="nvalid";
			String sql="update login set status='invalid' where id=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, l.getId());
			i=ps.executeUpdate();
			con.commit();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally{
			try{
				if(con!=null)
				{
					con.close();
					ps.close();
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		return i;
	}
	
	@Override
	public Profile fetchProfile(String usr) {
		Connection con=null;
		PreparedStatement ps=null;
		Profile p=null;
		try
		{
			con=DBUtility.getDatasourse().getConnection();
			con.setAutoCommit(false);
			System.out.println(usr);
			ps=con.prepareStatement("select id,firstname,middlename,lastname,designation,address,contact from profile where id=?");
			ps.setString(1, usr);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				p=new Profile();
				p.setId(rs.getString("id"));
				p.setFirstname(rs.getString("firstname"));
				p.setMiddlename(rs.getString("middlename"));
				p.setLastname(rs.getString("lastname"));
				p.setDesignation(rs.getString("designation"));
				p.setAddress(rs.getString("address"));
				p.setContact(rs.getInt("contact"));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try
			{
				if(con!=null)
				{
					con.close();
					ps.close();
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		return p;
	}
	
	@Override
	public List<Product> fetchProduct(String id) {
		Connection con=null;
		PreparedStatement ps=null;
		List<Product> li=new ArrayList<>();
		Product p=null;
		
		try
		{
			//con=DbUtility.getConnection();
			con=DBUtility.getDatasourse().getConnection();
			con.setAutoCommit(false);
			ps=con.prepareStatement("select p.pid,p.productname,p.brand,p.category,p.rating,p.description,p.price,p.discount,i.usrid,i.instock,i.buffer,i.pending from product p,inventory i where p.pid=i.pid and i.usrid=?");
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				p=new Product();
				p.setPid(rs.getString("pid"));
				p.setProductname(rs.getString("productname"));
				p.setBrand(rs.getString("brand"));
				p.setCategory(rs.getString("category"));
				p.setRating(rs.getDouble("rating"));
				p.setDescription(rs.getString("description"));
				p.setPrice(rs.getDouble("price"));
				p.setDiscount(rs.getInt("discount"));
				p.setUserid(rs.getString("usrid"));
				p.setInstock(rs.getInt("instock"));
				p.setBuffer(rs.getInt("buffer"));
				p.setPending(rs.getInt("pending"));
				
				li.add(p);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally{
			try{
				if(con!=null)
				{
					con.close();
					ps.close();
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		return li;
	}
	@Override
	public Product fetchProductByPid(String p) {
		Connection con=null;
		PreparedStatement ps=null;
		Product pr=null;
		try
		{
			//con=DbUtility.getConnection();
			con=DBUtility.getDatasourse().getConnection();
			con.setAutoCommit(false);
			ps=con.prepareStatement("select p.pid,p.productname,p.brand,p.category,p.rating,p.description,p.price,p.discount,i.usrid,i.instock,i.buffer,i.pending from product p,inventory i where p.pid=i.pid and p.pid=?");
			ps.setString(1, p);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				pr=new Product();
				pr.setPid(rs.getString("pid"));
				pr.setProductname(rs.getString("productname"));
				pr.setBrand(rs.getString("brand"));
				pr.setCategory(rs.getString("category"));
				pr.setRating(rs.getDouble("rating"));
				pr.setDescription(rs.getString("description"));
				pr.setPrice(rs.getDouble("price"));
				pr.setDiscount(rs.getInt("discount"));
				pr.setUserid(rs.getString("usrid"));
				pr.setInstock(rs.getInt("instock"));
				pr.setBuffer(rs.getInt("buffer"));
				pr.setPending(rs.getInt("pending"));
				
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally{
			try{
				if(con!=null)
				{
					con.close();
					ps.close();
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		return pr;
	}
	
	@Override
	public int removeProductByPid(String p) {
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		int i=0;
		try
		{
			//con=DbUtility.getConnection();
			con=DBUtility.getDatasourse().getConnection();
			con.setAutoCommit(false);
			String sql1="delete from inventory where pid=?";
			ps1=con.prepareStatement(sql1);
			ps1.setString(1, p);
			i=ps1.executeUpdate();
			con.commit();
			con.setAutoCommit(false);
			String sql="delete from product where pid=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, p);
			i=ps.executeUpdate();
			con.commit();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally{
			try{
				if(con!=null)
				{
					con.close();
					ps.close();
					ps1.close();
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		return i;
	}
	
	@Override
	public int insertProduct(Product p,Login l) {
		Connection con=null;
		PreparedStatement ps=null;
		int i=0,i1=0;
		PreparedStatement ps1=null;
		try
		{
			//con=DbUtility.getConnection();
			con=DBUtility.getDatasourse().getConnection();
			con.setAutoCommit(false);
			String sql="insert into product (pid,productname,brand,category,rating,description,price,discount) values(?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, p.getPid());
			ps.setString(2, p.getProductname());
			ps.setString(3, p.getBrand());
			ps.setString(4, p.getCategory());
			ps.setDouble(5, p.getRating());
			ps.setString(6, p.getDescription());
			ps.setDouble(7, p.getPrice());
			ps.setInt(8, p.getDiscount());
			i=ps.executeUpdate();
			
			String sql1="insert into inventory (usrid,pid,instock,buffer,pending) values(?,?,?,?,?)";
			ps1=con.prepareStatement(sql1);
			ps1.setString(1, l.getId());
			ps1.setString(2, p.getPid());
			ps1.setInt(3, p.getInstock());
			ps1.setInt(4,p.getBuffer());
			ps1.setInt(5, p.getPending());
			i1=ps1.executeUpdate();
			con.commit();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally{
			try{
				if(con!=null)
				{
					con.close();
					ps.close();
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		return i;
	}


}
