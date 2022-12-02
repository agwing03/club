package com.club.business.cmmn.login;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 로그인 Service 
 * table : member
 */

@Service
public class LoginService implements UserDetailsService{
	@Autowired
	private LoginMapper loginMapper;
	
	@Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
		//맴버 정보조회
		LoginVO loginInfo = loginMapper.selectLoginMemberInfo(memberId);
        if (loginInfo == null) {
        	// 아이디 값이 없을 경우 실패 핸들러로 리턴 시키기 위함.
        	 throw new UsernameNotFoundException(memberId + "는(은) 존재하지 않는 ID입니다.");
        } else {
        	//권한 정보조회
            List<String> authorities = loginMapper.selectAuthorities(loginInfo.getMemberNo());
            ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (String auth: authorities) {
                grantedAuthorities.add(new SimpleGrantedAuthority(auth));
            }
            loginInfo.setAuthorities(grantedAuthorities);
        }
        return loginInfo;
    }
}
