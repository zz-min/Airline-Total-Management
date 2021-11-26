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
		
		String checkedDate=request.getParameter("checkedDate");//2021-11-02
		String sub_Year=checkedDate.substring(1,5);
		String sub_Month=checkedDate.substring(6,8);
		String sub_Day=checkedDate.substring(9,11);
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
		// POST
		// /api/flight?checkedAirline, checkedDate, checkedOrigin, checkedDest
		if (temp.length == 3) {// /api/flight 
			if (method.equals("GET")) {// flight 전체목록 가져오기
				System.out.println("모든 flight정보 조회 - ApiFlightController - GET");
			} else if (method.equals("POST")) {// 새로운 flight정보 생성하기
				
			}
		}else if (temp.length > 3) {
			if(temp[3].equals("list")) {
				String sql = "airlineName='"+checkedAirline.trim()+
						"' AND origin ='"+checkedOrigin.trim()+
						"' AND destination='"+checkedDest.trim()+
						"' AND year(dep_time) ="+sub_Year+
						" AND month(dep_time) ="+sub_Month+
						" AND day(dep_time) ="+sub_Day;
				System.out.println(sql);
				List<VIEW_FLIGHT_DETAIL> flightList = atmService.getFlightList(sql);
				
				try {
					returnMassage = mapper.writeValueAsString(flightList);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}

			}
		}
		System.out.println(returnMassage);
		return returnMassage;
	}

}
