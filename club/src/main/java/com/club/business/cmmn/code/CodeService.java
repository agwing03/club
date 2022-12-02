package com.club.business.cmmn.code;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.club.sys.cmmn.SearchVO;

import lombok.RequiredArgsConstructor;

/**
 * 공통코드 Service 
 * table : cmmn_code, cmmn_code_dtl
 * 공통코드 단일 테이블 관련된 모든 connection
 */
@Service
@RequiredArgsConstructor
public class CodeService {
	
	private final CodeMapper authorMapper;
	
	/**
	 * 공통코드 목록 조회
	 * @param SearchVO
	 * @return List<CodeVO>
	 * @throws Exception
	 */
	public List<CodeVO> selectCodeList(SearchVO params) throws Exception{
        List<CodeVO> list = authorMapper.selectCodeList(params);
        return list;
	}
	
	/**
	 * 공통코드 저장
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void insertCode(Map<String, Object> map) throws Exception{
		authorMapper.insertCode(map);
	}
	
	/**
	 * 공통코드 수정
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void updateCode(Map<String, Object> map) throws Exception{
		authorMapper.updateCode(map);
	}
	
	/**
	 * 공통코드 삭제
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void deleteCode(Map<String, Object> map) throws Exception{
		authorMapper.deleteCode(map);
	}
	
	/**
	 * 상세코드 목록 조회
	 * @param SearchVO
	 * @return List<CodeVO>
	 * @throws Exception
	 */
	public List<CodeVO> selectCodeDtlList(SearchVO params) throws Exception{
        List<CodeVO> list = authorMapper.selectCodeDtlList(params);
        return list;
	}
	
	/**
	 * 상세코드 저장
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void insertCodeDtl(Map<String, Object> map) throws Exception{
		authorMapper.insertCodeDtl(map);
	}
	
	/**
	 * 상세코드 수정
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void updateCodeDtl(Map<String, Object> map) throws Exception{
		authorMapper.updateCodeDtl(map);
	}
	
	/**
	 * 상세코드 삭제
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void deleteCodeDtl(Map<String, Object> map) throws Exception{
		authorMapper.deleteCodeDtl(map);
	}
}
