package com.club.business.cmmn.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.club.sys.cmmn.CamelMap;

/**
 * 맴버 Mapper 
 * table : member
 * member 단일 테이블 관련된 모든 connection
 */
@Mapper
public interface MemberMapper {

	/**
	 * 맴버 목록 조회
	 * @param MemberVO
	 * @return List<CamelMap>
	 */
	List<CamelMap> selectMemberList(MemberVO vo);
	int selectMemberListCnt(MemberVO vo);
		
	/**
	 * 맴버 정보 조회
	 * @param MemberVO
	 * @return MemberVO
	 */
	MemberVO selectMemberInfo(MemberVO vo);
    
	/**
	 * 맴버 정보 저장
	 * @param MemberVO
	 */
	void insertMember(MemberVO vo);
    
	/**
	 * 맴버 정보 변경
	 * @param MemberVO
	 */
	void updateMember(MemberVO vo);
	
	/**
	 * 맴버 아이디 중복체크
	 * @param String memberId
	 * @return Integer
	 */
	int selectMemberIdCheck(String memberId);
}
