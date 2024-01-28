package com.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ThirdServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("get method....");
		
//		res.setContentType("application/json");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.println("<h1>This is Third servlet with GET method</h1>");
		out.println(new Date().toString());
	}
}
