package com.yytxdy.ylyn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@RestController
public class ResourceApplication {
    @RequestMapping("/ping")
    public Object ping(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = ((OAuth2Authentication) authentication).getUserAuthentication().getPrincipal();
        return "pong: " + principal;
    }

    // http://localhost:8082/ping Authorization=bearer+jwtToken
    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
    }

}
