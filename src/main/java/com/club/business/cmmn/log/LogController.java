package com.club.business.cmmn.log;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LogController {
	
	private final LogService logService;
	
}
