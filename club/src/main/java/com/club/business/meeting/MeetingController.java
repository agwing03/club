package com.club.business.meeting;

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
public class MeetingController{
	
	/**
	 * 클럽 모임 Controller 
	 * table : club 및 meeting 하위 테이블 
	 * meeting 관련된 업무 로직
	 */
	
	private final MeetingService meetingService;
	
	/**
	 * 모임 목록 조회
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/meeting/selectClubMeetingList.do")
	public String selectClubMeetingList(
			HttpServletRequest req,
			@ModelAttribute("params") SearchVO params,
			Model model
		) throws Exception {
		//사용자 가입 클럽 및 추천 클럽
		model.addAttribute("response", meetingService.selectClubMeetingList(params));
		return "club/clubMeetingView";
	}
	
	/**
	 * 모임 조회
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/meeting/selectClubMeetingInfo.do")
	public String selectClubMeetingInfo(
			HttpServletRequest req,
			@ModelAttribute("params") SearchVO params,
			Model model
		) throws Exception {
		
		model.addAttribute("response", meetingService.selectClubMeetingInfo(params));
		model.addAttribute("searchVO", params);
		return "club/clubView";
	}
	
	/**
	 * 모임 등록
	 * @param Map<String, Object>
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/meeting/insertClubMeeting.do")
	public String insertClubMeeting(
			HttpServletRequest req,
			@ModelAttribute("params") Map<String, Object> params,
			Model model
		) throws Exception {
		
		meetingService.insertClubMeeting(params);
		model.addAttribute("searchVO", params);
		return "club/clubMeetingView";
	}
	
	/**
	 * 모임 수정
	 * @param Map<String, Object>
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/meeting/updateClubMeeting.do")
	public String updateClubMeeting(
			HttpServletRequest req,
			@ModelAttribute("params") Map<String, Object> params,
			Model model
		) throws Exception {
		
		meetingService.updateClubMeeting(params);
		model.addAttribute("searchVO", params);
		return "club/clubMeetingView";
	}
	
	/**
	 * 모임 삭제
	 * @param Map<String, Object>
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/meeting/deleteClubMeeting.do")
	public String deleteClubMeeting(
			HttpServletRequest req,
			@ModelAttribute("params") Map<String, Object> params,
			Model model
		) throws Exception {
		
		meetingService.deleteClubMeeting(params);
		model.addAttribute("searchVO", params);
		return "club/clubMeetingView";
	}
}
