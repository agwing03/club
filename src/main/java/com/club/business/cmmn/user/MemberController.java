package com.club.business.cmmn.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor // final 필드나 @Nonnull이 붙은 필드에 대해 생성자를 주입해줌
//public class ClubController extends LayoutModule {
public class MemberController{
	
	/**
	 * 맴버 Controller 
	 * table : club 및 하위 테이블 
	 * club 관련된 업무 로직
	 */
	
	private final MemberService memberService;
	
	/**
	 * 맴버 목록 조회
	 * @return Model 
	 * @throws Exception
	 */
	
	/**
	 * 맴버 조회
	 * @return Model 
	 * @throws Exception
	 */
	
	/**
	 * 맴버 등록
	 * @param ClubVO
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/user/insertMember.do")
	public String insertMember(
			HttpServletRequest req,
			@ModelAttribute("params") MemberVO vo,
			Model model
		) throws Exception {
		
		memberService.insertMember(vo);
		model.addAttribute("msg", "가입을 환영합니다.");
		return "/login";
	}
	
	/**
	 * 맴버 수정
	 * @param ClubVO
	 * @return Model 
	 * @throws Exception
	 */
	
	/**
	 * 맴버 삭제
	 * @param ClubVO
	 * @return Model 
	 * @throws Exception
	 */
	
}