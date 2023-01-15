package com.club.business.club;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

/**
 * 클럽 Service 
 * table : club 및 하위 테이블 
 * club 관련된 업무 로직
 */
@Service
@RequiredArgsConstructor
public class ClubService {
	
	private final ClubMapper clubMapper;
	//private final FileMapper fileMapper;
	
	/**
	 * 클럽 목록 조회
	 * @param ClubVO
	 * @return ClubVO
	 * @throws Exception
	 */
	public ClubVO selectClubList(ClubVO vo) throws Exception{
        //전체 카운트
        int cnt = clubMapper.selectClubListCnt(vo);
        //목록 조회
        if(cnt > 0) {
        	vo.setClubList(clubMapper.selectClubList(vo));
        }
		return vo;
	}
	
	/**
	 * 클럽 조회
	 * @param ClubVO
	 * @return ClubVO
	 * @throws Exception
	 */
	public ClubVO selectClubInfo(ClubVO vo) throws Exception{
		int key = vo.getSrchKey();
		//클럽 정보 조회
		vo = clubMapper.selectClubInfo(key);
		
		//클럽 이미지 조회		
		//vo.setClubImgPath(fileMapper.selectFileInfo(vo.getClubImgNo()));
		
		//모임 목록 조회		
		vo.setMeetingList(clubMapper.selectMeetingList(key));
		return vo;
	}
	
	/**
	 * 클럽 저장
	 * @param ClubVO
	 * @throws Exception
	 */
	@Transactional
	public void insertClub(ClubVO vo) throws Exception{
		clubMapper.insertClub(vo);
	}
	
	/**
	 * 클럽 수정
	 * @param ClubVO
	 * @throws Exception
	 */
	@Transactional
	public void updateClub(ClubVO vo) throws Exception{
		clubMapper.updateClub(vo);
	}
	
	/**
	 * 클럽 삭제
	 * @param ClubVO
	 * @throws Exception
	 */
	@Transactional
	public void deleteClub(ClubVO vo) throws Exception{
		clubMapper.deleteClub(vo);
	}
	
	/**
	 * 모임 조회
	 * @param ClubVO
	 * @return ClubVO
	 * @throws Exception
	 */
	@Transactional
	public ClubVO selectMeetingInfo(ClubVO vo) throws Exception{
		int key = vo.getSrchKey();
		vo = clubMapper.selectMeetingInfo(key);
		return vo;
	}
	
	/**
	 * 모임 저장
	 * @param ClubVO
	 * @throws Exception
	 */
	@Transactional
	public void insertMeeting(ClubVO vo) throws Exception{
		clubMapper.insertMeeting(vo);
	}
	
	/**
	 * 모임 수정
	 * @param ClubVO
	 * @throws Exception
	 */
	@Transactional
	public void updateMeeting(ClubVO vo) throws Exception{
		clubMapper.updateMeeting(vo);
	}
	
	/**
	 * 모임 삭제
	 * @param ClubVO
	 * @throws Exception
	 */
	@Transactional
	public void deleteMeeting(ClubVO vo) throws Exception{
		clubMapper.deleteMeeting(vo);
	}
}