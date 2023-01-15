package com.club.business.cmmn.code;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.club.sys.cmmn.CamelMap;

/**
 * 공통코드 Mapper 
 * table : cmmn_code, cmmn_code_dtl
 * 공통코드 단일 테이블 관련된 모든 connection
 */
@Mapper
public interface CodeMapper {

	/**
	 * 공통코드 목록 조회
	 * @param CodeVO
	 * @return List<CamelMap>
	 */
	List<CamelMap> selectCodeList(CodeVO vo);
	
	/**
	 * 공통코드 저장
	 * @param CodeVO
	 */
	void insertCode(CodeVO vo);
	
	/**
	 * 공통코드 수정
	 * @param CodeVO
	 */
	void updateCode(CodeVO vo);
	
	/**
	 * 공통코드 삭제
	 * @param CodeVO
	 */
	void deleteCode(CodeVO vo);
	
	/**
	 * 상세코드 목록 조회
	 * @param Integer
	 * @return List<CamelMap>
	 */
	List<CamelMap> selectCodeDtlList(String codeId);
	
	/**
	 * 상세코드 저장
	 * @param CodeVO
	 */
	void insertCodeDtl(CodeVO vo);
	
	/**
	 * 상세코드 수정
	 * @param CodeVO
	 */
	void updateCodeDtl(CodeVO vo);
	
	/**
	 * 상세코드 삭제
	 * @param CodeVO
	 */
	void deleteCodeDtl(CodeVO vo);
}
