package com.provectus.prodobro.social.facebook;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookServiceProvider;

public class FbConnectionFactory extends OAuth2ConnectionFactory<Facebook> {

    public FbConnectionFactory(String appId, String appSecret) {
        super("facebook", new FacebookServiceProvider(appId, appSecret, null), new FbAdapter());
    }

}