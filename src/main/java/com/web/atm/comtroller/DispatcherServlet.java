 package com.web.atm.comtroller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.atm.dao.AirlineDao;
import com.web.atm.dao.FlightDao;
import com.web.atm.dao.FlightRequestDao;
import com.web.atm.dao.FlightSeatDao;
import com.web.atm.dao.UserDao;
import com.web.atm.dao.Impl.AirlineJdbcDao;
import com.web.atm.dao.Impl.FlightJdbcDao;
import com.web.atm.dao.Impl.FlightRequestJdbcDao;
import com.web.atm.dao.Impl.FlightSeatJdbcDao;
import com.web.atm.dao.Impl.UserJdbcDao;

/**
 * Servlet implementation class DispatcherServlet
 */

/**
 * @author JIMIN
 * <PRE>
 * 1. ClassName : 
 * 2. FileName  : DispatcherServlet.java
 * 3. Package  : com.web.atm.comtroller
 * 4. Comment  :
 * 5. 작성자   : JIMIN
 * 6. 작성일   : 2021. 12. 4. 오후 1:32:39
 * </PRE>
 */
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PROPERTIES_FILE = "db.properties";
	private Properties props;
	private AtmService atmService = null;
	private HandlerMapping mapper = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
    }
    
	@Override
	public void init() throws ServletException {
		System.out.println("ATM DispatcherServlet init");
    	props = new Properties();
    	 try {
    		 InputStream reader = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE);
             props.load(reader);
         } catch (IOException e) {
             System.out.println("Properties File Load Fail!");
             e.printStackTrace();
         }
    	String driver = props.getProperty("jdbc.driverClassName");
 		String url = props.getProperty("jdbc.url");
 		String userName = props.getProperty("jdbc.username");
 		String password = props.getProperty("jdbc.password");
 		
 		UserDao userDao=new UserJdbcDao(driver, url, userName, password);
 		AirlineDao airlineDao=new AirlineJdbcDao(driver, url, userName, password);
 		FlightDao flightDao=new FlightJdbcDao(driver, url, userName, password);
 		FlightRequestDao FlightRequestDao=new FlightRequestJdbcDao(driver, url, userName, password);
 		FlightSeatDao FlightSeatDao=new FlightSeatJdbcDao(driver, url, userName, password);
 		
 		mapper = new HandlerMapping();
 		atmService= new AtmServiceImpl(userDao,airlineDao,flightDao,FlightRequestDao,FlightSeatDao);
 		
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
		if (path.contains("api")) {// REST API 기술
			String data = handler.handleRequest(request, response, atmService);
			
			// step #3. output processing results
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(data);

		} else {//페이지 이동
			if (handler != null) {
				//session이 있거나 cookie가 존재하면 넘어가기 -> 아니라면 알람띄우고 메인페이지
				viewName = handler.handleRequest(request, response, atmService);
			}
			// step #3. output processing results
			if (viewName == null) {
				viewName = "error.jsp";
			} else {
				viewName = viewName.trim();// 공백제거함
				viewName = "/WEB-INF/views/" + viewName;

				RequestDispatcher view = request.getRequestDispatcher(viewName);
				view.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
