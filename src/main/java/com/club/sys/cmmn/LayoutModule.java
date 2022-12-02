package com.club.sys.cmmn;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.club.business.cmmn.login.LoginVO;


public class LayoutModule {
	
	/**공통 타임리프 레이아웃 정보**/
    @ModelAttribute("layout")
    public List<Object> layout(HttpServletRequest request, @AuthenticationPrincipal LoginVO loginInfo) {
    	List<Object> listMap = new ArrayList<Object>();
    	if(loginInfo != null) {
    		//사용자명
	    	listMap.add(loginInfo.getNickNm()); //layout0
	    	//현재 URL로 현재선택한 메뉴ID, 상위메뉴ID 조회
	    	//CommonVO commonDto = commonService.selectMenuInfo(request.getRequestURI());
	    	//if(commonDto == null) commonDto = new CommonVO(); 
	    	//listMap.add(commonDto); //layout1
	    	//상단메뉴
	    	//commonDto.setUserPk(userInfo.getUserPk());
	    	//List<CommonVO> topMenuList  = commonService.selectTopMenuList(commonDto);
	    	//listMap.add(topMenuList); //layout2
	    	//좌측메뉴 (상위)
	    	//List<CommonVO> leftMenuList = commonService.selectLeftUpperMenuList(commonDto);
	    	//listMap.add(leftMenuList); //layout3
	    	//좌측메뉴 (하위)
	    	//leftMenuList = commonService.selectLeftMenuList(commonDto);
	    	//listMap.add(leftMenuList); //layout4
    	}
    	return listMap;
    }
    
    
    // 사용자에게 메시지를 전달하고, 페이지를 리다이렉트 한다.
    protected String showMessageAndRedirect(final MessageVO params, Model model) {
        model.addAttribute("params", params);
        return "common/messageRedirect";
    }
}
