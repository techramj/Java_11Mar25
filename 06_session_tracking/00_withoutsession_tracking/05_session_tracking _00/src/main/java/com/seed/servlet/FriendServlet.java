package com.seed.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FriendServlet
 */
@WebServlet("/friends")
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String username = request.getParameter("username");
		ServletContext context = getServletContext();
		String username = (String)context.getAttribute("username");
		
		PrintWriter out = response.getWriter();
		out.println("List of Jack's friend");
		out.println("Usernmae = "+username);
			
	}


}
