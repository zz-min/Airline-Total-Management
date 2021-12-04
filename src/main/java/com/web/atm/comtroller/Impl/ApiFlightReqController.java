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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.atm.comtroller.AtmService;
import com.web.atm.comtroller.ControllerInterface;

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
		System.out.println("ApiFlightReqController path >>"+path+"?"+query);
		
		// GET
		// /api/flightReq - flight전체목록반환
		// POST
		// /api/flightReq? - 예약
		
		return returnMassage;
	}

}
