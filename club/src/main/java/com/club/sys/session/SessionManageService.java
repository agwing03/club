package com.club.sys.session;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SessionManageService {
	
	private final SessionManageMapper sessionMapper;
	
	/**
	 * 세션 관리 및 로그인 설정 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public SessionVO selectSessionInfo() throws Exception{
		return sessionMapper.selectSessionInfo();
	}
	
	/**
	 * 세션 관리 및 로그인 설정 수정 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public void updateSession(SessionVO sessionVO) throws Exception{
		sessionMapper.updateSession(sessionVO);
	}
	

}
