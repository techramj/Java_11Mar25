package com.seed.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seed.dao.UserDao;
import com.seed.entity.User;

/**
 * Servlet implementation class FriendServlet
 */
@WebServlet("/friends")
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false); //don't create the new session, return existing session
		String username = (String)session.getAttribute("username");
		User user =  (User)session.getAttribute("user");
		
		Connection con = (Connection)getServletContext().getAttribute("connection");
		UserDao dao = new UserDao(con);
		
		
		PrintWriter out = response.getWriter();
		out.println("<h5 align='right'><a href='logout'>Logout</a></h5>");
		out.println("Usernmae = "+username);
		out.println("firstname = "+user.getFirstName());
		out.println("lastname = "+user.getLastName());
		out.println("<h3 align='center'>List of "+username  +"'s friend</h3>");
		
		try {
			List<String> friends = dao.getFriends(user.getId());
			
			out.println("<ol>");
			for(String friend:friends) {
				out.println("<li>"+friend+"</li>");
			}
			out.println("</ol>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
