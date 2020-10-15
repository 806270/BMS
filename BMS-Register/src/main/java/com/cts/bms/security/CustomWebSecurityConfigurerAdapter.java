package com.cts.bms.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Value("bms")
    private String authorizationKey;

    @Autowired
    private BMSBasicAuthenticationEntryPoint authenticationEntryPoint;

    private static final Logger log = LoggerFactory.getLogger(CustomWebSecurityConfigurerAdapter.class);


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        log.info("Environment--{} :" ,System.getProperty("spring.profiles.active"));
        auth.inMemoryAuthentication()
                .withUser(authorizationKey).password(passwordEncoder().encode(authorizationKey))
                .authorities("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/actuator/health").permitAll()
                .antMatchers("/**").authenticated()
                .and()
                .httpBasic()
                .authenticationEntryPoint(authenticationEntryPoint)
                .realmName("fdservices");
   }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
