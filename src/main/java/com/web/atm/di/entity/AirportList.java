/**
 * 0. @projectName : Airline-Total-Management  항공 예약 관리시스템 - 비행어때?
 * 1. @fileName : AirportList.java
 * 2. @package : com.web.atm.di.entity
 * 3. @comment :
 * 4. @author : JIMIN
 * 5. @since : 2021. 12. 4. 오후 2:18:57
 * 6. @version : V1.0
 * 7. @see :
 *                    이름     : 일자          : 근거자료   : 변경내용
 *                   ------------------------------------------------------
 *                    JIMIN : 2021. 12. 4. :            : 신규 개발.
 */
package com.web.atm.di.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Class
 * 
 * 
 * <PRE>
 * @className : AirportList
 * @fileName  : AirportList.java
 * @package   : com.web.atm.di.entity
 * @comment   :
 * @author    : JIMIN
 * @since     : 2021. 12. 4. 오후 2:18:57
 * </PRE>
 */
public class AirportList {
	public AirportList() {}
	public AirportList(String[] airportId, String[] airportName) {
		super();
		AirportId = airportId;
		AirportName = airportName;
	}

	private String AirportId[]= {
			"NAARKJB","NAARKJJ","NAARKJK","NAARKJY","NAARKNW","NAARKNY","NAARKPC",
			"NAARKPK","NAARKPU","NAARKSI","NAARKSS","NAARKTH","NAARKTN","NAARKTU"
	};
	
	private String AirportName[]= {
			"무안","광주","군산","여수","원주","양양","제주",
			"김해","울산","인천","김포","포항","대구","청주"
	};
	
	/** methods
	 *  @param name
	 *  @return
	 * <PRE>
	 * @methodName : getAirportId
	 * @className  : AirportList
	 * @returnType : String
	 * @comment    : 공항이름으로 공항ID값 찾아주는 메소드
	 * @author     : JIMIN
	 * @since      : 2021. 12. 4. 오후 2:17:46
	 * </PRE>
	 */
	public String getAirportId(String name) {
		int index=Arrays.asList(AirportName).indexOf(name);
		return AirportId[index];		
	}
	
	/** methods
	 *  @param id
	 *  @return
	 * <PRE>
	 * @methodName : getAirportName
	 * @className  : AirportList
	 * @returnType : String
	 * @comment    : 공항 ID 로 공항한글이름 반환하는 메소드
	 * @author     : JIMIN
	 * @since      : 2021. 12. 4. 오후 3:46:10
	 * </PRE>
	 */
	public String getAirportName(String id) {
		int index=Arrays.asList(AirportId).indexOf(id);
		return AirportName[index];		
	}
	
	/** methods
	 *  @return
	 * <PRE>
	 * @methodName : getAirportNameList
	 * @className  : AirportList
	 * @returnType : List<String>
	 * @comment    : 공항이름 전체 리스트로 반환
	 * @author     : JIMIN
	 * @since      : 2021. 12. 4. 오후 3:49:32
	 * </PRE>
	 */
	public List<String> getAirportNameList() {
		List<String> airlineNameList=new ArrayList<String>();
		for(int i=0;i<AirportName.length;i++) {
			airlineNameList.add(AirportName[i]);
		}
		return airlineNameList;
	}


	/** methods
	 *  @return
	 * <PRE>
	 * @methodName : getAirportIdList
	 * @className  : AirportList
	 * @returnType : List<String>
	 * @comment    : 공항아이디 전체 리스트로 반환
	 * @author     : JIMIN
	 * @since      : 2021. 12. 4. 오후 3:51:11
	 * </PRE>
	 */
	public List<String> getAirportIdList() {
		List<String> airlineIdList=new ArrayList<String>();
		for(int i=0;i<AirportId.length;i++) {
			airlineIdList.add(AirportId[i]);
		}
		return airlineIdList;
	}
}
