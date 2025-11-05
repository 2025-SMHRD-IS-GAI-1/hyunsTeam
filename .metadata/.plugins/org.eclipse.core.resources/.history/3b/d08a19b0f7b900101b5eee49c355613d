/**
 * 
 */
package com.supphoto.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supphoto.frontcontroller.Service;

public class LogoutService implements Service{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("loginUser");
		return "redirect:/Gologin.do";
	}
	
}
