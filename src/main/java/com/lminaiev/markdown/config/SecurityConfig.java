package com.lminaiev.markdown.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Web Security Configuration
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling().authenticationEntryPoint((httpServletRequest, httpServletResponse, e) -> {
            if (e != null) {
                httpServletResponse.sendError(403);
            }
        });
        http.authorizeRequests()
                .antMatchers("/resources/**", "/login").permitAll()
                .antMatchers("/test-rest", "/convert").access("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
                .antMatchers("/stats").access("hasRole('ROLE_ADMIN')")
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .failureUrl("/login")
                .defaultSuccessUrl("/test-rest", false)
                .and()
                .exceptionHandling().accessDeniedHandler((httpServletRequest, httpServletResponse, e) -> httpServletResponse.sendError(403))
                .and().csrf().disable();
    }
}
