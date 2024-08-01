
package com.application.ProductivityHub.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OAuth2AuthorizationController {

    @GetMapping("/login/oauth2/code/google")
    public Map<String, Object> getGoogleLoginInfo(OAuth2AuthenticationToken authentication, @RequestParam("code") String code) {
        System.out.println("Received request at /login/oauth2/code/google with code: {" + code +"}" );
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("name", authentication.getPrincipal().getAttribute("name"));
        userInfo.put("email", authentication.getPrincipal().getAttribute("email"));
        userInfo.put("authorization_code", code);
        System.out.println("User info: {" + userInfo + "}");
        return userInfo;
    }

    @GetMapping("/loginFailure")
    public String loginFailure() {
        return "Login failed!";
    }
}