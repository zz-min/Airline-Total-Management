/**
 * 0. Project  : Airline-Total-Management  항공 예약 관리시스템 - 비행어때?
 *
 * 1. @fileName : HandlerMapping.java
 * 2. @package : com.web.atm.comtroller
 * 3. @comment :
 * 4. @author : JIMIN
 * 5. @since : 2021. 12. 4. 오후 1:34:56
 * 6. @version : V1.0
 * 7. @see :
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    JIMIN : 2021. 12. 4. :            : 신규 개발.
 */
package com.web.atm.comtroller;

import java.util.HashMap;
import java.util.Map;

import com.web.atm.comtroller.Impl.AdminMainController;
import com.web.atm.comtroller.Impl.ApiAdminController;
import com.web.atm.comtroller.Impl.ApiFlightController;
import com.web.atm.comtroller.Impl.ApiFlightReqController;
import com.web.atm.comtroller.Impl.ApiLoginController;
import com.web.atm.comtroller.Impl.ApiUserController;
import com.web.atm.comtroller.Impl.IndexController;
import com.web.atm.comtroller.Impl.UserMainController;

public class HandlerMapping {
	Map<String, ControllerInterface> handlerMapper = null;

	public HandlerMapping() {
		handlerMapper = new HashMap<String, ControllerInterface>();

		handlerMapper.put("/main", new IndexController());
		handlerMapper.put("/index", new IndexController());

		handlerMapper.put("/main_login", new UserMainController());
		handlerMapper.put("/main_admin", new AdminMainController());

		handlerMapper.put("/api/login", new ApiLoginController());

		handlerMapper.put("/api/users", new ApiUserController());
		handlerMapper.put("/api/admin", new ApiAdminController());
		handlerMapper.put("/api/flight", new ApiFlightController());
		handlerMapper.put("/api/flightReq", new ApiFlightReqController());
	}

	public ControllerInterface getHandler(String path) {
		String[] temp=path.split("/"); 
		// /main/1라면 [0]='', [1]="main", [2]="1"가 저장됨
		
		if(temp.length>3) {//리소스가 2개 초과면 2개까지 분류만 path로 넘기기
			return handlerMapper.get("/"+temp[1]+"/"+temp[2]);
		}else {
			return handlerMapper.get(path);
		}
	}
}
