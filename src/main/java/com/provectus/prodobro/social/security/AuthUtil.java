package com.provectus.prodobro.social.security;

import com.provectus.prodobro.social.user.AppUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.UserProfile;

public class AuthUtil {

    private static final Logger log = LoggerFactory.getLogger(AuthUtil.class);

    public static void authenticate(Connection<?> connection) {
        AppUserDetails details = getAppUserDetails(connection);
        AppAuthentication authentication = getAppAuthentication(details);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        log.info("User {} {} {} connected via {}.",
                details.getFirstName(),
                details.getLastName(),
                details.getEmail(),
                details.getSocialProvider());
    }

    private static AppAuthentication getAppAuthentication(AppUserDetails details) {
        String principal = details.getSocialProvider() + details.getSocialProviderId();
        return new AppAuthentication(principal, null, null, details);
    }

    private static AppUserDetails getAppUserDetails(Connection<?> connection) {
        ConnectionData data = connection.createData();
        String providerId = data.getProviderId();
        String providerUserId = data.getProviderUserId();
        UserProfile userProfile = connection.fetchUserProfile();

        return new AppUserDetails(
                userProfile.getFirstName(),
                userProfile.getLastName(),
                userProfile.getEmail(),
                providerUserId,
                providerId);
    }

}