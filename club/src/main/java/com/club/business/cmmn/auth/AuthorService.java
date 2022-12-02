package com.club.business.cmmn.auth;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.club.sys.cmmn.SearchVO;

import lombok.RequiredArgsConstructor;

/**
 * 권한 Service 
 * table : author
 * author 단일 테이블 관련된 모든 connection
 */
@Service
@RequiredArgsConstructor
public class AuthorService {
	
	private final AuthorMapper authorMapper;
	
	/**
	 * 권한 목록 조회
	 * @param SearchVO
	 * @return List<AuthorVO>
	 * @throws Exception
	 */
	public List<AuthorVO> selectAuthorList(SearchVO params) throws Exception{
        List<AuthorVO> list = authorMapper.selectAuthorList(params);
        return list;
	}
	
	/**
	 * 맴버 권한 조회
	 * @param String memberId
	 * @return String authorId
	 * @throws Exception
	 */
	public String selectAuthorMember(String memberId) throws Exception{
		return authorMapper.selectAuthorMember(memberId);
	}
	
	/**
	 * 권한 저장
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void insertAuthor(Map<String, Object> map) throws Exception{
		authorMapper.insertAuthor(map);
	}
	
	/**
	 * 권한 수정
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void updateAuthor(Map<String, Object> map) throws Exception{
		authorMapper.updateAuthor(map);
	}
	
	/**
	 * 권한 삭제
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void deleteAuthor(Map<String, Object> map) throws Exception{
		authorMapper.deleteAuthor(map);
	}
}
