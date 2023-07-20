package com.grandvauxc.companyutility.config.security;

import com.grandvauxc.companyutility.entity.User;
import com.grandvauxc.companyutility.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.util.UUID;

@Component
@Slf4j
public class AuthGard {

    private User federatedUser;

    final UserService userService;

    public AuthGard(UserService userService) {
        this.userService = userService;
    }

    @EventListener
    public void onSuccess(AuthenticationSuccessEvent success) {
        User userFromToken = getUserFromRequest(success.getAuthentication());

        log.info("Id profile: {}", userFromToken.getKeycloakId());
        User user ;
        try{
            //get user from service by keycloakId
            user = userService.findByKeycloakId(userFromToken.getKeycloakId());
        } catch (EntityNotFoundException ex){
            log.info("Creating new profile : {}", "email insrt");
            user = userFromToken;
            user = userService.create(user);
        }
        log.info("Found Profile : {}", user.getEmail());
        this.federatedUser = user;
    }

    private User getUserFromRequest(Authentication authentication){
        User user = new User();

        Jwt token = (Jwt) authentication.getPrincipal();

        // Extractions info token
        user.setEmail(token.getClaimAsString("email"));
        user.setKeycloakId(UUID.fromString(authentication.getName()));
        return user;
    }

    public User getFederatedUser() {
        return federatedUser;
    }
}
