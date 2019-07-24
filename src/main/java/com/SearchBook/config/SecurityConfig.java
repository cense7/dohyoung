package com.searchBook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.searchBook.service.Impl.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

    @Autowired
    UserServiceImpl userServiceImpl;





    // @Bean
    // public AuthenticationSuccessHandler successHandler()
    // {
    // return new LoginSuccessHandler("/main");
    // }

    @Bean
    public PasswordEncoder passwordEncoder()
    {

        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }





    // @Override
    // protected void configure(final AuthenticationManagerBuilder auth) throws Exception
    // {
    // auth.userDetailsService(this.userServiceImpl)
    // .passwordEncoder(this.userServiceImpl.passwordEncoder());
    // }

    @Override
    protected void configure(final HttpSecurity http) throws Exception
    {
        http.authorizeRequests()

            .antMatchers("/login", "/console/*", "/register")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/auth")
            .defaultSuccessUrl("/")
            // .failureHandler(this.authSuccessHandler)

            .and()
            .logout()
            .permitAll()
            .and()
            .csrf()
            .disable()
            .headers()
            .frameOptions()
            .disable();

        http.csrf()
            .disable();
        http.headers()
            .frameOptions()
            .disable();

        http.sessionManagement()
            .maximumSessions(1)
            .maxSessionsPreventsLogin(true);

    }

}
