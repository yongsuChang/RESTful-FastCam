package kr.co.fastcampus.eatgo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityJavaConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().disable()       // CORS 방지
                .csrf().disable()       // CSRF 방지
                .formLogin().disable()  // 로그인 form 없애기
                .headers().frameOptions().disable();    // iFrame 사용 가능

    }
}
