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
 * Servlet implementation class VendorViewProductController
 */
//@WebServlet("/VendorViewProductController")
public class VendorViewProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public VendorViewProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession hs=request.getSession(false);
		Login l=(Login) hs.getAttribute("login");
		String pid=request.getParameter("pid");
		System.out.println(pid);
		VendorServiceImpl vs=new VendorServiceImpl();
		Product p=null;
		p=vs.fetchProductByPid(pid);
		if(p!=null)
		{
			List<Product>li=vs.fetchProduct(l.getId());
			request.setAttribute("productinvent", li);
			request.setAttribute("product", p);
			RequestDispatcher rd=request.getRequestDispatcher("/VendorViewProduct.jsp");
			rd.forward(request, response);
		}
	}

}
