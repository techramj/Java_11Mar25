package com.seed.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seed.dao.UserDao;
import com.seed.entity.User;
import com.seed.util.ConnectionUtil;


@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	UserDao dao;
	

	@Override
	public void init() throws ServletException {
		
		//read context param
		ServletContext context = this.getServletContext();
		String username = context.getInitParameter("db.username");
		String password = context.getInitParameter("db.password");
		String drivername = context.getInitParameter("db.drivername");
		String url = context.getInitParameter("db.url");
		System.out.println("username= "+username+"\ndrivername="+drivername+"\nurl="+url+"    \npassword"+password);
		
		
		
		//create the connection
		Connection  con = ConnectionUtil.getConnection(drivername, url, username, password);
		context.setAttribute("connection", con);
		
		dao = new UserDao(con);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+"   "+password);
		
		ServletContext context = this.getServletContext();
		context.setAttribute("username", username);
		
		boolean isValidUser = false;
		User user = null;
		try {
			user = dao.getUserDetail(username);
			if(user!= null) {
				 isValidUser = password!= null && password.equals(user.getPassword());	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		if(isValidUser) {
			out.println("<head>");
			out.println("<title>Welcome</title>");
			out.println("</head>");
			out.println("<body>");
			out.println(" <h3>Welcome "+user.getFirstName()+" "+user.getLastName()+" </h3>");
			out.println("<form  action='friends' method='get' >");
			out.println("<button type='submit'>Display Friend's List</button>");
			out.println("</form>");
		}else {
			out.println("Invalid username and password");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		out.println("</body></html>");
		
	}
	
	
	

}