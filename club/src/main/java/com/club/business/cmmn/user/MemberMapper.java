package com.club.business.cmmn.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.club.sys.cmmn.SearchVO;

/**
 * 맴버 Mapper 
 * table : member
 * member 단일 테이블 관련된 모든 connection
 */
@Mapper
public interface MemberMapper {

	/**
	 * 맴버 리스트 조회
	 * @param SearchVO
	 * @return Integer
	 */
	int selectMemberListCnt(SearchVO params);
	
	/**
	 * 맴버 리스트 조회
	 * @param SearchVO
	 * @return List<MemberVO>
	 */
	List<MemberVO> selectMemberList(SearchVO params);
		
	/**
	 * 맴버 정보 조회
	 * @param String memberId
	 * @return MemberVO
	 */
	MemberVO selectMemberInfo(SearchVO params);
    
	/**
	 * 맴버 정보 저장
	 * @param Map<String,Object>
	 */
	void insertMember(Map<String, Object> paramMap);
    
	/**
	 * 맴버 정보 변경
	 * @param Map<String,Object>
	 */
	void updateMember(Map<String, Object> paramMap);
	
	/**
	 * 아이디 중복체크
	 * @param String memberId
	 * @return Integer
	 */
	int selectMemberId(String memberId);
	
}
