//package com.ithotgi.springbootdeveloper.config;
//
//import com.ithotgi.springbootdeveloper.service.UserDetailService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.ProviderManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class WebSecurityConfig {
//
//    private final UserDetailService userDetailService;
//
//    // 스프링 시큐리티 기능을 적용하지 않을 URL
//    @Bean
//    public WebSecurityCustomizer configure(){
//        return (web) -> web.ignoring() // 스프링 시큐리티 설정 무시
//                .requestMatchers(toH2Console()) // h2데이터베이스 확인을 위한 요청 경로들
//                .requestMatchers(new AntPathRequestMatcher("/static/**")); //정적 파일 경로들
//    }
//
//    // 특정 HTTP 요청에 대한 웹 기반 보안 구성 설정 빈
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers( // 이 요청과 일치하는 URL에 대해 적용
//                                new AntPathRequestMatcher("/login"),
//                                new AntPathRequestMatcher("/signup"),
//                                new AntPathRequestMatcher("/user")
//                        ).permitAll() //누구나 접근 가능
//                        .anyRequest().authenticated() //모든 요청에 대해 인증 진행
//                )
//                .formLogin(formLogin -> formLogin //폼 기반 로그인
//                        .loginPage("/login") //로그인 페이지 URL
//                        .defaultSuccessUrl("/articles") //로그인 성공 시 이동할 URL
//                )
//                .logout(logout -> logout //로그아웃 설정
//                        .logoutSuccessUrl("/login") //로그아웃 후 이동할 URL
//                        .invalidateHttpSession(true) //세션 무효화 여부
//                )
//                .csrf(AbstractHttpConfigurer::disable) //CSRF 비활성화
//                .build();
//    }
//
//    //인증 관리자 관련 설정 빈
//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http,
//                                                       BCryptPasswordEncoder bCryptPasswordEncoder,
//                                                       UserDetailService userDetailService) throws Exception{
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailService); //사용자 정보 서비스로 동작하는 빈 등록
//        authProvider.setPasswordEncoder(bCryptPasswordEncoder); //비밀번호 인코딩 빈 등록
//        return new ProviderManager(authProvider);
//    }
//
//    //비밀번호 인코더로 사용할 빈
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//
//}
