package com.club.business.cmmn.code;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.club.sys.cmmn.SearchVO;

/**
 * 공통코드 Mapper 
 * table : cmmn_code, cmmn_code_dtl
 * 공통코드 단일 테이블 관련된 모든 connection
 */
@Mapper
public interface CodeMapper {

	/**
	 * 공통코드 목록 조회
	 * @param SearchVO
	 * @return List<CodeVO>
	 */
	List<CodeVO> selectCodeList(SearchVO params);
	
	/**
	 * 공통코드 저장
	 * @param Map<String,Object>
	 */
	void insertCode(Map<String, Object> map);
	
	/**
	 * 공통코드 수정
	 * @param Map<String,Object>
	 */
	void updateCode(Map<String, Object> map);
	
	/**
	 * 공통코드 삭제
	 * @param Map<String,Object>
	 */
	void deleteCode(Map<String, Object> map);
	
	/**
	 * 상세코드 목록 조회
	 * @param SearchVO
	 * @return List<CodeVO>
	 */
	List<CodeVO> selectCodeDtlList(SearchVO params);
	
	/**
	 * 상세코드 저장
	 * @param Map<String,Object>
	 */
	void insertCodeDtl(Map<String, Object> map);
	
	/**
	 * 상세코드 수정
	 * @param Map<String,Object>
	 */
	void updateCodeDtl(Map<String, Object> map);
	
	/**
	 * 상세코드 삭제
	 * @param Map<String,Object>
	 */
	void deleteCodeDtl(Map<String, Object> map);
}
