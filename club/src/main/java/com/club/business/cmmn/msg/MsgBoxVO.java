package com.club.business.cmmn.msg;

import com.club.sys.cmmn.CommonVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MsgBoxVO extends CommonVO{
    /**
	 * 권한 VO 
	 * table : author
	 */
	private int memberNo;
	private String authorId;
	private String authorNm;
	private String authorDc;
	private String useYn;
}
