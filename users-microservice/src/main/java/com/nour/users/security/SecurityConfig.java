package com.nour.users.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.lang.NonNull;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    AuthenticationManager authMgr;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(new org.springframework.web.cors.CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(@NonNull jakarta.servlet.http.HttpServletRequest request) {
                        CorsConfiguration cors = new CorsConfiguration();
                        cors.setAllowedOrigins(java.util.Collections.singletonList("http://localhost:4200"));
                        cors.setAllowedMethods(java.util.Collections.singletonList("*"));
                        cors.setAllowedHeaders(java.util.Collections.singletonList("*"));
                        cors.setExposedHeaders(java.util.Collections.singletonList("Authorization"));
                        return cors;
                    }
                }))
                .authorizeHttpRequests(requests -> requests.requestMatchers("/login", "/error").permitAll()
                        .requestMatchers("/all").hasAuthority("ADMIN")
                        .anyRequest().authenticated())
                .addFilterBefore(new JWTAuthenticationFilter(authMgr), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
