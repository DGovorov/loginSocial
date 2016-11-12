package com.provectus.prodobro.social.security;

import com.provectus.prodobro.social.user.AppUserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class AppAuthentication extends UsernamePasswordAuthenticationToken implements Authentication {

    private AppUserDetails details;

    public AppAuthentication(Object principal, Object credentials, AppUserDetails details) {
        super(principal, credentials);
        this.details = details;
    }

    public AppAuthentication(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, AppUserDetails details) {
        super(principal, credentials, authorities);
        this.details = details;
    }

    @Override
    public AppUserDetails getDetails() {
        return details;
    }
}