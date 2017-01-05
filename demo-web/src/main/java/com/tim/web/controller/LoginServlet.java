package com.tim.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String certCode = request.getParameter("certCode");
		String corretCode = (String) request.getSession().getAttribute("certCode");
		System.out.println("username:" + username + " password:" + password + " corretCode:" + corretCode);
		System.out.println("certCode" + certCode);
		if ("admin".equals(username) && "admin".equals(password) && corretCode.equals(certCode)) {
			System.out.println("admin用户登录成功!");
		} else {
			System.out.println("登录失败!");
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
