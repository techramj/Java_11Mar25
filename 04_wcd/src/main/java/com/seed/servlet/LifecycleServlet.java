package com.seed.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifecycleServlet
 */
@WebServlet("/lifecycle")
public class LifecycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LifecycleServlet() {
		System.out.println(this.getClass().getSimpleName() + " construtor called");
	}

	@Override
	public void init() throws ServletException {
		System.out.println(this.getClass().getSimpleName() + " init method called");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(this.getClass().getSimpleName() + " doGet called");
		PrintWriter out = resp.getWriter();
		out.println(this.getClass().getSimpleName() + " doGet method");
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
