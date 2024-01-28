package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;

public class FirstServlet implements Servlet {
	
	
//	life cycle methods************************************************
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("creating objects...");
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("servicing...");
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.println("<h1>This is first servlet</h1>");
		
	}

	@Override
	public void destroy() {
		System.out.println("destroying servlet objects...");
		
	}

//	Non life cycle methods**********************************************
	
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
