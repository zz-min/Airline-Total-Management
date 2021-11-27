package com.web.atm.comtroller.Impl;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.atm.comtroller.AtmService;
import com.web.atm.comtroller.ControllerInterface;
import com.web.atm.di.entity.User;

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
		// /api/users/2 - user 중  고객번호 = 2 만 반환
		
		// POST
		// /api/users - user 하나 새로 생성
		// /api/users/2 - user 중 고객번호 = 2인 유저 정보 수정

		if (temp.length == 3) {// /api/users
			if (method.equals("GET")) {// users 전체목록 가져오기
				System.out.println("모든 user정보 조회 - ApiUserController - GET");
			} else if (method.equals("POST")) {// 새로운 user정보 생성하기 - 회원가입
				System.out.println("새로운 user정보 생성 - ApiUserController - POST");
				User user=new User();
				String json = null;

				try {
			        BufferedReader reader = request.getReader();
			        json = reader.readLine();
			    }catch(Exception e) {
			        System.out.println("Error reading JSON string: " + e.toString());
			    }
				System.out.println(json);
				try {
					user = mapper.readValue(json, User.class);
					System.out.println(user.getUserId());
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
				boolean a=atmService.insertUser(user);
				returnMassage= a?"true":"false";
				/*
				 * int result = smpService.insertSchedule(userId,
				 * allViewEntity.getMain_content(), allViewEntity.getSub_content(), rsv_date,
				 * allViewEntity.getStart_time(), allViewEntity.getEnd_time());
				 * 
				 * if (result == 1) { returnMassage = "Insert success"; }
				 */
				
			}
		} else if (temp.length > 3) {
			
		}
		
		return returnMassage;
	}

}
