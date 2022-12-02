package com.club.business.cmmn.login;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.club.business.cmmn.log.LogMapper;
import com.club.sys.cmmn.CamelMap;

/**
 * login fail handler 
 * table : member, sys_login_log
 * 로그인 인증실패에 관련 조치
 */

@Component // Bean Cofig에 따로 등록하지 않아도 빈 등록자체를 빈 클래스 자체에다가 할 수 있음.
public class LoginAuthenFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	
	@Autowired
	private LoginMapper loginMapper;
	
	@Autowired
	private LogMapper logMapper;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		try {
		    String errorMessage;
		    int failCnt = 0;
		    
			// 로그인ID
			String memberId = request.getParameter("userId");
			 
			// 맴버 정보 조회
			LoginVO loginInfo = loginMapper.selectLoginMemberInfo(memberId);
			 
		    // 계정 잠김 체크 (계정 잠김부터 체크 해야 잠김 계정 비밀번호 틀렸을 경우 실패횟수 증가 안시킴
		    if(exception instanceof LockedException) {
		    	errorMessage = exception.getMessage();
		    	
			// 비밀번호 틀렸을 경우
	    	}else if (exception instanceof BadCredentialsException) {
	    		 // 계정 체크 
	    		if(loginInfo == null) {
	    			errorMessage = memberId + "는(은) 존재하지 않는 ID 입니다.";
	    		}else {
	    			//계정 잠김 여부부터 확인 하고 잠겨 있으면 비밀번호 실패 횟수 증가 시키지 않고 메시지 반환
		    		if(loginInfo.getLockYn().equals("Y")) {
		    			errorMessage =  "로그인 시도 "+ loginInfo.getLoginFailCnt() + "회 실패로 계정이 잠겼습니다. 관리자에게 문의하시기 바랍니다.";
		    		}else {
		    			// 위에서 가져온 데이터 +1 해야 맞음 
		    			failCnt = loginInfo.getLoginFailCnt()+1;
		    			int LockFailCnt = 5;
		    			
		    			// 로그인 실패 횟수와 로그인 허용 실패횟수가 같아진다면 메시지 반환
		    			if(LockFailCnt <= failCnt) {
		    				// 계정 잠금
		    				loginMapper.updateFailLock(loginInfo.getMemberNo());
		    				errorMessage =  "로그인 시도 "+ LockFailCnt + "회 실패로 계정이 잠겼습니다. 관리자에게 문의하시기 바랍니다.";
		    			}else {
		    				//로그인 실패 횟수 증가
		    				loginMapper.updateFailCntAdd(loginInfo.getMemberNo());
		    				errorMessage = "비밀번호를 확인하여주세요. 비밀번호 " + LockFailCnt + "회 실패시 계정이 잠깁니다. 비밀번호를 " + failCnt + "회 틀리셨습니다."; 
		    			}
		    		}
	    		}
	    	}else if(exception instanceof UsernameNotFoundException) {
	    		errorMessage = memberId + " 는(은) 존재하지 않는 ID입니다.";
			// 인증 거부
	    	}else if(exception instanceof InternalAuthenticationServiceException) {
	    		errorMessage = "인증 요청이 거부되었습니다. 관리자에게 문의하세요.";
	    	// 접근 거부
	    	}else if(exception instanceof AuthenticationServiceException) {
	    		errorMessage = "접근 요청이 거부되었습니다. 관리자에게 문의하세요.";
	    	}else {
	    		errorMessage = "알 수 없는 오류로 로그인 요청을 처리할 수 없습니다. 관리자에게 문의하세요.";
	    	}
		    
		    /** 시스템 록그인 로그 */
 			CamelMap logParam = new CamelMap();
 			logParam.put("login_gbn", "F");
 			logParam.put("login_member_id", memberId);
 			logParam.put("login_ip",request.getRemoteAddr());
 			logParam.put("err_msg", errorMessage);
 			logParam.put("fail_cnt", failCnt);
 			logParam.put("reg_id", loginInfo.getMemberNo());
 			logMapper.insertLoginLog(logParam);
 			
		    errorMessage = URLEncoder.encode(errorMessage, "UTF-8"); /* 한글 인코딩 깨진 문제 방지 */
		    // 파라미터로 error와 exception을 보내서 controller에서 처리하기 위함.
		    setDefaultFailureUrl("/login.do?error=true&exception=" + errorMessage);
		
		    // 부모클래스의 onAuthenticationFailure로 처리를 위임하자.
		    super.onAuthenticationFailure(request, response, exception);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
