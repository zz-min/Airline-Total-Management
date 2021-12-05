/**
 * 0. @projectName : Airline-Total-Management  항공 예약 관리시스템 - 비행어때?
 * 1. @fileName : ApiUserController.java
 * 2. @package : com.web.atm.comtroller.Impl
 * 3. @comment :
 * 4. @author : JIMIN
 * 5. @since : 2021. 12. 4. 오후 3:40:39
 * 6. @version : V1.0
 * 7. @see :
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    JIMIN : 2021. 12. 4. :            : 신규 개발.
 */
package com.web.atm.comtroller.Impl;

import java.io.BufferedReader;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.atm.comtroller.AtmService;
import com.web.atm.comtroller.ControllerInterface;
import com.web.atm.di.entity.UserDo;
import com.web.atm.di.entity.ViewFlightDetailDo;

/** Class
 * 
 * 
 * <PRE>
 * @className : ApiUserController
 * @fileName  : ApiUserController.java
 * @package   : com.web.atm.comtroller.Impl
 * @comment   :
 * @author    : JIMIN
 * @since     : 2021. 12. 5. 오후 7:06:42
 * </PRE>
 */
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
				//admin페이지에서 전체 회원 관리
				List<UserDo> userList = atmService.getUserList(null);
				try {
					returnMassage = mapper.writeValueAsString(userList);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			} else if (method.equals("POST")) {// 새로운 user정보 생성하기 - 회원가입
				System.out.println("새로운 user정보 생성 - ApiUserController - POST");
				UserDo user=new UserDo();
				String json = null;

				try {
			        BufferedReader reader = request.getReader();
			        json = reader.readLine();
			    }catch(Exception e) {
			        System.out.println("Error reading JSON string: " + e.toString());
			    }
				System.out.println(json);
				try {
					user = mapper.readValue(json, UserDo.class);
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
