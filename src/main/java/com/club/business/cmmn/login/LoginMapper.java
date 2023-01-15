package com.club.business.cmmn.login;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface LoginMapper {
	
    /**
     * 로그인 맴버 정보 조회
     * @param LoginVO
     * @return String memberId
     */
    LoginVO selectLoginMemberInfo(String memberId);
    
    /**
     * 로그인 맴버 권한 조회
     * @param int memberNo
     * @param List<String> authorId
     */
    List<String> selectAuthorities(int memberNo);
    
	/**
	 * 로그인 성공시 실패 횟수 초기화
	 * @param int memberNo
	 */
	void updateFailCntReset(int memberNo);
	
	/**
	 * 로그인 실패 횟수 증가
	 * @param int memberNo
	 */
	void updateFailCntAdd(int memberNo);
	
	/**
	 * 로그인 계정 잠금 or 잠금해제
	 * @param int memberNo
	 */
	void updateFailLock(int memberNo);
	
	/**
     * 세션 시간 받아오기
     * @param
     * @return
     * @throws Exception
     */
	int selectSessionMin() throws Exception;
}
