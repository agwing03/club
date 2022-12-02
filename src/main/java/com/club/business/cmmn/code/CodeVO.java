package com.club.business.cmmn.code;

import com.club.sys.cmmn.CommonVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodeVO extends CommonVO{
    /**
	 * 공통코드 VO 
	 * table : cmmn_code, cmmn_code_dtl
	 */
	private String code_id;
	private String code_nm;
	private String code_dc;
	private String code_order;
	private String code_dtl_nm;
	private String code_dtl_dc;
	private String code_dtl_order;
}
