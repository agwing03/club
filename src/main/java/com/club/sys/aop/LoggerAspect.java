package com.club.sys.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.club.business.cmmn.log.LogService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LoggerAspect{
	
	@Autowired
	private LogService logService;
	
	// 모든 메소드 전후로 실행됨.
    @Around("execution(* com.club..*Controller.*(..)) || execution(* com.club..*Service.*(..)) || execution(* com.club..*Mapper.*(..))")
    public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {

        String name = joinPoint.getSignature().getDeclaringTypeName();
        String type = "";

        if (name.contains("Controller")) {
            type = "Controller ===> ";

        } else if (name.contains("Service")) {
            type = "ServiceImpl ===> "	;

        } else if (name.contains("Mapper")) {
            type = "Mapper ===> ";
        }

        log.debug(type + name + "." + joinPoint.getSignature().getName() + "()");
        return joinPoint.proceed();
    }
    // 컨트롤러 메소드가 실행된 후 예외 , 성공 무관
    @After(value = "execution(* com.club..*Controller.*(..))")
    public void AfterLog(JoinPoint joinPoint) throws RuntimeException {
    	/** 시스템 로그 
    	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    	LogVO logVO = new LogVO();
    	logVO.setIp(request.getRemoteAddr());
    	logVO.setUrl(request.getRequestURI());
		// 아이디 값 얻어오기
		LoginVO loginVO = (LoginVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		logVO.setUserNo(loginVO.getMemberNo());
		
		try {
			logService.insertLoginLog(logVO);
		} catch (Exception e) {
			log.debug(e.toString());
		}
		*/
    }
}