package com.provectus.prodobro.social.vkontakte;

import org.springframework.social.vkontakte.api.VKontakteProfile;

public class VkProfile extends VKontakteProfile {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
