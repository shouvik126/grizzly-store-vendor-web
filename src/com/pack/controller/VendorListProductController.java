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
import com.pack.model.Profile;
import com.pack.service.VendorServiceImpl;

/**
 * Servlet implementation class VendorListProductController
 */
//@WebServlet("/VendorListProductController")
public class VendorListProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public VendorListProductController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession hs=request.getSession(false);
		
		VendorServiceImpl vs=new VendorServiceImpl();
		Login l=(Login)hs.getAttribute("login");
		//Profile p=as.fetchProfile(l.getId());
		//hs.setAttribute("profile", p);
		List<Product>li=vs.fetchProduct(l.getId());
		request.setAttribute("product", li);
		RequestDispatcher rd=request.getRequestDispatcher("/VendorListProduct.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession hs=request.getSession(false);
		VendorServiceImpl vs=new VendorServiceImpl();

		Login l=(Login)hs.getAttribute("login");
		if(hs.getAttribute("profile")==null)
		{
			Profile p=vs.fetchProfile(l.getId());
			hs.setAttribute("profile", p);
		}
		List<Product>li=vs.fetchProduct(l.getId());
		request.setAttribute("product", li);

		RequestDispatcher rd=request.getRequestDispatcher("/VendorListProduct.jsp");
		rd.forward(request, response);
	}

}
