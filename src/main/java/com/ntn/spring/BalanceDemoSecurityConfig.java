package com.ntn.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.ntn.spring.modal.domain.entity.User.Role;

@Configuration
@EnableWebSecurity
public class BalanceDemoSecurityConfig {
	@Bean
	SecurityFilterChain httpSecurity(HttpSecurity http) throws Exception {
        http
        .formLogin(form -> form
            .loginPage("/signin")
            .defaultSuccessUrl("/", true)
            .permitAll()
        )

        .logout(logout -> logout
            .logoutUrl("/signout")
            .logoutSuccessUrl("/")
            .permitAll()
        )

        .authorizeHttpRequests(auth -> auth
        	.requestMatchers("/signin", "/signup", "/").permitAll()
            .requestMatchers("/user/**")
                .hasAnyAuthority(Role.MEMBER.name(), Role.ADMIN.name())
            .requestMatchers("/admin/**")
                .hasAuthority(Role.ADMIN.name())
            .anyRequest().authenticated()
        )

        .csrf(csrf -> csrf.disable());
		return http.build();
	}
}
