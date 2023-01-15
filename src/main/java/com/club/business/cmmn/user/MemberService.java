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
	 * 맴버 목록 조회
	 * @param MemberVO
	 * @return MemberVO
	 * @throws Exception
	 */
	public MemberVO selectMemberList(MemberVO vo) throws Exception{
		int cnt = memberMapper.selectMemberListCnt(vo);
		if(cnt > 0) {
			vo.setMemberList(memberMapper.selectMemberList(vo));
		}
        return vo;
	}
	
	/**
	 * 맴버 정보 조회
	 * @param MemberVO
	 * @return MemberVO
	 * @throws Exception
	 */
	public MemberVO selectMemberInfo(MemberVO vo) throws Exception{
		return memberMapper.selectMemberInfo(vo);
	}
	
	/**
	 * 맴버 정보 저장
	 * @param MemberVO
	 * @throws Exception
	 */
	@Transactional
	public void insertMember(MemberVO vo) throws Exception{
		//암호화 SHA256
		vo.setMemberPwd(passwordEncoding(vo.getMemberPwd().toString()));
		memberMapper.insertMember(vo);
	}
	
	/**
	 * 맴버 정보 변경
	 * @param MemberVO
	 * @throws Exception
	 */
	@Transactional
	public void updateMember(MemberVO vo) throws Exception{
		memberMapper.updateMember(vo);
	}
	
	/**
	 * 맴버 사용여부 변경
	 * @param MemberVO
	 * @throws Exception
	 */
	@Transactional
	public void updateMemberUseYn(MemberVO vo) throws Exception{
		String memberPkArr[] = vo.getMemberPkArr().split(",");
		for(int i=0; i < memberPkArr.length; i++) {
			vo.setMemberNo(Integer.parseInt(memberPkArr[i]));
			vo.setLeaveYn("Y");
			memberMapper.updateMember(vo);
		}
	}
	
	/**
	 * 맴버 잠금 해제
	 * @param memberNo
	 * @throws Exception
	 */
	@Transactional 
	public void updateMemberUnLock(MemberVO vo) throws Exception{
		String memberPkArr[] = vo.getMemberPkArr().split(",");
		for(int i=0; i < memberPkArr.length; i++) {
			vo.setMemberNo(Integer.parseInt(memberPkArr[i]));
			vo.setLockYn("N");
			memberMapper.updateMember(vo);
		}
	}
	
	/**
	 * 맴버 비밀번호 변경
	 * @param Map<String,Object>
	 * @throws Exception
	 */
	@Transactional
	public void updateMemberPwd(MemberVO vo) throws Exception{
		//암호화 SHA256
		vo.setMemberPwd(passwordEncoding(vo.getMemberPwd().toString()));
		memberMapper.updateMember(vo);
	}
	
	/**
	 * 맴버 아이디 중복체크
	 * @param String memberId
	 * @return Integer
	 * @throws Exception
	 */
	public int selectMemberIdCheck(String memberId) throws Exception{
		return memberMapper.selectMemberIdCheck(memberId);
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
