package com.club.business.cmmn.log;

import org.apache.ibatis.annotations.Mapper;

/**
 * 시스템 로그 공통 Mapper 
 * table : sys_error_log, sys_login_log
 * 시스템 로그 관련된 모든 connection
 */
@Mapper
public interface LogMapper {
 
	/**
	 * 시스템 로그인 로그 저장
	 * @param CodeVO
	 */
	void insertLoginLog(LogVO vo);
	
	/**
	 * 시스템 에러 로그 저장
	 * @param CodeVO
	 */
	void insertErrLog(LogVO vo);
}
