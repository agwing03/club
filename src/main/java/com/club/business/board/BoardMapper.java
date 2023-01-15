package com.club.business.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.club.sys.cmmn.CamelMap;

/**
 * 게시판 Service 
 * table : board 및 하위 테이블 
 * board 관련된 업무 로직
 */
@Mapper
public interface BoardMapper {

	/**
	 * 게시판 목록 조회
	 * @param BoardVO
	 * @return List<CamelMap>
	 */
	int selectBoardListCnt(BoardVO vo);
	List<CamelMap> selectBoardList(BoardVO vo);
	
	/**
	 * 게시판 조회
	 * @param Integer
	 * @return BoardVO
	 */
	BoardVO selectBoardInfo(int boardNo);
	
	/**
	 * 게시판 저장
	 * @param BoardVO
	 */
	void insertBoard(BoardVO vo);
	
	/**
	 * 게시판 수정
	 * @param BoardVO
	 */
	void updateBoard(BoardVO vo);
	
	/**
	 *  삭제
	 * @param BoardVO
	 */
	void deleteBoard(BoardVO vo);
	void deleteBoardDelYn(BoardVO vo);
	
	/**
	 * 댓글 목록 조회
	 * @param Integer
	 * @return List<CamelMap>
	 */
	List<CamelMap> selectBoardReplyList(int boardNo);
	
	/**
	 * 댓글 저장
	 * @param BoardVO
	 */
	void insertBoardReply(BoardVO vo);
	
	/**
	 * 댓글 수정
	 * @param BoardVO
	 */
	void updateBoardReply(BoardVO vo);
	
	/**
	 * 댓글 삭제
	 * @param BoardVO
	 */
	void deleteBoardReply(BoardVO vo);
	void deleteBoardReplyDelYn(BoardVO vo);
	
	/**
	 * 종아요/싫어요 업데이트
	 * @param BoardVO
	 */
	void updateBoardLikeHate(BoardVO vo);
}
