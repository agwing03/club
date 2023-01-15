package com.club.sys.cmmn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchVO extends CommonVO {
    /**
	 * 조회 VO  
	 * 검색조건 파라미터
	 */
	private int		srchKey;     	// 검색 Key
    private String 	srchKeyword;    // 검색 키워드
    private String 	srchType;    	// 검색 유형
    private String 	srchBgnDtm;		// 검색시작 날짜
    private String 	srchEndDtm;		// 검색끝 날짜
    private Pagination pagination;  // 페이지네이션 정보

}
