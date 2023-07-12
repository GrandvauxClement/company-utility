package com.grandvauxc.companyutility.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;

@Configuration
public class SecurityConfig {

    @Value("{spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String issuerUri;
    @Autowired
    private AuthGard authGard;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("api/hello").permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(token -> token.decoder(jwtDecoder()))
                ).addFilterAfter(authGard, SecurityContextHolderAwareRequestFilter.class);

        return httpSecurity.build();
    }

    @Bean
    public JwtDecoder jwtDecoder(){
        return JwtDecoders.fromIssuerLocation(issuerUri);
    }
}
