package com.club.business.cmmn.auth;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.club.sys.cmmn.SearchVO;

/**
 * 권한 Mapper 
 * table : Author
 * author 단일 테이블 관련된 모든 connection
 */
@Mapper
public interface AuthorMapper {

	/**
	 * 권한 목록 조회
	 * @param SearchVO
	 * @return List<AuthorVO>
	 */
	List<AuthorVO> selectAuthorList(SearchVO params);
	
	/**
	 * 맴버 권한 조회
	 * @param String memberId
	 * @return String authorId
	 */
	String selectAuthorMember(String memberId);
	
	/**
	 * 권한 저장
	 * @param Map<String,Object>
	 */
	void insertAuthor(Map<String, Object> map);
	
	/**
	 * 권한 수정
	 * @param Map<String,Object>
	 */
	void updateAuthor(Map<String, Object> map);
	
	/**
	 * 권한 삭제
	 * @param Map<String,Object>
	 */
	void deleteAuthor(Map<String, Object> map);
}
