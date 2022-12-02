package com.club.business.cmmn.auth;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.club.sys.cmmn.LayoutModule;
import com.club.sys.cmmn.SearchVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor // final 필드나 @Nonnull이 붙은 필드에 대해 생성자를 주입해줌
public class AuthorController extends LayoutModule {
	
	/**
	 * 권한 Controller 
	 * table : author
	 * author 단일 테이블 관련된 모든 connection
	 */
	
	private final AuthorService authorService;
	
	/**
	 * 권한 목록 조회
	 * @param SearchVO
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/cmmn/selectAuthorList.do")
	public String selectAuthorList(
			HttpServletRequest req,
			@ModelAttribute("params") SearchVO params,
			Model model
		) throws Exception {
		
		model.addAttribute("response", authorService.selectAuthorList(params));
		model.addAttribute("searchVO", params);
		return "cmmn/CmmnCodeView";
	}
	
	/**
	 * 권한 등록
	 * @param Map<String, Object>
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/cmmn/insertAuthor.do")
	public String insertAuthor(
			HttpServletRequest req,
			@ModelAttribute("params") Map<String, Object> params,
			Model model
		) throws Exception {
		
		authorService.insertAuthor(params);
		model.addAttribute("searchVO", params);
		return "cmmn/CmmnCodeView";
	}
	
	/**
	 * 권한 수정
	 * @param Map<String, Object>
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/cmmn/updateAuthor.do")
	public String updateAuthor(
			HttpServletRequest req,
			@ModelAttribute("params") Map<String, Object> params,
			Model model
		) throws Exception {
		
		authorService.updateAuthor(params);
		model.addAttribute("searchVO", params);
		return "cmmn/CmmnCodeView";
	}
	
	/**
	 * 권한 삭제
	 * @param Map<String, Object>
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/cmmn/deleteAuthor.do")
	public String deleteAuthor(
			HttpServletRequest req,
			@ModelAttribute("params") Map<String, Object> params,
			Model model
		) throws Exception {
		
		authorService.deleteAuthor(params);
		model.addAttribute("searchVO", params);
		return "cmmn/CmmnCodeView";
	}
}
