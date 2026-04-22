package com.nour.series.security;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.sessionManagement( session -> 
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .csrf( csrf -> csrf.disable())
        .cors(cors -> cors.configurationSource(new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                config.setAllowedMethods(Collections.singletonList("*"));
                config.setAllowCredentials(true);
                config.setAllowedHeaders(Collections.singletonList("*"));
                config.setExposedHeaders(Collections.singletonList("Authorization"));
                config.setMaxAge(3600L);
                return config;
            }
        }))
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/api/all").hasAnyAuthority("ADMIN", "USER", "AGENT")
            .requestMatchers("/api/getbyid/**").hasAnyAuthority("ADMIN", "USER", "AGENT")
            .requestMatchers("/api/addserie/**").hasAnyAuthority("ADMIN", "AGENT")
            .requestMatchers("/api/updateserie/**").hasAnyAuthority("ADMIN", "AGENT")
            .requestMatchers("/api/delserie/**").hasAuthority("ADMIN")
            .requestMatchers("/api/seriespays/**").hasAnyAuthority("ADMIN", "USER", "AGENT")
            .requestMatchers("/api/seriesByTitre/**").hasAnyAuthority("ADMIN", "USER", "AGENT")
            .requestMatchers("/api/pays").hasAnyAuthority("ADMIN", "USER", "AGENT")
            .requestMatchers("/api/pays/**").hasAnyAuthority("ADMIN", "USER", "AGENT")
            .requestMatchers("/pays/**").permitAll()
            .requestMatchers("/pays").permitAll()
            .anyRequest().authenticated()
        )
        .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
    }
}
