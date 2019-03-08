package com.pack.service;

import java.util.List;

import com.pack.model.Inventory;
import com.pack.model.Login;
import com.pack.model.Product;
import com.pack.model.Profile;

public interface VendorService {
	public Login fetchLogin(String usr,String pass);
	public Login fetchLoginByUser(String usr);
	public int setLoginStatus(Login l);
	public Profile fetchProfile(String usr);
	public List<Product> fetchProduct(String id);
	public Product fetchProductByPid(String p);
	public int removeProductByPid(String p);
	public int insertProduct(Product p,Login l);
}
