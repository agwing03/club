package com.club.business.club;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.club.sys.cmmn.CamelMap;

/**
 * 클럽 Service 
 * table : club 및 하위 테이블 
 * club 관련된 업무 로직
 */
@Mapper
public interface ClubMapper {

	/**
	 * 클럽 목록 조회
	 * @param ClubVO
	 * @return List<CamelMap>
	 */
	int selectClubListCnt(ClubVO vo);
	List<CamelMap> selectClubList(ClubVO vo);
	
	/**
	 * 클럽 조회
	 * @param ClubVO
	 * @return ClubVO
	 */
	ClubVO selectClubInfo(int clubNo);
	
	/**
	 * 클럽 저장
	 * @param ClubVO
	 */
	void insertClub(ClubVO vo);
	
	/**
	 * 클럽 수정
	 * @param ClubVO
	 */
	void updateClub(ClubVO vo);
	
	/**
	 * 클럽 삭제
	 * @param ClubVO
	 */
	void deleteClub(ClubVO vo);
	
	/**
	 * 모임 목록 조회
	 * @param ClubVO
	 * @return List<CamelMap>
	 */
	List<CamelMap> selectMeetingList(int clubNo);
	
	/**
	 * 모임 조회
	 * @param ClubVO
	 * @return ClubVO
	 */
	ClubVO selectMeetingInfo(int clubNo);
	
	/**
	 * 모임 저장
	 * @param ClubVO
	 */
	void insertMeeting(ClubVO vo);
	
	/**
	 * 모임 수정
	 * @param ClubVO
	 */
	void updateMeeting(ClubVO vo);
	
	/**
	 * 모임 삭제
	 * @param ClubVO
	 */
	void deleteMeeting(ClubVO vo);
}