package com.web.atm.comtroller.Impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.atm.comtroller.AtmService;
import com.web.atm.comtroller.ControllerInterface;

public class OpenApiController implements ControllerInterface {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, AtmService atmService) {
		
		/* /api/openapi/[4번째 temp값]
		 * getArprtList - 공항목록 조회 
		 * getAirmanList - 항공사목록 조회 
		 * getFlightOpratInfoList - 항공운행정보목록 조회
		 */
		String returnMassage=null;
		ObjectMapper mapper = new ObjectMapper();
		
		String path = request.getRequestURI();
		String[] temp=path.split("/");
		String query=request.getQueryString();
		System.out.println("OpenApiController path >>"+path+"?"+query);
		System.out.println(temp[3]);
		if(temp[3].equals("getArprtList")) {
			openApiGetAirmanList oagal=new openApiGetAirmanList();
			System.out.println("do");
		}else if(temp[3].equals("getAirmanList")) {
			
		}else if(temp[3].equals("getFlightOpratInfoList")) {
			
		}
		
		
		
		
		
		
		
		return "이건가";
	}

}
