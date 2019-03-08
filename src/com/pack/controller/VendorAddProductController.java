package com.pack.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pack.model.Login;
import com.pack.model.Product;

import com.pack.service.VendorServiceImpl;

/**
 * Servlet implementation class VendorAddProductController
 */
//@WebServlet("/VendorAddProductController")
public class VendorAddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendorAddProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		HttpSession hs=request.getSession(false);
		VendorServiceImpl vs=new VendorServiceImpl();
		Login l=(Login)hs.getAttribute("login");
		List<Product>li=vs.fetchProduct(l.getId());
		request.setAttribute("product", li);*/
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession hs=request.getSession(false);
		VendorServiceImpl vs=new VendorServiceImpl();
		Login l=(Login)hs.getAttribute("login");
		String pid=request.getParameter("pid");
		String productname=request.getParameter("productname");
		String productcategory=request.getParameter("productcategory");
		String productdescription=request.getParameter("productdescription");
		double productprice=Double.parseDouble(request.getParameter("productprice"));
		Product p=new Product(pid,productname,"NA",productcategory,productdescription,0.0,productprice,10,l.getId(),20,50,3);
		
		int i=vs.insertProduct(p,l);
		if(i!=0)
		{
		
			RequestDispatcher rd=request.getRequestDispatcher("VendorListProductController");
			rd.forward(request, response);
		}
	}

}
