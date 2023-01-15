package com.club.business.cmmn.log;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

/**
 * 시스템 로그 공통 Service 
 * table : sys_error_log, sys_login_log
 * 시스템 로그 관련된 모든 connection
 */

@Service
@RequiredArgsConstructor
public class LogService {
	
	private final LogMapper logMapper;
	
	/**
	 * 시스템 로그인 로그 저장
	 * @param LogVO
	 * @throws Exception
	 */
	@Transactional
	public void insertLoginLog(LogVO vo) throws Exception{
		logMapper.insertLoginLog(vo);
	}
	
	/**
	 * 시스템 에러 로그 저장
	 * @param LogVO
	 * @throws Exception
	 */
	@Transactional
	public void insertErrLog(LogVO vo) throws Exception{
		logMapper.insertErrLog(vo);
	}
}
