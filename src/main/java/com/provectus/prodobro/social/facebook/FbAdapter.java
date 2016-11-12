package com.provectus.prodobro.social.facebook;

import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.connect.FacebookAdapter;

public class FbAdapter extends FacebookAdapter {

    @Override
    public UserProfile fetchUserProfile(Facebook facebook) {
        String [] fields = { "id", "email",  "first_name", "last_name" };
        User profile = facebook.fetchObject("me", User.class, fields);
        return (new UserProfileBuilder())
                .setId(profile.getId())
                .setName(profile.getName())
                .setFirstName(profile.getFirstName())
                .setLastName(profile.getLastName())
                .setEmail(profile.getEmail())
                .build();
    }

}