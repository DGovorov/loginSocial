package com.provectus.prodobro.social.social;

import com.provectus.prodobro.social.security.AuthUtil;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;

public class AppSignInAdapter implements SignInAdapter {

    @Override
    public String signIn(String s, Connection<?> connection, NativeWebRequest nativeWebRequest) {
        AuthUtil.authenticate(connection);
        return null;
    }

}