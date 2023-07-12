package com.grandvauxc.companyutility.config.security;

import com.grandvauxc.companyutility.entity.User;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.util.UUID;

@Component
@Slf4j
public class AuthGard extends GenericFilterBean {

    private User federatedUser;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        User userFromToken = getUserFromRequest((HttpServletRequest) servletRequest);

        log.info("Id profile: {}", userFromToken.getKeycloakId());
        User user = new User();
        try{
            //get user from service by keycloakId
            user = new User();
        } catch (EntityNotFoundException ex){
            log.info("Creating new profile : {}", "email insrt");
            user = userFromToken;
            //Call service to create
        }
        log.info("Found Profile : {}", user.getEmail());
        this.federatedUser = user;
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private User getUserFromRequest(HttpServletRequest request){
        User user = new User();

        Jwt token = ((JwtAuthenticationToken) request.getUserPrincipal()).getToken();

        // Extractions info token
        user.setEmail(token.getClaimAsString("email"));
        user.setKeycloakId(UUID.fromString(request.getUserPrincipal().getName()));
        return user;
    }
}
