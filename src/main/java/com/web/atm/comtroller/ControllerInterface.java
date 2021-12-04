/**
 * 0. @projectName : Airline-Total-Management  항공 예약 관리시스템 - 비행어때?
 * 1. @fileName : ControllerInterface.java
 * 2. @package : com.web.atm.comtroller
 * 3. @comment :
 * 4. @author : JIMIN
 * 5. @since : 2021. 12. 4. 오후 2:23:52
 * 6. @version : V1.0
 * 7. @see :
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    JIMIN : 2021. 12. 4. :            : 신규 개발.
 */
package com.web.atm.comtroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Class
 * 
 * 
 * <PRE>
 * @className : ControllerInterface
 * @fileName  : ControllerInterface.java
 * @package   : com.web.atm.comtroller
 * @comment   :
 * @author    : JIMIN
 * @since     : 2021. 12. 4. 오후 2:23:52
 * </PRE>
 */
public interface ControllerInterface {
	String handleRequest(HttpServletRequest request, HttpServletResponse response, AtmService atmService);
}
