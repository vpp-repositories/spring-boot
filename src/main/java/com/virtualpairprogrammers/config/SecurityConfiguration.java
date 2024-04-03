package com.virtualpairprogrammers.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Profile("production")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
    // Authentication
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication()
                .withUser("rac")
                .password("secret")
                .roles("USER","ADMIN");
    }

    // Authorization
    @Override
    public void configure(HttpSecurity http) throws Exception
    {
        http.antMatcher("/**").authorizeRequests()
                .anyRequest().hasRole("USER")

                .and()

                .formLogin().loginPage("/login.jsp")
                            .failureUrl("/login.jsp?error=1")
                            .loginProcessingUrl("/login")
                            .permitAll()
                            .and()
                            .logout()
                            .logoutSuccessUrl("/website/vehicles/list.html");
    }
}

