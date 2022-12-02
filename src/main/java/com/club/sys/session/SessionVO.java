package com.club.sys.session;

import lombok.Data;

@Data
public class SessionVO {

	private int sessionMin;
	private int loginFailCount;
	private int loginFailLockTime;
	
}
