package com.seed.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServeltOne
 */
@WebServlet("/one")
public class ServeltOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("ServletOne.doGet");
		
		request.setAttribute("test", "request.setAttribute has request scope");
		
		RequestDispatcher rd = request.getRequestDispatcher("two");
		rd.include(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("ServletOne.doPost");
		
		RequestDispatcher rd = request.getRequestDispatcher("two");
		rd.forward(request, response);
	}

}
