package com.ntn.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class BalanceDemoSecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain httpSecurity(HttpSecurity http) throws Exception {
        http
            .formLogin(form -> form
                .loginPage("/signin")
                .loginProcessingUrl("/signin")    // must match <form action="/signin">
                .usernameParameter("loginId")     // must match input name
                .passwordParameter("password")    // must match input name
                .defaultSuccessUrl("/index", true)
                .failureUrl("/signin?error")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/signout")
                .logoutSuccessUrl("/")
                .permitAll()
            )
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/signin", "/signup", "/css/**", "/js/**", "/images/**").permitAll()
                .requestMatchers("/user/**").hasAnyRole("MEMBER", "ADMIN")   // ✅ FIXED
                .requestMatchers("/admin/**").hasRole("ADMIN")               // ✅ FIXED
                .anyRequest().authenticated()
            )
            .csrf(csrf -> csrf.disable());

        return http.build();
    }
}
