package com.provectus.prodobro.social.vkontakte;

import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.vkontakte.api.VKontakte;
import org.springframework.social.vkontakte.connect.VKontakteAdapter;

public class VkAdapter extends VKontakteAdapter {

    @Override
    public UserProfile fetchUserProfile(VKontakte vkontakte) {
        VkProfile profile = (VkProfile) vkontakte.usersOperations().getUser();
        return (new UserProfileBuilder())
                .setId(String.valueOf(profile.getId()))
                .setUsername(profile.getScreenName())
                .setEmail(profile.getEmail())
                .setFirstName(profile.getFirstName())
                .setLastName(profile.getLastName())
                .setName(profile.getFirstName() + " " + profile.getLastName())
                .build();
    }
}