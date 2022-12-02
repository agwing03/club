package com.club.business.board;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.club.sys.cmmn.SearchVO;

import lombok.RequiredArgsConstructor;

/**
 * 게시판 Service 
 * table : board 및 하위 테이블 
 * board 관련된 업무 로직
 */
@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardMapper boardMapper;
	
	/**
	 * 게시판 목록 조회
	 * @param SearchVO
	 * @return List<BoardVO>
	 * @throws Exception
	 */
	public List<BoardVO> selectBoardList(SearchVO params) throws Exception{
        List<BoardVO> list = boardMapper.selectBoardList(params);
        return list;
	}
	
	/**
	 * 게시판 조회
	 * @param SearchVO
	 * @return BoardVO
	 * @throws Exception
	 */
	public BoardVO selectBoardInfo(SearchVO params) throws Exception{
		return boardMapper.selectBoardInfo(params);
	}
	
	/**
	 * 게시판 저장
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void insertBoard(Map<String, Object> map) throws Exception{
		boardMapper.insertBoard(map);
	}
	
	/**
	 * 게시판 수정
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void updateBoard(Map<String, Object> map) throws Exception{
		boardMapper.updateBoard(map);
	}
	
	/**
	 * 게시판 삭제
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void deleteBoard(Map<String, Object> map) throws Exception{
		boardMapper.deleteBoard(map);
	}
	
	/**
	 * 댓글 목록 조회
	 * @param SearchVO
	 * @return List<BoardVO>
	 * @throws Exception
	 */
	public List<BoardVO> selectBoardReplyList(SearchVO params) throws Exception{
        List<BoardVO> list = boardMapper.selectBoardReplyList(params);
        return list;
	}
	
	/**
	 * 댓글 저장
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void insertBoardReply(Map<String, Object> map) throws Exception{
		boardMapper.insertBoardReply(map);
	}
	
	/**
	 * 댓글 수정
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void updateBoardReply(Map<String, Object> map) throws Exception{
		boardMapper.updateBoardReply(map);
	}
	
	/**
	 * 댓글 삭제
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void deleteBoardReply(Map<String, Object> map) throws Exception{
		boardMapper.deleteBoardReply(map);
	}
}
