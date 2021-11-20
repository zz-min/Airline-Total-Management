package com.web.atm.comtroller.Impl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.atm.comtroller.AtmService;
import com.web.atm.comtroller.ControllerInterface;

public class ApiUserController implements ControllerInterface {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, AtmService atmService) {
		String returnMassage=null;
		ObjectMapper mapper = new ObjectMapper();
		
		String method = request.getMethod().toUpperCase();//요청메소드를 모두 대문자로반환 post -> POST
		String path = request.getRequestURI();
		String[] temp=path.split("/");
		String query=request.getQueryString();
		System.out.println("apiUserController path >>"+path+"?"+query);
		
		Base64 base64 = new Base64();
		
		// GET
		// /api/users - user전체목록반환
		// /api/users/201796 - user 중 id = 201796 만 반환
		// /api/users/login?id=22&pwd=11 - 로그인 유효성검사확인하기
		
		// POST
		// /api/users - user 하나 새로 생성

		// UPDATE
		// /api/users/201796 - user 중 id = 201796인 유저 정보 수정

		// DELETE
		// /api/users/201796 - user 중 id = 201796인 유저 삭제
		if (temp.length == 3) {// /api/users
			if (method.equals("GET")) {// users 전체목록 가져오기
				System.out.println("모든 user정보 조회 - ApiUserController - GET");
			} else if (method.equals("POST")) {// 새로운 user정보 생성하기 - 회원가입
				System.out.println("새로운 user정보 생성 - ApiUserController - POST");
			}
		} else if (temp.length > 3) {
			
		}
		
		return returnMassage;
	}

}
