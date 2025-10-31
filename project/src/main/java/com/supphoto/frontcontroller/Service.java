package com.supphoto.frontcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service {
	public String execute(HttpServletRequest requset, HttpServletResponse response);
}
