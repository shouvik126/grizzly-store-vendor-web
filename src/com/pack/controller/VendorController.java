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
 * Servlet implementation class VendorController
 */
//@WebServlet("/VendorController")
public class VendorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static int count=0;   
 
    public VendorController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		HttpSession hs=request.getSession(false);
		VendorServiceImpl vs=new VendorServiceImpl();
		Login l=(Login)hs.getAttribute("login");
		if(l!=null)
		{
			List<Product>li=vs.fetchProduct(l.getId());
			request.setAttribute("product", li);
		}
		RequestDispatcher rd=request.getRequestDispatcher("/VendorAddProduct.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String usr=request.getParameter("username");
		String pass=request.getParameter("password");
		
		//fetching login details
		VendorServiceImpl vs=new VendorServiceImpl();
		Login l=vs.fetchLogin(usr,pass);
		//fetching profile details
		if(l!=null)
		{
			String status=l.getStatus();
			count=0;
			if(status.equals("valid"))
			{
				String usertype=l.getUsertype();
				System.out.println(usertype);
				//Profile p=as.fetchProfile(l.getId());
				HttpSession hs=request.getSession(true);
				hs.setAttribute("login", l);
				//hs.setAttribute("profile", p);
				if(usertype.equals("vendor"))
				{
					System.out.println("upto vendor check");
					/*List<Product>li=as.fetchProduct();
					request.setAttribute("product", li);
					RequestDispatcher rd=request.getRequestDispatcher("/AdminListProduct.jsp");*/
					//System.out.println("Login Successful");
					RequestDispatcher rd=request.getRequestDispatcher("VendorListProductController");
					rd.forward(request, response);
				}
			}
			else
			{
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Your Account has been locked, Contact Admin');");
				pw.println("location='/grizzly-store-vendor-web/VendorLogin.jsp';");
				pw.println("</script>");
			}
		}
		else
		{
			VendorServiceImpl vs1=new VendorServiceImpl();
			Login l1=vs1.fetchLoginByUser(usr);
			if(l1!=null)
			{
				String status=l1.getStatus();
				if(status.equals("valid"))
				{
					//setting status no for incorrect password
					count+=1;
					if(count>=3)
					{
						int i=vs1.setLoginStatus(l1);
					}
					
					pw.println("<script type=\"text/javascript\">");
					pw.println("alert('Password you have entered is incorrect');");
					pw.println("location='/grizzly-store-vendor-web/VendorLogin.jsp';");
					pw.println("</script>");
				}
				else
				{
					pw.println("<script type=\"text/javascript\">");
					pw.println("alert('Your Account has been locked, Contact Admin');");
					pw.println("location='/grizzly-store-vendor-web/VendorLogin.jsp';");
					pw.println("</script>");
				}
			}
			else
			{
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Username and Password is incorrect');");
				pw.println("location='/grizzly-store-vendor-web/VendorLogin.jsp';");
				pw.println("</script>");
			}
			//System.out.println("user not found");
		}
	}//post end

}
