package com.cognizant.spring_learn.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping; // Using POST for authenticate for better practice
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.context.SecurityContextHolder;
import com.cognizant.spring_learn.dto.AuthRequest;
import com.cognizant.spring_learn.dto.AuthResponse;

@RestController
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate() {
        LOGGER.info("START - authenticate()");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            LOGGER.warn("Authentication failed or not performed for /authenticate endpoint");
             return ResponseEntity.status(401).body(new AuthResponse("Authentication Failed"));
        }
        String username = authentication.getName();
        LOGGER.info("User {} successfully authenticated via Basic Auth.", username);
        String token = "YOUR_JWT_TOKEN_GENERATED_HERE";
        LOGGER.info("END - authenticate()");
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
