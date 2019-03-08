package com.pack.service;



import java.util.List;


import com.pack.dao.VendorDaoImpl;
import com.pack.model.Inventory;
import com.pack.model.Login;
import com.pack.model.Product;
import com.pack.model.Profile;

public class VendorServiceImpl implements VendorService{

	@Override
	public Login fetchLogin(String usr, String pass) {
		VendorDaoImpl vd=new VendorDaoImpl();
		Login l=vd.fetchLogin(usr,pass);
		return l;
	}
	@Override
	public Login fetchLoginByUser(String usr) {
		VendorDaoImpl vd=new VendorDaoImpl();
		Login l=vd.fetchLoginByUser(usr);
		return l;
	}
	
	@Override
	public int setLoginStatus(Login l) {
		VendorDaoImpl vd=new VendorDaoImpl();
		int i=vd.setLoginStatus(l);
		return i;
	}
	
	@Override
	public Profile fetchProfile(String usr) {
		VendorDaoImpl vd=new VendorDaoImpl();
		Profile p=vd.fetchProfile(usr);
		return p;
	}
	
	@Override
	public List<Product> fetchProduct(String id) {
		VendorDaoImpl vd=new VendorDaoImpl();
		List<Product>li=vd.fetchProduct(id);
		return li;
	}
	@Override
	public Product fetchProductByPid(String p) {
		VendorDaoImpl vd=new VendorDaoImpl();
		Product pr=vd.fetchProductByPid(p);
		return pr;
	}
	@Override
	public int removeProductByPid(String p) {
		VendorDaoImpl vd=new VendorDaoImpl();
		int i=vd.removeProductByPid(p);
		return i;
	}
	@Override
	public int insertProduct(Product p,Login l) {
		VendorDaoImpl ad=new VendorDaoImpl();
		int i=ad.insertProduct(p,l);
		return i;
	}

}
