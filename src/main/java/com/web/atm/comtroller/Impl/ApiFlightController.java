package com.web.atm.comtroller.Impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.atm.comtroller.AtmService;
import com.web.atm.comtroller.ControllerInterface;
import com.web.atm.di.entity.VIEW_FLIGHT_DETAIL;

public class ApiFlightController implements ControllerInterface {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, AtmService atmService) {
		String returnMassage=null;
		ObjectMapper mapper = new ObjectMapper();
		
		String method = request.getMethod().toUpperCase();//요청메소드를 모두 대문자로반환 post -> POST
		String path = request.getRequestURI();
		String[] temp=path.split("/");
		String query=request.getQueryString();
		System.out.println("ApiFlightController path >>"+path+"?"+query);
		String sub_Year=null; 
		String sub_Month=null;
		String sub_Day=null;
		String checkedDate=request.getParameter("checkedDate");//2021-11-02
		if(checkedDate!=null) {
			sub_Year=checkedDate.substring(1,5);
			sub_Month=checkedDate.substring(6,8);
			sub_Day=checkedDate.substring(9,11);
		}
		
		String checkedAirline=request.getParameter("checkedAirline");
		String checkedOrigin=request.getParameter("checkedOrigin");
		String checkedDest=request.getParameter("checkedDest");
		if(checkedAirline!=null) {
			try {//카테고리이름 한글 디코딩처리 - URLDecoder.decode(NAME, "UTF-8")
				checkedAirline = URLDecoder.decode(request.getParameter("checkedAirline"), "UTF-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		if(checkedOrigin!=null&&checkedDest!=null) {
			try {//카테고리이름 한글 디코딩처리 - URLDecoder.decode(NAME, "UTF-8")
				checkedOrigin = URLDecoder.decode(request.getParameter("checkedOrigin"), "UTF-8");
				checkedDest = URLDecoder.decode(request.getParameter("checkedDest"), "UTF-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		
		// GET
		// /api/flight - flight전체목록반환
		// /api/flight/list - 항공사와 출발날짜 출발지 도착지로 항공편 리스트 조회
		// /api/flight/2 - 항공편번호로 해당 항공편만 조회
		// POST
		// /api/flight?checkedAirline, checkedDate, checkedOrigin, checkedDest
		if (temp.length == 3) {// /api/flight 
			if (method.equals("GET")) {// flightf list 가져오기
				System.out.println("모든 flight정보 조회 - ApiFlightController - GET");
				
			} else if (method.equals("POST")) {// 새로운 flight정보 생성하기
				
			}
		}else if (temp.length > 3) {
			String sql;
			if(temp[3].equals("list")) {
				if(checkedAirline==null) {
					sql = "origin ='"+checkedOrigin.trim()+
							"' AND destination='"+checkedDest.trim()+
							"' AND year(dep_time) ="+sub_Year+
							" AND month(dep_time) ="+sub_Month+
							" AND day(dep_time) ="+sub_Day;
				}else {
					sql = "airlineName='"+checkedAirline.trim()+
						"' AND origin ='"+checkedOrigin.trim()+
						"' AND destination='"+checkedDest.trim()+
						"' AND year(dep_time) ="+sub_Year+
						" AND month(dep_time) ="+sub_Month+
						" AND day(dep_time) ="+sub_Day;
				}
				
				System.out.println(sql);
				List<VIEW_FLIGHT_DETAIL> flightList = atmService.getFlightList(sql);
				
				try {
					returnMassage = mapper.writeValueAsString(flightList);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}else {//api/flight/2 - 항공편번호로 해당 항공편만 조회
				int flightSn=Integer.parseInt(temp[3]);
				VIEW_FLIGHT_DETAIL vf=atmService.getFlight(flightSn);
				try {
					returnMassage = mapper.writeValueAsString(vf);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(returnMassage);
		return returnMassage;
	}

}
