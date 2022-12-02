package com.club.business.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.club.sys.cmmn.SearchVO;

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
			@ModelAttribute("params") SearchVO params,
			Model model
		) throws Exception {
		//사용자 가입 게시판 및 추천 게시판
		model.addAttribute("response", boardService.selectBoardList(params));
		return "board/boardView";
	}
	
	/**
	 * 게시판 조회
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/board/selectBoardList.do")
	public String selectBoardInfo(
			HttpServletRequest req,
			@ModelAttribute("params") SearchVO params,
			Model model
		) throws Exception { 
		
		model.addAttribute("response", boardService.selectBoardInfo(params));
		model.addAttribute("searchVO", params);
		return "board/boardView";
	}
	
	/**
	 * 게시판 등록
	 * @param Map<String, Object>
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/board/insertBoard.do")
	public String insertBoard(
			HttpServletRequest req,
			@ModelAttribute("params") Map<String, Object> params,
			Model model
		) throws Exception {
		
		boardService.insertBoard(params);
		model.addAttribute("searchVO", params);
		return "board/boardView";
	}
	
	/**
	 * 게시판 수정
	 * @param Map<String, Object>
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/board/updateBoard.do")
	public String updateBoard(
			HttpServletRequest req,
			@ModelAttribute("params") Map<String, Object> params,
			Model model
		) throws Exception {
		
		boardService.updateBoard(params);
		model.addAttribute("searchVO", params);
		return "board/boardView";
	}
	
	/**
	 * 게시판 삭제
	 * @param Map<String, Object>
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/board/deleteBoard.do")
	public String deleteBoard(
			HttpServletRequest req,
			@ModelAttribute("params") Map<String, Object> params,
			Model model
		) throws Exception {
		
		boardService.deleteBoard(params);
		model.addAttribute("searchVO", params);
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
			@ModelAttribute("params") SearchVO params,
			Model model
		) throws Exception {
		//사용자 가입 게시판 및 추천 게시판
		model.addAttribute("response", boardService.selectBoardReplyList(params));
		return "board/boardView";
	}
	
	/**
	 * 댓글 등록
	 * @param Map<String, Object>
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/board/insertBoardReply.do")
	public String insertBoardReply(
			HttpServletRequest req,
			@ModelAttribute("params") Map<String, Object> params,
			Model model
		) throws Exception {
		
		boardService.insertBoardReply(params);
		model.addAttribute("searchVO", params);
		return "board/boardView";
	}
	
	/**
	 * 댓글 수정
	 * @param Map<String, Object>
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/board/updateBoardReply.do")
	public String updateBoardReply(
			HttpServletRequest req,
			@ModelAttribute("params") Map<String, Object> params,
			Model model
		) throws Exception {
		
		boardService.updateBoardReply(params);
		model.addAttribute("searchVO", params);
		return "board/boardView";
	}
	
	/**
	 * 댓글 삭제
	 * @param Map<String, Object>
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/board/deleteBoardReply.do")
	public String deleteBoardReply(
			HttpServletRequest req,
			@ModelAttribute("params") Map<String, Object> params,
			Model model
		) throws Exception {
		
		boardService.deleteBoardReply(params);
		model.addAttribute("searchVO", params);
		return "board/boardView";
	}
}
