package com.application.ProductivityHub.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OAuth2Controller {
    /*
    @GetMapping("/login/oauth2/code/google")
    public Map<String, Object> getGoogleLoginInfo(OAuth2AuthenticationToken authentication, @RequestParam("code") String code) {
        System.out.println("Received request at /login/oauth2/code/google with code: {" + code +"}" );
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("name", authentication.getPrincipal().getAttribute("name"));
        userInfo.put("email", authentication.getPrincipal().getAttribute("email"));
        userInfo.put("authorization_code", code);
        System.out.println("User info: {" + userInfo + "}");
        return userInfo;
    }*/

    @GetMapping("/login/oauth2/code/microsoft")
    public Map<String, Object> getMicrosoftLoginInfo(OAuth2AuthenticationToken authentication, @RequestParam("token") String token) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("name", authentication.getPrincipal().getAttribute("name"));
        userInfo.put("email", authentication.getPrincipal().getAttribute("email"));
        userInfo.put("token", token);
        return userInfo;
    }
}
