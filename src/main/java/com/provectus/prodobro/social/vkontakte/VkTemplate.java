package com.provectus.prodobro.social.vkontakte;

import org.springframework.social.vkontakte.api.IUsersOperations;
import org.springframework.social.vkontakte.api.impl.VKontakteTemplate;

public class VkTemplate extends VKontakteTemplate {

    private String email;

    public VkTemplate(String accessToken, String clientSecret, String email) {
        super(accessToken, clientSecret);
        this.email = email;
    }

    @Override
    public IUsersOperations usersOperations() {
        IUsersOperations operations = new VkUsersOperations(super.usersOperations(), email);

        return operations;
    }
}
