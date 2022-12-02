package com.club.sys.cmmn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonVO {
    /**
	 * 공통 VO  
	 * 업무VO 상속
	 */
    private int 	regNo;
    private String 	regDt;
    private int 	frstRegId;
    private String 	frstRegDt;
    private int 	lastUpdId;
    private String 	lastUpdDt;
}
