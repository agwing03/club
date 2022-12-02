package com.club.business.cmmn.login;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class LoginVO implements UserDetails{
	/**
	 * 로그인 사용자 정보관리 VO 
	 * table : member 
	 * 로그인 및 스프링 시큐리티 관련된 업무VO
	 */
	private static final long serialVersionUID = 809890801483033862L;

    private int    memberNo;
    private String memberId;
    private String memberPwd;
    private String memberAuthor;
    private String useYn;
    private String nickNm;
    private String lockYn;
    private int loginFailCnt;
    private int lockTime;
    private int unLockTime;
    
    private ArrayList<GrantedAuthority> authorities;
    
	@Override
	public String getPassword() {
		return memberPwd;
	}

	@Override
	public String getUsername() {
		return memberId;
	}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(authorities);
        return authList;
    }

}
