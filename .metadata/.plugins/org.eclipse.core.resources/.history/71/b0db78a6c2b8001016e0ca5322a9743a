package com.supphoto.frontcontroller;

import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.supphoto.controller.LoginService;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Object> list = new HashMap<>();
	public void init(ServletConfig config) throws ServletException {
		list.put("Login.do",new LoginService());
	}

}
