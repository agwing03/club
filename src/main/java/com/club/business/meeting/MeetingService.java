package com.club.business.meeting;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.club.sys.cmmn.SearchVO;

import lombok.RequiredArgsConstructor;

/**
 * 모임 Service 
 * table : club 및 meeting 하위 테이블 
 * meeting 관련된 업무 로직
 */
@Service
@RequiredArgsConstructor
public class MeetingService {
	
	private final MeetingMapper clubMapper;
	
	/**
	 * 모임 목록 조회
	 * @param SearchVO
	 * @return List<ClubVO>
	 * @throws Exception
	 */
	public List<MeetingVO> selectClubMeetingList(SearchVO params) throws Exception{
        List<MeetingVO> list = clubMapper.selectClubMeetingList(params);
        return list;
	}
	
	/**
	 * 모임 조회
	 * @param SearchVO
	 * @return ClubVO
	 * @throws Exception
	 */
	public MeetingVO selectClubMeetingInfo(SearchVO params) throws Exception{
		return clubMapper.selectClubMeetingInfo(params);
	}
	
	/**
	 * 모임 저장
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void insertClubMeeting(Map<String, Object> map) throws Exception{
		clubMapper.insertClubMeeting(map);
	}
	
	/**
	 * 모임 수정
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void updateClubMeeting(Map<String, Object> map) throws Exception{
		clubMapper.updateClubMeeting(map);
	}
	
	/**
	 * 모임 삭제
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void deleteClubMeeting(Map<String, Object> map) throws Exception{
		clubMapper.deleteClubMeeting(map);
	}
}
