package com.club.business.cmmn.msg;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.club.sys.cmmn.SearchVO;

import lombok.RequiredArgsConstructor;

/**
 * 메세지 Service 
 * table :  
 * 메세지 및 알림 관련된 업무 로직
 */
@Service
@RequiredArgsConstructor
public class MsgBoxService {
	
	private final MsgBoxMapper clubMapper;
	
	/**
	 * 메세지 목록 조회
	 * @param SearchVO
	 * @return List<VO>
	 * @throws Exception
	 */
	public List<MsgBoxVO> selectMsgBoxList(SearchVO params) throws Exception{
        List<MsgBoxVO> list = clubMapper.selectMsgBoxList(params);
        return list;
	}
	
	/**
	 * 메세지 저장
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void insertMsgBox(Map<String, Object> map) throws Exception{
		clubMapper.insertMsgBox(map);
	}
	
	/**
	 * 메세지 수정
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void updateMsgBox(Map<String, Object> map) throws Exception{
		clubMapper.updateMsgBox(map);
	}
	
	/**
	 * 메세지 삭제
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void deleteMsgBox(Map<String, Object> map) throws Exception{
		clubMapper.deleteMsgBox(map);
	}
}
