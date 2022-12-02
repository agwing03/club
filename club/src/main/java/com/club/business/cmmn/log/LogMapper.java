package com.club.business.cmmn.log;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.club.sys.cmmn.CamelMap;
import com.club.sys.cmmn.SearchVO;

@Mapper
public interface LogMapper {

	/**
	 * 로그인 로그 저장
	 * @param CamelMap
	 */
	void insertLoginLog(CamelMap params);
	
	
	
	
	/**
	 * 로그 저장
	 * @param commandMap
	 */
	void insertLog(CamelMap camelMap);
	
	/**
	 * 로그 조회
	 * @param String
	 * @throws Exception
	 * @return Map
	 */
	CamelMap selectMenuCd(String menuUrl) throws Exception;
	
	/**
	 * 접속 로그 리스트 조회
	 * @param LogVO
	 * @return LogVO
	 * @throws Exception
	 */
	List<CamelMap> selectLoginLogList(SearchVO params) throws Exception;
	
	/**
	 * 접속 로그 리스트 카운트
	 * @param SearchVO
	 * @return SearchDto
	 * @throws Exception
	 */
	int selectLoginLogCnt(SearchVO params) throws Exception;
	
	/**
	 * 에러 로그 리스트 조회
	 * @param LogVO
	 * @return LogVO
	 * @throws Exception
	 */
	List<CamelMap> selectErrorLogList(SearchVO params) throws Exception;
	
	/**
	 * 에러 로그 리스트 카운트
	 * @param SearchVO
	 * @return SearchDto
	 * @throws Exception
	 */
	int selectErrorLogCnt(SearchVO params) throws Exception;
	
	/**
	 * 로그 리스트 조회
	 * @param LogVO
	 * @return LogVO
	 * @throws Exception
	 */
	List<CamelMap> selectLogList(SearchVO params) throws Exception;
	
	/**
	 * 로그 리스트 카운트
	 * @param SearchVO
	 * @return SearchDto
	 * @throws Exception
	 */
	int logCount(SearchVO params) throws Exception;
	
	/**
	 * 로그 상세 조회
	 * @param param
	 * @return
	 * @throws Exception
	 */
	CamelMap selectLogDetail(Map<String,Object> param) throws Exception;
	
	/**
	 * 에러 로그 저장
	 * @param commandMap
	 * @return CamelMap
	 * @throws Exception
	 */
	void errorLogInsert(Map<String,Object> commandMap);
}
