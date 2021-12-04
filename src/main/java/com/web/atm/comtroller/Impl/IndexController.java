/**
 * 0. @projectName : Airline-Total-Management  항공 예약 관리시스템 - 비행어때?
 * 1. @fileName : IndexController.java
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

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.atm.comtroller.AtmService;
import com.web.atm.comtroller.ControllerInterface;
import com.web.atm.di.entity.AirportList;

/** Class
 * 
 * 
 * <PRE>
 * @className : IndexController
 * @fileName  : IndexController.java
 * @package   : com.web.atm.comtroller.Impl
 * @comment   : 
 * @author    : JIMIN
 * @since     : 2021. 12. 4. 오후 3:40:39
 * </PRE>
 */
public class IndexController implements ControllerInterface {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, AtmService atmService) {
		List<String> airlineNameList;
		List<String> airportNameList;
		
		AirportList airportList=new AirportList();
		airportNameList = airportList.getAirportNameList();
		
		airlineNameList=atmService.getAirlineNameList(null);
		
		request.setAttribute("airlineNameList", airlineNameList);//항공사이름리스트
		request.setAttribute("airportNameList", airportNameList);//공항이름리스트

		return "main.jsp";
	}

}
