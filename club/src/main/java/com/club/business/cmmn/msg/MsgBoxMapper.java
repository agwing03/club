package com.club.business.cmmn.msg;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.club.sys.cmmn.SearchVO;

/**
 * 메세지 Service 
 * table :  
 * 메세지 및 알림 관련된 업무 로직
 */
@Mapper
public interface MsgBoxMapper {

	/**
	 * 메세지 목록 조회
	 * @param SearchVO
	 * @return List<ClubVO>
	 */
	List<MsgBoxVO> selectMsgBoxList(SearchVO params);
	
	/**
	 * 맴버 조회
	 * @param SearchVO
	 * @return ClubVO
	 */
	MsgBoxVO selectMsgBoxInfo(SearchVO params);
	
	/**
	 * 메세지 저장
	 * @param Map<String,Object>
	 */
	void insertMsgBox(Map<String, Object> map);
	
	/**
	 * 메세지 수정
	 * @param Map<String,Object>
	 */
	void updateMsgBox(Map<String, Object> map);
	
	/**
	 * 메세지 삭제
	 * @param Map<String,Object>
	 */
	void deleteMsgBox(Map<String, Object> map);
}
