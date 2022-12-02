package com.club.business.cmmn.code;

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
public class CodeController extends LayoutModule {
	
	/**
	 * 공통코드 Controller 
	 * table : cmmn_code, cmmn_code_dtl
	 * 공통코드 단일 테이블 관련된 모든 connection
	 */
	
	private final CodeService codeService;
	
	/**
	 * 공통코드 목록 조회
	 * @param SearchVO
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/cmmn/selectCodeList.do")
	public String selectCodeList(
			HttpServletRequest req,
			@ModelAttribute("params") SearchVO params,
			Model model
		) throws Exception {
		
		model.addAttribute("response", codeService.selectCodeList(params));
		model.addAttribute("searchVO", params);
		return "cmmn/CmmnCodeView";
	}
	
	/**
	 * 공통코드 등록
	 * @param Map<String, Object>
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/cmmn/insertCode.do")
	public String insertCode(
			HttpServletRequest req,
			@ModelAttribute("params") Map<String, Object> params,
			Model model
		) throws Exception {
		
		codeService.insertCode(params);
		model.addAttribute("searchVO", params);
		return "cmmn/CmmnCodeView";
	}
	
	/**
	 * 공통코드 수정
	 * @param Map<String, Object>
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/cmmn/updateCode.do")
	public String updateCode(
			HttpServletRequest req,
			@ModelAttribute("params") Map<String, Object> params,
			Model model
		) throws Exception {
		
		codeService.updateCode(params);
		model.addAttribute("searchVO", params);
		return "cmmn/CmmnCodeView";
	}
	
	/**
	 * 공통코드 삭제
	 * @param Map<String, Object>
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/cmmn/deleteCode.do")
	public String deleteCode(
			HttpServletRequest req,
			@ModelAttribute("params") Map<String, Object> params,
			Model model
		) throws Exception {
		
		codeService.deleteCode(params);
		model.addAttribute("searchVO", params);
		return "cmmn/CmmnCodeView";
	}
	
	/**
	 * 상세코드 목록 조회
	 * @param SearchVO
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/cmmn/selectCodeDtlList.do")
	public String selectCodeDtlList(
			HttpServletRequest req,
			@ModelAttribute("params") SearchVO params,
			Model model
		) throws Exception {
		
		model.addAttribute("response", codeService.selectCodeDtlList(params));
		model.addAttribute("searchVO", params);
		return "cmmn/CmmnCodeView";
	}
	
	/**
	 * 상세코드 등록
	 * @param Map<String, Object>
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/cmmn/insertCodeDtl.do")
	public String insertCodeDtl(
			HttpServletRequest req,
			@ModelAttribute("params") Map<String, Object> params,
			Model model
		) throws Exception {
		
		codeService.insertCodeDtl(params);
		model.addAttribute("searchVO", params);
		return "cmmn/CmmnCodeView";
	}
	
	/**
	 * 상세코드 수정
	 * @param Map<String, Object>
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/cmmn/updateCodeDtl.do")
	public String updateCodeDtl(
			HttpServletRequest req,
			@ModelAttribute("params") Map<String, Object> params,
			Model model
		) throws Exception {
		
		codeService.updateCodeDtl(params);
		model.addAttribute("searchVO", params);
		return "cmmn/CmmnCodeView";
	}
	
	/**
	 * 상세코드 삭제
	 * @param Map<String, Object>
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/cmmn/deleteCodeDtl.do")
	public String deleteCodeDtl(
			HttpServletRequest req,
			@ModelAttribute("params") Map<String, Object> params,
			Model model
		) throws Exception {
		
		codeService.deleteCodeDtl(params);
		model.addAttribute("searchVO", params);
		return "cmmn/CmmnCodeView";
	}
}
