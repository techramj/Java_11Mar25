package com.seed.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seed.util.ConnectionUtil;

/**
 * Servlet implementation class LifecycleServlet
 */
//@WebServlet("/lifecycle")
public class LifecycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection con;

	public LifecycleServlet() {
		System.out.println(this.getClass().getSimpleName() + " construtor called");
	}

	@Override
	public void init() throws ServletException {
		System.out.println(this.getClass().getSimpleName() + " init method called");
		
		//read init  param
		String a = this.getInitParameter("a");
		ServletConfig config = this.getServletConfig();
		String a1 = config.getInitParameter("a");
		System.out.println("a= "+a+"    a1= "+a1);
		
		//read context param
		ServletContext context = this.getServletContext();
		String username = context.getInitParameter("db.username");
		String password = context.getInitParameter("db.password");
		String drivername = context.getInitParameter("db.drivername");
		String url = context.getInitParameter("db.url");
		System.out.println("username= "+username+"\ndrivername="+drivername+"\nurl="+url+"    \npassword"+password);
		
		
		
		//create the connection
		con = ConnectionUtil.getConnection(drivername, url, username, password);
		context.setAttribute("connection", con);
		
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(this.getClass().getSimpleName() + " doGet called");
		PrintWriter out = resp.getWriter();
		out.println(this.getClass().getSimpleName() + " doGet method");
		req.setAttribute("connection", con);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(this.getClass().getSimpleName() + " doPost called");
		PrintWriter out = resp.getWriter();
		out.println(this.getClass().getSimpleName() + " doPost method");
	}

	@Override
	public void destroy() {
		System.out.println(this.getClass().getSimpleName() + " destroy method called");
	}

}
