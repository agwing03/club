package com.club.business.club;

import java.util.List;

import com.club.sys.cmmn.CamelMap;
import com.club.sys.cmmn.CommonVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClubVO extends CommonVO{
    /**
	 * 클럽 VO 
	 * table : CLUB 등 하위 폴더
	 */
	private int 	clubNo;
	private String 	clubNm;
	private int 	clubTotalCnt;
	private int 	clubIntro;
	private int 	clubImgNo;
	private String 	clubImgPath;
	private String 	clubJoinTp;
	private String 	useYn;
	private String 	openYn;
	private String 	actionAreaLv1;
	private String 	actionAreaLv2;
	private String 	clubCategory;
	private String 	delYn;
	
	private List<CamelMap> clubList;
	private List<CamelMap> meetingList;
}
