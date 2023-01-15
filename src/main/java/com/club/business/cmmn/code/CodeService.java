package com.club.business.cmmn.code;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

/**
 * 공통코드 Service 
 * table : cmmn_code, cmmn_code_dtl
 * 공통코드 단일 테이블 관련된 모든 connection
 */
@Service
@RequiredArgsConstructor
public class CodeService {
	
	private final CodeMapper clubMapper;
	
	/**
	 * 공통코드 목록 조회
	 * @param CodeVO
	 * @return CodeVO
	 * @throws Exception
	 */
	public CodeVO selectCodeList(CodeVO vo) throws Exception{
    	vo.setCodeList(clubMapper.selectCodeList(vo));
        return vo;
	}
	
	/**
	 * 공통코드 저장
	 * @param CodeVO
	 * @throws Exception
	 */
	@Transactional
	public void insertCode(CodeVO vo) throws Exception{
		clubMapper.insertCode(vo);
	}
	
	/**
	 * 공통코드 수정
	 * @param CodeVO
	 * @throws Exception
	 */
	@Transactional
	public void updateCode(CodeVO vo) throws Exception{
		clubMapper.updateCode(vo);
	}
	
	/**
	 * 공통코드 삭제
	 * @param CodeVO
	 * @throws Exception
	 */
	@Transactional
	public void deleteCode(CodeVO vo) throws Exception{
		clubMapper.deleteCode(vo);
	}
	
	/**
	 * 상세코드 목록 조회
	 * @param CodeVO
	 * @return CodeVO
	 * @throws Exception
	 */
	public CodeVO selectCodeDtlList(CodeVO vo) throws Exception{
		vo.setCodeDtlList(clubMapper.selectCodeDtlList(vo.getCode_id()));
        return vo;
	}
	
	/**
	 * 상세코드 저장
	 * @param CodeVO
	 * @throws Exception
	 */
	@Transactional
	public void insertCodeDtl(CodeVO vo) throws Exception{
		clubMapper.insertCodeDtl(vo);
	}
	
	/**
	 * 상세코드 수정
	 * @param CodeVO
	 * @throws Exception
	 */
	@Transactional
	public void updateCodeDtl(CodeVO vo) throws Exception{
		clubMapper.updateCodeDtl(vo);
	}
	
	/**
	 * 상세코드 삭제
	 * @param CodeVO
	 * @throws Exception
	 */
	@Transactional
	public void deleteCodeDtl(CodeVO vo) throws Exception{
		clubMapper.deleteCodeDtl(vo);
	}
}
