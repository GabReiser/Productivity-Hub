package com.application.ProductivityHub.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class CustomAuthorizationRequestResolver implements OAuth2AuthorizationRequestResolver {
    private final OAuth2AuthorizationRequestResolver defaultAuthorizationRequestResolver;

    public CustomAuthorizationRequestResolver(ClientRegistrationRepository clientRegistrationRepository) {
        this.defaultAuthorizationRequestResolver = new DefaultOAuth2AuthorizationRequestResolver(clientRegistrationRepository, "/oauth2/authorization");
    }
    @Override
    public OAuth2AuthorizationRequest resolve(HttpServletRequest request) {
        return customAuthorizationRequest(this.defaultAuthorizationRequestResolver.resolve(request));
    }

    @Override
    public OAuth2AuthorizationRequest resolve(HttpServletRequest request, String clientRegistrationId) {
        return this.customAuthorizationRequest(this.defaultAuthorizationRequestResolver.resolve(request, clientRegistrationId));
    }
    private OAuth2AuthorizationRequest customAuthorizationRequest(OAuth2AuthorizationRequest authorizationRequest) {
        if (authorizationRequest == null) {
            return null;
        }

        return OAuth2AuthorizationRequest.from(authorizationRequest)
                .authorizationRequestUri(UriComponentsBuilder.fromUriString(authorizationRequest.getAuthorizationRequestUri())
                        .replaceQueryParam("prompt", "consent")
                        .build().toUriString())
                .build();
    }
}