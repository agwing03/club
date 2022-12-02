package com.club.business.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.club.sys.cmmn.SearchVO;

/**
 * 게시판 Service 
 * table : board 및 하위 테이블 
 * board 관련된 업무 로직
 */
@Mapper
public interface BoardMapper {

	/**
	 * 게시판 목록 조회
	 * @param SearchVO
	 * @return List<BoardVO>
	 */
	List<BoardVO> selectBoardList(SearchVO params);
	
	/**
	 * 게시판 조회
	 * @param SearchVO
	 * @return BoardVO
	 */
	BoardVO selectBoardInfo(SearchVO params);
	
	/**
	 * 게시판 저장
	 * @param Map<String,Object>
	 */
	void insertBoard(Map<String, Object> map);
	
	/**
	 * 게시판 수정
	 * @param Map<String,Object>
	 */
	void updateBoard(Map<String, Object> map);
	
	/**
	 *  삭제
	 * @param Map<String,Object>
	 */
	void deleteBoard(Map<String, Object> map);
	
	/**
	 * 댓글 목록 조회
	 * @param SearchVO
	 * @return List<BoardVO>
	 */
	List<BoardVO> selectBoardReplyList(SearchVO params);
	
	/**
	 * 댓글 저장
	 * @param Map<String,Object>
	 */
	void insertBoardReply(Map<String, Object> map);
	
	/**
	 * 댓글 수정
	 * @param Map<String,Object>
	 */
	void updateBoardReply(Map<String, Object> map);
	
	/**
	 * 댓글 삭제
	 * @param Map<String,Object>
	 */
	void deleteBoardReply(Map<String, Object> map);
}
