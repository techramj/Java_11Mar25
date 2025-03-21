package com.seed.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet(name="lifcycle", urlPatterns ="/lifecycle" , loadOnStartup = 1 )
public class LifecycleServlet extends HttpServlet {
	
	public LifecycleServlet() {
		System.out.println(this.getClass().getSimpleName()+" construtor called");
	}
	
	@Override
	public void init() throws ServletException {
		
		//read the init param value
		String a = this.getInitParameter("a");
		System.out.println("a="+a);
		
		//read the context param
		ServletContext context = this.getServletContext();
		String driverName = context.getInitParameter("");
		String url = context.getInitParameter("");
		String username = context.getInitParameter("db.username");
		String password = context.getInitParameter("db.password");
		
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println(this.getClass().getSimpleName()+" doGet method");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println(this.getClass().getSimpleName()+" doPost method");
	}
	
	@Override
	public void destroy() {
		
	}

}
