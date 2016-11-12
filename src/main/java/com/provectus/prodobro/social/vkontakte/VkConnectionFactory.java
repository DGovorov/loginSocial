package com.provectus.prodobro.social.vkontakte;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.vkontakte.api.VKontakte;

public class VkConnectionFactory extends OAuth2ConnectionFactory<VKontakte> {

    public VkConnectionFactory(String clientId, String clientSecret) {
        super("vkontakte", new VkServiceProvider(clientId, clientSecret), new VkAdapter());
    }

    public boolean supportsStateParameter() {
        return false;
    }
}
