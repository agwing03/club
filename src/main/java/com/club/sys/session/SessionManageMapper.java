package com.club.sys.session;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SessionManageMapper {
	
	/**
	 * 세션 관리 및 로그인 설정 
	 * @param commandMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	SessionVO selectSessionInfo() throws Exception;
	
	/**
	 * 세션 관리 및 로그인 설정 수정 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	void updateSession(SessionVO sessionVO) throws Exception;

}
