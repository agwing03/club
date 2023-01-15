package com.club.business.cmmn.log;

import com.club.sys.cmmn.CommonVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogVO extends CommonVO{
    /**
	 * 시스템로그 VO 
	 * table : sys_log 관련 테이블 
	 */
	
	// 공통
	private int logNo;
	private String msg;
	private String ip;
	
	//시스템 에러 로그
	private String methodNm;
	private String paramData;
	
	//시스템 로그인 로그
	private String loginGbn;
	private int failCnt;
	
	//시스템 로그
	private String url;
}
