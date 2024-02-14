package com.thc.fallsprbasic.controller;

import com.thc.fallsprbasic.dto.DefaultDto;
import com.thc.fallsprbasic.dto.UserDto;
import com.thc.fallsprbasic.exception.NoAuthorizationException;
import com.thc.fallsprbasic.security.AuthService;
import com.thc.fallsprbasic.security.ExternalProperties;
import com.thc.fallsprbasic.service.UserService;
import com.thc.fallsprbasic.util.TokenFactory;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/auth")
@RestController
public class AuthRestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    //private final TokenFactory tokenFactory;
    private final AuthService authService;
    private final ExternalProperties externalProperties;
    public AuthRestController(
            //TokenFactory tokenFactory
            AuthService authService,
            ExternalProperties externalProperties
    ) {
        //this.tokenFactory = tokenFactory;
        this.authService = authService;
        this.externalProperties = externalProperties;
    }

    @PostMapping("/accessToken")
    public ResponseEntity<Void> accessToken(HttpServletRequest request){
        /*
        String refreshToken = request.getHeader("RefreshToken");
        logger.info("RefreshToken [{}]", refreshToken);
        if(token == null || token.isEmpty()){
            throw new RuntimeException("not received refresh token");
        }
        return ResponseEntity.ok(tokenFactory.generateAccessToken(refreshToken));
         */

        String jwtHeader = request.getHeader(externalProperties.getRefreshKey());
        if(jwtHeader == null || !jwtHeader.startsWith(externalProperties.getTokenPrefix())) {
            throw new NoAuthException("");
        }
        String refreshToken = jwtHeader.substring(12);
        String accessToken = authService.issueAccessToken(refreshToken);
        //response.addHeader(externalProperties.getAccessKey(), externalProperties.getTokenPrefix() + accessToken);

        return ResponseEntity.status(HttpStatus.OK).header(externalProperties.getAccessKey(), externalProperties.getTokenPrefix() + accessToken).build();
    }

}