package com.pack.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.pack.service.VendorServiceImpl;

/**
 * Servlet implementation class VendorRemoveProductController
 */
//@WebServlet("/VendorRemoveProductController")
public class VendorRemoveProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public VendorRemoveProductController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession hs=request.getSession(false);
		String pid=request.getParameter("pid");
		VendorServiceImpl vs=new VendorServiceImpl();
		int i=vs.removeProductByPid(pid);
		if(i==1)
		{
			RequestDispatcher rd=request.getRequestDispatcher("VendorListProductController");
			rd.forward(request, response);
		}
	}

}
