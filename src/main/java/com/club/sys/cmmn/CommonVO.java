package com.club.sys.cmmn;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CommonVO {
    /**
	 * 공통 VO  
	 * 업무VO 상속
	 */
    private int 	page;       // 현재 페이지 번호
    private int 	recordSize;	// 페이지당 출력할 데이터 개수
    private int 	pageSize;  	// 화면 하단에 출력할 페이지 사이즈
    private int 	totalCnt;	// 전체건수
    private int 	userNo;		// 사용자 번호
    
    //검색조건
    private int 	srchKey;
    private String 	srchKeyword;
    private String 	srchType;
    
    //초기설정
    public CommonVO() {
        this.page = 1;
        this.recordSize = 10;
        this.pageSize = 10;
    }

    public int getOffset() {
        return (page - 1) * recordSize;
    }
}
