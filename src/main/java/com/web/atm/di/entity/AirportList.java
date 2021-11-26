package com.web.atm.di.entity;

import java.util.Arrays;

public class AirportList {
	private String AirportId[]= {
			"NAARKJB","NAARKJJ","NAARKJK","NAARKJY","NAARKNW",
			"NAARKNY","NAARKPC","NAARKPK","NAARKPU","NAARKSI",
			"NAARKSS","NAARKTH","NAARKTN","NAARKTU"
	};
	private String AirportName[]= {
			"무안","광주","군산","여수","원주",
			"양양","제주","김해","울산","인천",
			"김포","포항","대구","청주"
	};
	public String getAirportId(String name) {
		int index=Arrays.asList(AirportName).indexOf(name);
		
		return AirportId[index];		
	}

}
