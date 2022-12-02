package com.club.business.cmmn.user;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MemberVO implements UserDetails{
    /**
	 * 맴버 VO 
	 * table : member
	 */
	private static final long serialVersionUID = 809890801483033862L;
	
	private int memberNo;
	private String memberId;
	private String memberPwd;
	private String memberAuthor;
	private String nickNm;
    private String name;
    private String sex;
    private String brthday;
    private String phonNo;
    private String email;
    private String addr;
    private String addrDtl;
    private String profileImgNo;
    private String intro;
    private String accountNo;
    private String actionAreaLv1;
    private String joinClubOpenYn;
    private String leaveYn;     
    private String lockYn;
    private String lockTime;
    private String unLockTime;
    private int loginFailCnt;
    
    //사용자 권한
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
