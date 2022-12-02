package com.club.business.cmmn.log;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.club.sys.cmmn.CamelMap;
import com.club.sys.cmmn.Pagination;
import com.club.sys.cmmn.PagingResponse;
import com.club.sys.cmmn.SearchVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogService {
	
	private final LogMapper logMapper;
	
	
	// 로그인, 시스템, 에러
	
	/**
	 * 로그 저장
	 * @param commandMap
	 * @param req
	 * @throws Exception
	 */
	public void insertLog(CamelMap camelMap) {
			
			
			// 로그 저장
			logMapper.insertLog(camelMap);
	}
	
	/**
	 * 로그인 성공 실패 저장
	 * @param map
	 * @return void
	 */
	public void userInsertLog(CamelMap paraMap) {
		logMapper.insertLog(paraMap);
	}
	
	/**
	 * 접속 로그 리스트 조회
	 * @param LogVO
	 * @return LogVO
	 * @throws Exception
	 */
	public PagingResponse<CamelMap> selectLoginLogList(SearchVO params) throws Exception{
		
		int count = logMapper.selectLoginLogCnt(params);
		Pagination pagination = new Pagination(count, params);
		params.setPagination(pagination);
		
		List<CamelMap> list = logMapper.selectLoginLogList(params);
		
		return new PagingResponse<>(list, pagination);
	}
	
	/**
	 * 에러 로그 리스트 조회
	 * @param LogVO
	 * @return LogVO
	 * @throws Exception
	 */
	public PagingResponse<CamelMap> selectErrorLogList(SearchVO params) throws Exception{
		
		int count = logMapper.selectErrorLogCnt(params);
		Pagination pagination = new Pagination(count, params);
		params.setPagination(pagination);
		
		List<CamelMap> list = logMapper.selectErrorLogList(params);
		
		return new PagingResponse<>(list, pagination);
	}
	
	/**
	 * 로그 리스트 조회
	 * @param LogVO
	 * @return LogVO
	 * @throws Exception
	 */
	public PagingResponse<CamelMap> selectLogList(SearchVO params) throws Exception{
		
		int count = logMapper.logCount(params);
        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);
        
        List<CamelMap> list = logMapper.selectLogList(params);
        
		return new PagingResponse<>(list, pagination);
	}
	
	/**
	 * 로그 상세 조회
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public CamelMap selectLogDetail(Map<String,Object> param) throws Exception{
		return logMapper.selectLogDetail(param);
	}
	
	/**
	 * 에러 로그 저장
	 * @param commandMap
	 * @return CamelMap
	 * @throws Exception
	 */
	public void errorLogInsert(Map<String,Object> commandMap){
		logMapper.errorLogInsert(commandMap);
	}
}
