package com.tim.web.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter{

	public void destroy() {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("这个是个截流器之前的代码");
		arg2.doFilter(arg0, arg1);
		System.err.println("这个是执行之后的代码");
	}

	public void init(FilterConfig arg0) throws ServletException {
	}
}
