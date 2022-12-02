package com.club.business.club;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.club.sys.cmmn.SearchVO;

/**
 * 클럽 Service 
 * table : club 및 하위 테이블 
 * club 관련된 업무 로직
 */
@Mapper
public interface ClubMapper {

	/**
	 * 클럽 목록 조회
	 * @param SearchVO
	 * @return List<ClubVO>
	 */
	List<ClubVO> selectClubList(SearchVO params);
	
	/**
	 * 클럽 조회
	 * @param SearchVO
	 * @return ClubVO
	 */
	ClubVO selectClubInfo(SearchVO params);
	
	/**
	 * 클럽 저장
	 * @param Map<String,Object>
	 */
	void insertClub(Map<String, Object> map);
	
	/**
	 * 클럽 수정
	 * @param Map<String,Object>
	 */
	void updateClub(Map<String, Object> map);
	
	/**
	 *  삭제
	 * @param Map<String,Object>
	 */
	void deleteClub(Map<String, Object> map);
}
