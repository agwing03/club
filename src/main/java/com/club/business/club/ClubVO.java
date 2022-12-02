package com.club.business.club;

import com.club.sys.cmmn.CommonVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClubVO extends CommonVO{
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
