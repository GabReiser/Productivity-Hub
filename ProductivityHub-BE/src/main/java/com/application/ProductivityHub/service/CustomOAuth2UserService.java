// Remover ou renomear a definição duplicada em `com.application.ProductivityHub.security`
package com.application.ProductivityHub.service;

import com.application.ProductivityHub.model.User;
import com.application.ProductivityHub.repository.UserRepository;
import com.application.ProductivityHub.security.JwtTokenUtil;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtTokenUtil jwtTokenProvider;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User user = super.loadUser(userRequest);

        // Extrair atributos do usuário
        String email = user.getAttribute("email");
        String name = user.getAttribute("name");

        // Verificar se o usuário já existe no banco de dados
        User existingUser = userRepository.findByEmail(email).orElse(null);
        if (existingUser == null) {
            // Criar um novo usuário
            User newUser = new User();
            newUser.setUsername(name);
            newUser.setEmail(email);
            userRepository.save(newUser);
        }

        // Gerar token JWT
        String token = jwtTokenProvider.generateToken(email);

        // Adicionar o token JWT aos atributos do usuário
        Map<String, Object> attributes = new HashMap<>(user.getAttributes());
        attributes.put("token", token);

        return new DefaultOAuth2User(user.getAuthorities(), attributes, "name");
    }
}