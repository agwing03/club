package com.club.business.cmmn.login;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.club.business.cmmn.log.LogMapper;
import com.club.sys.cmmn.CamelMap;

/**
 * login success handler 
 * table : member, sys_login_log
 * 로그인 인증성공에 관련 조치
 */

@Component // Bean Cofig에 따로 등록하지 않아도 빈 등록자체를 빈 클래스 자체에다가 할 수 있음.
public class LoginAuthenSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	//private RequestCache requestCache = new HttpSessionRequestCache();
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
 
	@Autowired
	private LoginMapper LoginMapper;
	
	@Autowired
	private LogMapper logMapper;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
		//로그인ID
		String memberId = request.getParameter("userId");
		 
		//계정이 잠겨 있는지 체크
		LoginVO loginInfo = (LoginVO)authentication.getPrincipal();
		 
		//해당 계정이 잠겨 있으면  
		if(loginInfo.getLockYn().equals("Y")) {
			//계정정지 예외 발생 -> 실패 핸들러로 리턴 시킴
		  	throw new LockedException("로그인 시도 "+ loginInfo.getLoginFailCnt() + "회 실패로 계정이 잠겼습니다. 관리자에게 문의하시기 바랍니다.");
		}
		 
		//사용하지 않는 계정일 경우
		if(loginInfo.getUseYn().equals("N")) {
			throw new LockedException(memberId + "는(은) 접근이 거부된 ID입니다. 관리자에게 문의해 주세요.");
		}
		
		//성공시 이동 할 URL 설정
	    setDefaultTargetUrl("/main.do");
	    
	    //로그인 성공시 실패 횟수 및 락 타임 초기화
	    LoginMapper.updateFailCntReset(loginInfo.getMemberNo());
	    
	    /** 시스템 록그인 로그 */
		CamelMap logParam = new CamelMap();
		logParam.put("login_gbn", "S");
		logParam.put("login_member_id", memberId);
		logParam.put("login_ip",request.getRemoteAddr());
		logParam.put("err_msg", "정상 로그인");
		logParam.put("fail_cnt", 0);
		logParam.put("reg_id", loginInfo.getMemberNo());
		logMapper.insertLoginLog(logParam);
		
	    //로그인 세션 지우기
	    clearAuthenticationAttributes(request);
	    
	    //URL 이동
	    redirectStrategy.sendRedirect(request, response, getDefaultTargetUrl());
	 }
}
