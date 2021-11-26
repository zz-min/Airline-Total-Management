 package com.web.atm.comtroller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.atm.dao.AirlineDao;
import com.web.atm.dao.FlightDao;
import com.web.atm.dao.UserDao;
import com.web.atm.dao.Impl.AirlineJdbcDao;
import com.web.atm.dao.Impl.FlightJdbcDao;
import com.web.atm.dao.Impl.UserJdbcDao;

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
	private List<String> airlineNameList;
	private String[] airport= {"김포","김해","제주","대구","울산","청주","양양","무안","광주","여수","사천","포항","군산","원주"};
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
 		
 		mapper = new HandlerMapping();
 		athService= new AtmServiceImpl(userDao,airlineDao,flightDao);
 		airlineNameList = athService.getAirlineNameList(null);
	}
	


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// step #1. get request parameters
		request.setCharacterEncoding("UTF-8");
		//HttpSession session=request.getSession(true);//가져올 세션이 없다면 새로 생성
		//Cookie[] cookies = request.getCookies();
		
		String path = request.getRequestURI();
		System.out.println("path >>" + path);
		String viewName = null;
		
		request.setAttribute("airlineNameList", airlineNameList);
		request.setAttribute("airportNameList", airport);

		// step #2. data processing ==> dispatch request to controller
		ControllerInterface handler = mapper.getHandler(path);
		if (path.contains("api")) {// REST API 기술
			String data = handler.handleRequest(request, response, athService);
			
			// step #3. output processing results
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(data);

		} else {//페이지 이동
			//f()
			if (handler != null) {
				//session이 있거나 cookie가 존재하면 넘어가기 -> 아니라면 알람띄우고 메인페이지
				viewName = handler.handleRequest(request, response, athService);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
