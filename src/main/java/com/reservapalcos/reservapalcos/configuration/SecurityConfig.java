package com.reservapalcos.reservapalcos.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Value("${app.security.remember-me-key}")
    private String rememberMeKey;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/css/**", "/js/**").permitAll()
                .requestMatchers("/login", "/registrarse").anonymous()
                .anyRequest().authenticated()
                )
                .rememberMe(remember -> remember
                .key(rememberMeKey)
                .tokenValiditySeconds(60 * 60 * 24 * 30)
                )
                .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/", true)
                .usernameParameter("email")
                .passwordParameter("contrasena")
                .permitAll()
                );
        return http.build();
    }
}
