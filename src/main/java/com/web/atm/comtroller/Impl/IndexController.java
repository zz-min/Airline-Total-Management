package com.web.atm.comtroller.Impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.atm.comtroller.AtmService;
import com.web.atm.comtroller.ControllerInterface;

public class IndexController implements ControllerInterface {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, AtmService atmService) {
		return "main.jsp";
	}

}
