package com.club.business.club;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.club.sys.cmmn.SearchVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor // final 필드나 @Nonnull이 붙은 필드에 대해 생성자를 주입해줌
//public class ClubController extends LayoutModule {
public class ClubController{
	
	/**
	 * 클럽 Controller 
	 * table : club 및 하위 테이블 
	 * club 관련된 업무 로직
	 */
	
	private final ClubService clubService;
	
	/**
	 * 클럽 목록 조회
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/club/selectClubList.do")
	public String selectClubList(
			HttpServletRequest req,
			@ModelAttribute("params") SearchVO params,
			Model model
		) throws Exception {
		//사용자 가입 클럽 및 추천 클럽
		model.addAttribute("response", clubService.selectClubList(params));
		return "club/clubView";
	}
	
	/**
	 * 클럽 조회
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/club/selectClubInfo.do")
	public String selectClubInfo(
			HttpServletRequest req,
			@ModelAttribute("params") SearchVO params,
			Model model
		) throws Exception {
		
		model.addAttribute("response", clubService.selectClubInfo(params));
		model.addAttribute("searchVO", params);
		return "club/clubView";
	}
	
	/**
	 * 클럽 등록
	 * @param Map<String, Object>
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/club/insertClub.do")
	public String insertClub(
			HttpServletRequest req,
			@ModelAttribute("params") Map<String, Object> params,
			Model model
		) throws Exception {
		
		clubService.insertClub(params);
		model.addAttribute("searchVO", params);
		return "club/clubView";
	}
	
	/**
	 * 클럽 수정
	 * @param Map<String, Object>
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/club/updateClub.do")
	public String updateClub(
			HttpServletRequest req,
			@ModelAttribute("params") Map<String, Object> params,
			Model model
		) throws Exception {
		
		clubService.updateClub(params);
		model.addAttribute("searchVO", params);
		return "club/clubView";
	}
	
	/**
	 * 클럽 삭제
	 * @param Map<String, Object>
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/club/deleteClub.do")
	public String deleteClub(
			HttpServletRequest req,
			@ModelAttribute("params") Map<String, Object> params,
			Model model
		) throws Exception {
		
		clubService.deleteClub(params);
		model.addAttribute("searchVO", params);
		return "club/clubView";
	}
}
