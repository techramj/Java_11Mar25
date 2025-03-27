package com.seed.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		
		String username = null;
		
		Cookie[] cookies = request.getCookies();
		System.out.println("cookies count= "+ cookies.length);
		for(Cookie cookie: cookies) {
			System.out.println(cookie.getName()+"  "+cookie.getValue() );
			if(cookie.getName().equals("username")) {
				username = cookie.getValue();
			}
		}
		
		PrintWriter out = response.getWriter();
		out.println("List of "+username  +"'s friend");
		out.println("Usernmae = "+username);
			
	}


}
