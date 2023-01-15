package com.club.business.board;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	//private final BoardMapper fileMapper;
	
	/**
	 * 게시판 목록 조회
	 * @param SearchVO
	 * @return List<CamelMap>
	 * @throws Exception
	 */
	public BoardVO selectBoardList(BoardVO vo) throws Exception{
		//전체 카운트
		int cnt = boardMapper.selectBoardListCnt(vo);
		//목록 조회
		if(cnt > 0) {
			vo.setBoardList(boardMapper.selectBoardList(vo));
		}
        return vo;
	}
	
	/**
	 * 게시판 조회
	 * @param BoardVO
	 * @return BoardVO
	 * @throws Exception
	 */
	public BoardVO selectBoardInfo(BoardVO vo) throws Exception{
		int key = 0, replyCnt = 0; 
		
		//게시물 조회
		key = vo.getSrchKey();
		BoardVO boardVO = boardMapper.selectBoardInfo(key);
		
		//댓글 목록
		replyCnt = boardVO.getReplyCnt();
		if(replyCnt > 0) {
			boardVO.setRepleList(boardMapper.selectBoardReplyList(key));
		}
		
		//파일 목록
		key = boardVO.getFileId();
		if(key > 0) {
			//boardVO.setFileList(fileMapper.selectFileList(key);	
		}
		return boardVO;
	}
	
	/**
	 * 게시판 저장
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void insertBoard(BoardVO vo) throws Exception{
		boardMapper.insertBoard(vo);
	}
	
	/**
	 * 게시판 수정
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void updateBoard(BoardVO vo) throws Exception{
		boardMapper.updateBoard(vo);
	}
	
	/**
	 * 게시판 삭제
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void deleteBoard(BoardVO vo) throws Exception{
		boardMapper.deleteBoardDelYn(vo);
	}
	
	/**
	 * 댓글 목록 조회
	 * @param BoardVO
	 * @return BoardVO
	 * @throws Exception
	 */
	public BoardVO selectBoardReplyList(BoardVO vo) throws Exception{
        vo.setRepleList(boardMapper.selectBoardReplyList(vo.getBoardNo()));
        return vo;
	}
	
	/**
	 * 댓글 저장
	 * @param BoardVO
	 * @throws Exception
	 */
	@Transactional
	public void insertBoardReply(BoardVO vo) throws Exception{
		boardMapper.insertBoardReply(vo);
	}
	
	/**
	 * 댓글 수정
	 * @param BoardVO
	 * @throws Exception
	 */
	@Transactional
	public void updateBoardReply(BoardVO vo) throws Exception{
		boardMapper.updateBoardReply(vo);
	}
	
	/**
	 * 댓글 삭제
	 * @param BoardVO
	 * @throws Exception
	 */
	@Transactional
	public void deleteBoardReply(BoardVO vo) throws Exception{
		boardMapper.deleteBoardReplyDelYn(vo);
	}
	
	/**
	 * 종아요/싫어요 업데이트
	 * @param BoardVO
	 * @throws Exception
	 */
	@Transactional
	public void updateBoardLikeHate(BoardVO vo) throws Exception{
		boardMapper.updateBoardLikeHate(vo);
	}
	
}
