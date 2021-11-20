package com.web.atm.comtroller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PROPERTIES_FILE = "db.properties";
	private Properties props;
	private AtmService athService = null;
	private HandlerMapping mapper = null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	@Override
	public void init() throws ServletException {
		System.out.println("DispatcherServlet init");
		mapper = new HandlerMapping();
    	props = new Properties();
    	athService= new AtmServiceImpl();
	}
	


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get request parameters
		request.setCharacterEncoding("UTF-8");

		String path = request.getRequestURI();
		System.out.println("path >>" + path);

		String viewName = null;

		// step #2. data processing ==> dispatch request to controller
		ControllerInterface handler = mapper.getHandler(path);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
