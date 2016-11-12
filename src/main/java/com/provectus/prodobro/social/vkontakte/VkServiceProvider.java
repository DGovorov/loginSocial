package com.provectus.prodobro.social.vkontakte;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.vkontakte.api.VKontakte;

public class VkServiceProvider extends AbstractOAuth2ServiceProvider<VKontakte> {

    protected final String clientSecret;

    public VkServiceProvider(String clientId, String clientSecret) {
        super(new VkOAuth2Template(clientId, clientSecret));
        this.clientSecret = clientSecret;
    }

    public VKontakte getApi(String accessToken) {
        VkOAuth2Template vKontakteOAuth2Template = (VkOAuth2Template) getOAuthOperations();
        return new VkTemplate(accessToken, this.clientSecret, vKontakteOAuth2Template.getEmail());
    }
}
