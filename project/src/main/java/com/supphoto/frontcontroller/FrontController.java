package com.supphoto.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supphoto.controller.CheckIdService;
import com.supphoto.controller.GoogleLoginService;
import com.supphoto.controller.JoinService;
import com.supphoto.controller.KakaoLoginService;
import com.supphoto.controller.LoginService;
import com.supphoto.controller.LogoutService;
import com.supphoto.controller.NaverCallbackServcie;
import com.supphoto.controller.NaverLoginService;
import com.supphoto.controller.SendSmsService;
import com.supphoto.controller.SocialJoinService;
import com.supphoto.controller.VerifySmsService;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Service> map;
	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<String, Service>();
		map.put("Login.do",new LoginService());
		map.put("Join.do",new JoinService());
		map.put("SocialJoin.do",new SocialJoinService());
		map.put("NaverLogin.do", new NaverLoginService());
		map.put("KakaoLogin.do", new KakaoLoginService());
		map.put("GoogleLogin.do", new GoogleLoginService());
		map.put("NaverCallback.do", new NaverCallbackServcie());
		map.put("CheckId.do", new CheckIdService());
		map.put("SendSms.do", new SendSmsService());
		map.put("VerifySms.do", new VerifySmsService());
		map.put("Logout.do", new LogoutService());
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String finalURI = uri.substring(path.length() + 1);
		System.out.println(finalURI + "해당 URI로 프론트컨트롤러에접속함");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Service service = null;
		String result = "";
		// 우리가 정한 패턴 -> Go파일명.do
		if (finalURI.contains("Go")) {
			result = finalURI.substring(2).replaceAll("do", "jsp");
			System.out.println(result);
		} else {
			service = map.get(finalURI);
			result = service.execute(request, response);
		}

		if (result.contains("fetch:/")) {
			response.setContentType("application/json; charset=UTF-8");
			System.out.println("비동기방식 : " + result);
			PrintWriter out = response.getWriter();
			out.print(result.substring(7));
		} else if (result.contains("redirect:/")) {
			System.out.println("리다이렉트방식 : " + result);
			response.sendRedirect(result.substring(10));
		} else {
			System.out.println("포워드방식 : " + result);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/" + result);
			rd.forward(request, response);
		}
	}

}
