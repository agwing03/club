package com.club.business.meeting;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.club.sys.cmmn.SearchVO;

/**
 * 모임 Service 
 * table : club 및 하위 테이블 
 * club 관련된 업무 로직
 */
@Mapper
public interface MeetingMapper {

	/**
	 * 모임 목록 조회
	 * @param SearchVO
	 * @return List<ClubVO>
	 */
	List<MeetingVO> selectClubMeetingList(SearchVO params);
	
	/**
	 * 맴버 조회
	 * @param SearchVO
	 * @return ClubVO
	 */
	MeetingVO selectClubMeetingInfo(SearchVO params);
	
	/**
	 * 모임 저장
	 * @param Map<String,Object>
	 */
	void insertClubMeeting(Map<String, Object> map);
	
	/**
	 * 모임 수정
	 * @param Map<String,Object>
	 */
	void updateClubMeeting(Map<String, Object> map);
	
	/**
	 * 모임 삭제
	 * @param Map<String,Object>
	 */
	void deleteClubMeeting(Map<String, Object> map);
}
