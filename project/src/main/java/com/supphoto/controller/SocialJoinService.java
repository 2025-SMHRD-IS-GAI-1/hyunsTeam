package com.supphoto.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supphoto.frontcontroller.Service;
import com.supphoto.model.UserDAO;
import com.supphoto.model.UserVO;

public class SocialJoinService implements Service {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String social_type = request.getParameter("social_type");
		String result ="";
		UserVO uvo = new UserVO();
		uvo.setUser_id(id);
		uvo.setName(name);
		uvo.setPhone_number(phone);
		uvo.setSocial_type(social_type);
		UserDAO dao = new UserDAO();
		if(dao.checkId(id)) {
			int row = dao.join(uvo);
			if(row > 0) {
				System.out.println("회원가입 완료");
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", uvo);
				return "redirect:/Gojoin_success.do";
			}
		}
		return "redirect:/Gofail.do";
	}

}
