package com.seed.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seed.util.ConnectionUtil;


public class LoginServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		System.out.println(this.getClass().getSimpleName() + " init method called");
		
		ServletContext context = this.getServletContext();
		String username = context.getInitParameter("db.username");
		String password = context.getInitParameter("db.password");
		String drivername = context.getInitParameter("db.drivername");
		String url = context.getInitParameter("db.url");
		System.out.println("username= "+username+"\ndrivername="+drivername+"\nurl="+url+"    \npassword"+password);
		
		
		
		//create the connection
		Connection con = ConnectionUtil.getConnection(drivername, url, username, password);
		context.setAttribute("connection", con);
		
		
	}
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service method called...");
		
		/*PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Welcome</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(" <h3>LoginResultServlet service method called.</h3>");
		out.println("</body></html>");
		*/
		super.service(request, response);
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet method called");
		login(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		login(req, resp);
		System.out.println("doPost method called");
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		System.out.println(username+"   "+password);
		
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Welcome</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(" <h3>Welcome "+username+" </h3>");
		out.println("</body></html>");
	}
	

}
