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
		private final AuthenticationSuccessHandler customAuthenticationSuccessHandler;
		// 실패 핸들러
		private final AuthenticationFailureHandler customAuthenticationFailureHandler;
		
	 	@Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	 			http.csrf().disable()
	 				// 보호된 리소스 URI에 접근할 수 있는 권한을 설정
					.authorizeRequests()
					// 전체 접근 허용 , login** -> 실패 핸들러 탓을 경우에 파라미터 넘기기 위함
					.antMatchers("/login/**","/login**","/test/test**","/payment/**").permitAll()
					// 특정 사용자만 접근
					//.antMatchers("/board/list.do").hasRole("TEST")
					// 인증된 유저만 접근을 허용
					.anyRequest().authenticated() 
	                .and()
	                	.formLogin()
	                	.loginPage("/login.do")
	                	.loginProcessingUrl("/loginProc.do")
	                    .usernameParameter("memberId")
	                    .passwordParameter("memberPw")
	                    .defaultSuccessUrl("/main.do", true)
	                    .successHandler(customAuthenticationSuccessHandler) //  성공시 custom success 핸들러를 호출한다.
	                    .failureHandler(customAuthenticationFailureHandler) //  실패시 custom failure 핸들러를 호출한다.
	                    .permitAll()
	                .and()
		    			.logout()
		    			.logoutRequestMatcher(new AntPathRequestMatcher("/logout.do")) // 로그아웃 URL
		    		    .logoutSuccessUrl("/login.do") // 성공시 리턴 URL
		    		    .invalidateHttpSession(true) // 인증정보를 지우하고 세션을 무효화
		    		    .deleteCookies("JSESSIONID") // JSESSIONID 쿠키 삭제
		    			.permitAll()
		    		.and()
		            	.sessionManagement()
		                .maximumSessions(1) // 세션 최대 허용 수 1, -1인 경우 무제한 세션 허용
		                .maxSessionsPreventsLogin(false) // true면 중복 로그인을 막고, false면 이전 로그인의 세션을 해제
		                .expiredUrl("/login.do?error=true&exception=Have been attempted to login from a new place. or session expired");  // 세션이 만료된 경우 이동 할 페이지를 지정
		          
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
