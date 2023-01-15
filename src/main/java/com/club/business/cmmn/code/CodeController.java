package com.club.business.cmmn.code;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.club.sys.cmmn.LayoutModule;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor // final 필드나 @Nonnull이 붙은 필드에 대해 생성자를 주입해줌
public class CodeController extends LayoutModule {
	
	/**
	 * 공통코드 Controller 
	 * table : cmmn_code, cmmn_code_dtl
	 * 공통코드 단일 테이블 관련된 모든 connection
	 */
	
	private final CodeService codeService;
	
	/**
	 * 공통코드 목록 조회
	 * @param CodeVO
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/cmmn/selectCodeList.do")
	public String selectCodeList(
			HttpServletRequest req,
			@ModelAttribute("params") CodeVO vo,
			Model model
		) throws Exception {
		
		model.addAttribute("response", codeService.selectCodeList(vo));
		return "cmmn/CmmnCodeView";
	}
	
	/**
	 * 공통코드 등록
	 * @param CodeVO
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/cmmn/insertCode.do")
	public String insertCode(
			HttpServletRequest req,
			@ModelAttribute("params") CodeVO vo,
			Model model
		) throws Exception {
		
		codeService.insertCode(vo);
		return "cmmn/CmmnCodeView";
	}
	
	/**
	 * 공통코드 수정
	 * @param CodeVO
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/cmmn/updateCode.do")
	public String updateCode(
			HttpServletRequest req,
			@ModelAttribute("params") CodeVO vo,
			Model model
		) throws Exception {
		
		codeService.updateCode(vo);
		return "cmmn/CmmnCodeView";
	}
	
	/**
	 * 공통코드 삭제
	 * @param CodeVO
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/cmmn/deleteCode.do")
	public String deleteCode(
			HttpServletRequest req,
			@ModelAttribute("params") CodeVO vo,
			Model model
		) throws Exception {
		
		codeService.deleteCode(vo);
		return "cmmn/CmmnCodeView";
	}
	
	/**
	 * 상세코드 목록 조회
	 * @param CodeVO
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/cmmn/selectCodeDtlList.do")
	public String selectCodeDtlList(
			HttpServletRequest req,
			@ModelAttribute("params") CodeVO vo,
			Model model
		) throws Exception {
		
		model.addAttribute("response", codeService.selectCodeDtlList(vo));
		return "cmmn/CmmnCodeView";
	}
	
	/**
	 * 상세코드 등록
	 * @param CodeVO
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/cmmn/insertCodeDtl.do")
	public String insertCodeDtl(
			HttpServletRequest req,
			@ModelAttribute("params") CodeVO vo,
			Model model
		) throws Exception {
		
		codeService.insertCodeDtl(vo);
		return "cmmn/CmmnCodeView";
	}
	
	/**
	 * 상세코드 수정
	 * @param CodeVO
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/cmmn/updateCodeDtl.do")
	public String updateCodeDtl(
			HttpServletRequest req,
			@ModelAttribute("params") CodeVO vo,
			Model model
		) throws Exception {
		
		codeService.updateCodeDtl(vo);
		return "cmmn/CmmnCodeView";
	}
	
	/**
	 * 상세코드 삭제
	 * @param CodeVO
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/cmmn/deleteCodeDtl.do")
	public String deleteCodeDtl(
			HttpServletRequest req,
			@ModelAttribute("params") CodeVO vo,
			Model model
		) throws Exception {
		
		codeService.deleteCodeDtl(vo);
		return "cmmn/CmmnCodeView";
	}
}