package com.group_22235.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    //@Autowired
    //UserDetailsService userDetailsService;
    // SecurityUserDetailsService securityUserDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
         http
            .authorizeRequests()
                .antMatchers("/Admin").hasRole("ADMIN")
                // .antMatchers("/BookTicket").hasAnyRole("ADMIN", "USER")
                .antMatchers("/").permitAll()
                // .userDetailsService()             
                .and()
            .formLogin()
                .loginPage("/Index")
                .permitAll()
                .and()
            .logout(logout -> logout
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Must be used as due to CSRF protection being enables by default, cannot logout with post request
                .logoutSuccessUrl("/Index")
			);
            // .userDetailsService(userDetailsService);
        return http.build();
    }
    
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
