package com.club.business.club;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.club.sys.cmmn.SearchVO;

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
	
	/**
	 * 클럽 목록 조회
	 * @param SearchVO
	 * @return List<ClubVO>
	 * @throws Exception
	 */
	public List<ClubVO> selectClubList(SearchVO params) throws Exception{
        List<ClubVO> list = clubMapper.selectClubList(params);
        return list;
	}
	
	/**
	 * 클럽 조회
	 * @param SearchVO
	 * @return ClubVO
	 * @throws Exception
	 */
	public ClubVO selectClubInfo(SearchVO params) throws Exception{
		return clubMapper.selectClubInfo(params);
	}
	
	/**
	 * 클럽 저장
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void insertClub(Map<String, Object> map) throws Exception{
		clubMapper.insertClub(map);
	}
	
	/**
	 * 클럽 수정
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void updateClub(Map<String, Object> map) throws Exception{
		clubMapper.updateClub(map);
	}
	
	/**
	 * 클럽 삭제
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void deleteClub(Map<String, Object> map) throws Exception{
		clubMapper.deleteClub(map);
	}
}
