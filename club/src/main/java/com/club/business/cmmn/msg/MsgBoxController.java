package com.club.business.cmmn.msg;

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
public class MsgBoxController{
	
	/**
	 * 메세지 Controller 
	 * table :  
	 * 메세지 및 알림 관련된 업무 로직
	 */
	
	private final MsgBoxService meetingService;
	
	/**
	 * 메세지 목록 조회
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/meeting/selectMsgBoxList.do")
	public String selectMsgBoxList(
			HttpServletRequest req,
			@ModelAttribute("params") SearchVO params,
			Model model
		) throws Exception {
		//사용자 가입 클럽 및 추천 클럽
		model.addAttribute("response", meetingService.selectMsgBoxList(params));
		return "club/clubMeetingView";
	}
	
	/**
	 * 메세지 등록
	 * @param Map<String, Object>
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/meeting/insertMsgBox.do")
	public String insertMsgBox(
			HttpServletRequest req,
			@ModelAttribute("params") Map<String, Object> params,
			Model model
		) throws Exception {
		
		meetingService.insertMsgBox(params);
		model.addAttribute("searchVO", params);
		return "club/clubMeetingView";
	}
	
	/**
	 * 메세지 수정
	 * @param Map<String, Object>
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/meeting/updateMsgBox.do")
	public String updateMsgBox(
			HttpServletRequest req,
			@ModelAttribute("params") Map<String, Object> params,
			Model model
		) throws Exception {
		
		meetingService.updateMsgBox(params);
		model.addAttribute("searchVO", params);
		return "club/clubMeetingView";
	}
	
	/**
	 * 메세지 삭제
	 * @param Map<String, Object>
	 * @return Model 
	 * @throws Exception
	 */
	@RequestMapping("/meeting/deleteMsgBox.do")
	public String deleteMsgBox(
			HttpServletRequest req,
			@ModelAttribute("params") Map<String, Object> params,
			Model model
		) throws Exception {
		
		meetingService.deleteMsgBox(params);
		model.addAttribute("searchVO", params);
		return "club/clubMeetingView";
	}
}
