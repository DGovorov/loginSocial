package com.provectus.prodobro.social.vkontakte;

import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.vkontakte.connect.VKontakteOAuth2Template;

import java.util.Map;

public class VkOAuth2Template extends VKontakteOAuth2Template {

    private String email;

    public VkOAuth2Template(String clientId, String clientSecret) {
        super(clientId, clientSecret);
        setUseParametersForClientAuthentication(true);
    }

    protected AccessGrant createAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn, Map<String, Object> response) {
        fetchUserEmail(response);
        return super.createAccessGrant(accessToken, scope, refreshToken, expiresIn.longValue() == 0L ? null : expiresIn, response);
    }

    private void fetchUserEmail(Map<String, Object> response) {
        email = (String) response.get("email");
    }

    public String getEmail() {
        return this.email;
    }
}
