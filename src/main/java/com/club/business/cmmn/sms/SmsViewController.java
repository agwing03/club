package com.club.business.cmmn.sms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.club.sys.cmmn.LayoutModule;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SmsViewController extends LayoutModule{
	
	// coolSMS 테스트 화면
	@GetMapping("/sms.do")
	public String mySms() {
		return "sms/sms";
	}
	
}
