package com.web.atm.comtroller.Impl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.atm.comtroller.AtmService;
import com.web.atm.comtroller.ControllerInterface;
import com.web.atm.di.entity.User;

public class ApiLoginController implements ControllerInterface {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, AtmService atmService) {
		String returnMassage=null;
		ObjectMapper mapper = new ObjectMapper();
		
		String method = request.getMethod().toUpperCase();//요청메소드를 모두 대문자로반환 post -> POST
		String path = request.getRequestURI();
		String[] temp=path.split("/");
		String query=request.getQueryString();
		System.out.println("ApiLoginController path >>"+path+"?"+query);
		
		Base64 base64 = new Base64();
		// GET
		// /api/login/user?id= & pwd=
		// /api/login/admin?id=

		// 로그인 유효성 검사해주기
		String id=new String(base64.decode(request.getParameter("id").getBytes()));//디코딩된값
		String pwd=new String(base64.decode( request.getParameter("pwd").getBytes()));
		System.out.println(id+"와"+pwd+"를 유효성검사중");
		
		if (temp[3].equals("user") ) {
			boolean loginCheck = atmService.loginAvailability(id,pwd);//로그인 유효성 검사
			if (loginCheck) {/* login 성공일때 쿠키생성 */
				System.out.println("로그인 성공!!");
				User loginUser=atmService.getUser(id);
				
				Cookie cookieId=new Cookie("userId",id);
				cookieId.setPath("/");//쿠키를 모든 위치에서 사용가능
				cookieId.setMaxAge(3600);//60s*6 = 360s = 6M *10 = 60M = 1H
				
				Cookie cookieName=new Cookie("userName",loginUser.getUserName());
				cookieName.setPath("/");//쿠키를 모든 위치에서 사용가능
				cookieName.setMaxAge(3600);//60s
				
				Cookie cookieType=new Cookie("userType","user");
				cookieType.setPath("/");//쿠키를 모든 위치에서 사용가능
				cookieType.setMaxAge(3600);//60s
				
				response.addCookie(cookieId);
				response.addCookie(cookieName);
				response.addCookie(cookieType);
				
				HttpSession session=request.getSession(true);//가져올 세션이 없다면 새로 생성
				session.setAttribute("user", loginUser);
			}
			returnMassage=loginCheck?"true":"false";
		}else if (temp[3].equals("admin")) {
			
		}
		
	
		return returnMassage;
	}

}
