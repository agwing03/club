package com.club.business.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

/**
 * 게시판 Controller 
 * table : board 및 하위 테이블 
 * board 관련된 업무 로직
 */

@Controller
@RequiredArgsConstructor // final 필드나 @Nonnull이 붙은 필드에 대해 생성자를 주입해줌
//public class BoardController extends LayoutModule {
public class BoardController{
	
	private final BoardService boardService;
	
	/**
	 * 게시판 목록 조회
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/board/selectBoardList.do")
	public String selectBoardList(
			HttpServletRequest req,
			@ModelAttribute("params") BoardVO vo,
			Model model
		) throws Exception {
		
		model.addAttribute("response", boardService.selectBoardList(vo));
		return "board/boardView";
	}
	
	/**
	 * 게시판 조회
	 * @param BoardVO
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/board/selectBoardInfo.do")
	public String selectBoardInfo(
			HttpServletRequest req,
			@ModelAttribute("params") BoardVO vo,
			Model model
		) throws Exception {
		
		model.addAttribute("response", boardService.selectBoardInfo(vo));
		return "board/boardView";
	}
	
	/**
	 * 게시판 등록
	 * @param BoardVO
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/board/insertBoard.do")
	public String insertBoard(
			HttpServletRequest req,
			@ModelAttribute("params") BoardVO vo,
			Model model
		) throws Exception {
		
		boardService.insertBoard(vo);
		return "board/boardView";
	}
	
	/**
	 * 게시판 수정
	 * @param BoardVO
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/board/updateBoard.do")
	public String updateBoard(
			HttpServletRequest req,
			@ModelAttribute("params") BoardVO vo,
			Model model
		) throws Exception {
		
		boardService.updateBoard(vo);
		return "board/boardView";
	}
	
	/**
	 * 게시판 삭제
	 * @param BoardVO
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/board/deleteBoard.do")
	public String deleteBoard(
			HttpServletRequest req,
			@ModelAttribute("params") BoardVO vo,
			Model model
		) throws Exception {
		
		boardService.deleteBoard(vo);
		return "board/boardView";
	}
	
	/**
	 * 댓글 목록 조회
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/board/selectBoardReplyList.do")
	public String selectBoardReplyList(
			HttpServletRequest req,
			@ModelAttribute("params") BoardVO vo,
			Model model
		) throws Exception {
		vo = boardService.selectBoardReplyList(vo);
		model.addAttribute("response", vo.getRepleList());
		return "board/boardView";
	}
	
	/**
	 * 댓글 등록
	 * @param BoardVO
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/board/insertBoardReply.do")
	public String insertBoardReply(
			HttpServletRequest req,
			@ModelAttribute("params") BoardVO vo,
			Model model
		) throws Exception {
		
		boardService.insertBoardReply(vo);
		return "board/boardView";
	}
	
	/**
	 * 댓글 수정
	 * @param BoardVO
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/board/updateBoardReply.do")
	public String updateBoardReply(
			HttpServletRequest req,
			@ModelAttribute("params") BoardVO vo,
			Model model
		) throws Exception {
		
		boardService.updateBoardReply(vo);
		return "board/boardView";
	}
	
	/**
	 * 댓글 삭제
	 * @param BoardVO
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/board/deleteBoardReply.do")
	public String deleteBoardReply(
			HttpServletRequest req,
			@ModelAttribute("params") BoardVO vo,
			Model model
		) throws Exception {
		
		boardService.deleteBoardReply(vo);
		return "board/boardView";
	}
	
	/**
	 * 종아요/싫어요 업데이트
	 * @param BoardVO
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/board/updateBoardLikeHate.do")
	public String updateBoardLikeHate(
			HttpServletRequest req,
			@ModelAttribute("params") BoardVO vo,
			Model model
		) throws Exception {
		
		boardService.updateBoardLikeHate(vo);
		return "board/boardView";
	}
}