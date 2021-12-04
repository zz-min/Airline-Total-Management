/**
 * 0. @projectName : Airline-Total-Management  항공 예약 관리시스템 - 비행어때?
 * 1. @fileName : ApiFlightReqController.java
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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.atm.comtroller.AtmService;
import com.web.atm.comtroller.ControllerInterface;
import com.web.atm.di.entity.BookingInfo;
import com.web.atm.di.entity.FlightRequestDo;
import com.web.atm.di.entity.UserDo;

/** Class
 * 
 * 
 * <PRE>
 * @className : ApiFlightReqController
 * @fileName  : ApiFlightReqController.java
 * @package   : com.web.atm.comtroller.Impl
 * @comment   :
 * @author    : JIMIN
 * @since     : 2021. 12. 5. 오전 2:45:49
 * </PRE>
 */
public class ApiFlightReqController implements ControllerInterface {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, AtmService atmService) {
		String returnMassage=null;
		ObjectMapper mapper = new ObjectMapper();
		
		String method = request.getMethod().toUpperCase();//요청메소드를 모두 대문자로반환 post -> POST
		String path = request.getRequestURI();
		String[] temp=path.split("/");
		String query=request.getQueryString();
		String userId=new String();
		System.out.println("ApiFlightReqController path >>"+path+"?"+query);
		String[] select_obj_f_temp,select_obj_e_temp;

		Cookie[] cookies=request.getCookies();
		for(Cookie cookie:cookies) {//로그인할때 생성된 쿠키중  user Id 정보 읽어드리기ㄹ
			if(cookie.getName().equals("userId")) userId=cookie.getValue();
		}
		// GET
		// /api/flightReq - flight전체목록반환
		// POST
		// /api/flightReq?checkedFlightSn, select_obj_f, select_obj_e - 예약
		if (temp.length == 3) {// /api/flightReq 
			if (method.equals("GET")) {// flight전체목록반환
				System.out.println("모든 flight정보 조회 - ApiFlightController - GET");
				
			} else if (method.equals("POST")) {// 새로운 flightReq 정보 생성하기
				BookingInfo bi=new BookingInfo();
				String json = null;
				try {
			        BufferedReader reader = request.getReader();
			        json = reader.readLine();
			    }catch(Exception e) {
			        System.out.println("Error reading JSON string: " + e.toString());
			    }
				try {
					bi = mapper.readValue(json, BookingInfo.class);
					System.out.println(bi.getFlightSn());
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
				
				String bookId=bi.getFlightSn()+userId;
				
				//1. flightReq생성
				FlightRequestDo frd=new FlightRequestDo();
				frd.setBookId(bookId);
				frd.setFlight_sn(bi.getFlightSn());
				frd.setUser_sn(atmService.getUserSn(userId));
				frd.setStatus("결제전");
				boolean isFlightReq=atmService.insertFlightRequest(frd);
				
				//2. flightSeat생성
				//bi.getSelect_obj_e(), bi.getSelect_obj_f()
				
			}
		}else if (temp.length > 3) {
			String sql;
			//if(temp[3].equals("list")) {}
		}
		returnMassage="true";
		return returnMassage;
	}

}
