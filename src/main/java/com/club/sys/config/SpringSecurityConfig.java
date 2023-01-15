package com.club.sys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.club.sys.util.SHA256PasswordEncoder;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final이나 @NonNull 로 선언된 필드 자동생성
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig{
	
		// 성공 핸들러
		private final AuthenticationSuccessHandler customAuthorSuccessHandler;
		// 실패 핸들러
		private final AuthenticationFailureHandler customAuthorFailureHandler;
		
	 	@Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	 			http.csrf().disable()
					.authorizeRequests()
					// 해당 경로들은 접근을 허용 , login** -> 실패 핸들러 탓을 경우에 파라미터 넘기기 위함
					.antMatchers("/login/**","/login**","/payment/**").permitAll() 
					//인증된 유저만 접근을 허용
					.anyRequest().authenticated() 
	                .and()
	                	//로그인
	                	.formLogin()
	                	.loginPage("/login.do")
	                	.loginProcessingUrl("/login/loginProc.do")
	                	//로그인 ID/PW
	                    .usernameParameter("memberId")
	                    .passwordParameter("memberPw")
	                    //로그인 성공시 이동 URL
	                    .defaultSuccessUrl("/main.do", true)
	                    //로그인 성공시 custom success 핸들러를 호출
	                    .successHandler(customAuthorSuccessHandler)
	                    //로그인 실패시 custom failure 핸들러를 호출
	                    .failureHandler(customAuthorFailureHandler)
	                    .permitAll()
	                .and()
	                	//로그아웃
		    			.logout()
		    			//로그아웃 URL
		    			.logoutRequestMatcher(new AntPathRequestMatcher("/logout.do"))
		    			//성공시 리턴 URL
		    		    .logoutSuccessUrl("/login.do")
		    		    //인증정보를 지우하고 세션을 무효화
		    		    .invalidateHttpSession(true)
		    		    //JSESSIONID 쿠키 삭제
		    		    .deleteCookies("JSESSIONID") 
		    			.permitAll()
		    		.and()
		            	.sessionManagement()
		            	//세션 최대 허용 수 1, -1인 경우 무제한 세션 허용
		                .maximumSessions(1) 
		                //true면 중복 로그인을 막고, false면 이전 로그인의 세션을 해제
		                .maxSessionsPreventsLogin(false) 
		                //세션이 만료된 경우 이동 할 페이지를 지정
		                .expiredUrl("/login.do?error=true&exception=Have been attempted to login from a new place. or session expired");  
		          
	        http.headers().frameOptions().sameOrigin();
	        return http.build();
	    }
	  
	    @Bean
	    public WebSecurityCustomizer webSecurityCustomizer() {
	        return (web) -> web.ignoring().antMatchers("/css/**", "/scripts/**", "/img/**", "/plugin/**", "/fonts/**");
	    }
	    
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new SHA256PasswordEncoder();
	    }    
	    
	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
	            throws Exception {
	        return authenticationConfiguration.getAuthenticationManager();
	    }
}
