package com.gustavo.parkingcontrolapi.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig {
    @Autowired
    SecurityFilter securityFilter;

    @Bean
    protected SecurityFilterChain httpConfig(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(parkAuthority ->
                        parkAuthority.requestMatchers(HttpMethod.POST, "/parking-spot").hasAnyRole("ADMIN", "RECRUITER")
                                .requestMatchers(HttpMethod.DELETE, "/parking-spot/**").hasAnyRole("ADMIN", "RECRUITER")
                                .requestMatchers(HttpMethod.GET, "/parking-spot").hasAnyRole("ADMIN", "RECRUITER")
                                .requestMatchers(HttpMethod.GET, "/parking-spot/**").permitAll()
                )
                .authorizeHttpRequests(userAuthority ->
                        userAuthority.requestMatchers(HttpMethod.POST, "/user/login").permitAll()
                                .requestMatchers(HttpMethod.POST, "/user/register").permitAll()
                                .requestMatchers(HttpMethod.DELETE, "/user/**").hasAnyRole("ADMIN", "RECRUITER")
                                .requestMatchers(HttpMethod.GET, "/user/id/**").authenticated()
                                .requestMatchers(HttpMethod.GET, "/user/username/**").authenticated()
                                .requestMatchers(HttpMethod.GET, "/user").hasAnyRole("ADMIN", "RECRUITER")
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    protected PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
