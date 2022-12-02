package com.club.business.cmmn.user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.club.sys.cmmn.Pagination;
import com.club.sys.cmmn.PagingResponse;
import com.club.sys.cmmn.SearchVO;

import lombok.RequiredArgsConstructor;

/**
 * 맴버 Service 
 * table : member
 * member 단일 테이블 관련된 모든 connection
 */
@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberMapper memberMapper;
	
	/**
	 * 맴버 리스트 조회
	 * @param SearchVO
	 * @return PagingResponse<MemberVO>
	 * @throws Exception
	 */
	public PagingResponse<MemberVO> selectMemberList(SearchVO params) throws Exception{
		int count = memberMapper.selectMemberListCnt(params);
        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);
        List<MemberVO> list =  memberMapper.selectMemberList(params);
        return new PagingResponse<>(list, pagination);
	}
	
	/**
	 * 맴버 정보 조회
	 * @param SearchVO
	 * @return MemberVO
	 * @throws Exception
	 */
	public MemberVO selectMemberInfo(SearchVO params) {
		return memberMapper.selectMemberInfo(params);
	}
	
	/**
	 * 맴버 정보 저장
	 * @param Map<String,Object>
	 * @return String memberNo
	 * @throws Exception
	 */
	@Transactional
	public void insertMember(Map<String, Object> map) throws Exception{
		//암호화 SHA256
		map.put("memberPwd", passwordEncoding(map.get("memberPwd").toString()));
		memberMapper.insertMember(map);
	}
	
	/**
	 * 맴버 정보 변경
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void updateMember(Map<String, Object> map) throws Exception{
		memberMapper.updateMember(map);
	}
	
	/**
	 * 맴버 사용여부 변경
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void updateMemberUseYn(Map<String,Object> map) throws Exception{
		String memberPkArr[] = map.get("memberPkArr").toString().split(",");
		for(int i=0; i < memberPkArr.length; i++) {
			map.put("memberNo", memberPkArr[i]);
			map.put("useYn", "Y");
			memberMapper.updateMember(map);
		}
	}
	
	/**
	 * 맴버 잠금 해제
	 * @param memberNo
	 * @throws Exception
	 */
	@Transactional 
	public void updateMemberUnLock(Map<String, Object> map) throws Exception{
		String memberPkArr[] = map.get("memberPkArr").toString().split(",");
		for(int i=0; i < memberPkArr.length; i++) {
			map.put("memberNo", memberPkArr[i]);
			map.put("lockYn", "N");
			memberMapper.updateMember(map);
		}
	}
	
	/**
	 * 맴버 비밀번호 변경
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void updateMemberPwd(Map<String,Object> map) throws Exception{
		//암호화 SHA256
		map.put("memberPwd", passwordEncoding(map.get("memberPwd").toString()));
		memberMapper.updateMember(map);
	}
	
	/**
	 * 아이디 중복체크
	 * @param commandMap
	 * @return Integer
	 * @throws Exception
	 */
	public int selectMemberId(String memberId) throws Exception{
		return memberMapper.selectMemberId(memberId);
	}
	
	/**
	 * 비밀번호 암호화 SHA256
	 * @param String
	 * @return String
	 * @throws NoSuchAlgorithmException 
	 */
	public String passwordEncoding(String password) throws NoSuchAlgorithmException {
		password = getHtmlStrCnvr(password);
		MessageDigest sh = MessageDigest.getInstance("SHA-256");
		sh.update(password.getBytes());
		byte byteData[] = sh.digest();
		StringBuffer sb = new StringBuffer();
		for(int j=0; j < byteData.length; j++) {
			sb.append(Integer.toString((byteData[j]&0xff)+ 0x100, 16).substring(1));
		}
		String sha = sb.toString();
		return sha;
	}
	
	/**
	 * html의 특수문자를 표현하기 위해
	 *
	 * @param srcString
	 * @return String
	 * @exception Exception
	 * @see
	 */
	public static String getHtmlStrCnvr(String srcString) {
		String tmpString = srcString;
		tmpString = tmpString.replaceAll("&lt;", "<");
		tmpString = tmpString.replaceAll("&gt;", ">");
		tmpString = tmpString.replaceAll("&amp;", "&");
		tmpString = tmpString.replaceAll("&nbsp;", " ");
		tmpString = tmpString.replaceAll("&apos;", "\'");
		tmpString = tmpString.replaceAll("&quot;", "\"");
		return tmpString;

	}
}
