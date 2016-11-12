package com.provectus.prodobro.social.social;

import com.provectus.prodobro.social.facebook.FbConnectionFactory;
import com.provectus.prodobro.social.vkontakte.VkConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.social.google.connect.GoogleConnectionFactory;

import javax.inject.Inject;
import javax.sql.DataSource;

@Configuration
@EnableSocial
public class SocialConfiguration implements SocialConfigurer {

    @Inject
    private DataSource dataSource;

    @Bean
    public ProviderSignInController providerSignInController(ConnectionFactoryLocator locator, UsersConnectionRepository repo, Environment env) {
        ProviderSignInController controller = new ProviderSignInController(locator, repo, authSignInAdapter());
        controller.setApplicationUrl(env.getProperty("url.application"));
        controller.setPostSignInUrl(env.getProperty("url.postSignIn"));
        controller.setSignInUrl(env.getProperty("url.signIn"));
        return controller;
    }

    @Bean
    public SignInAdapter authSignInAdapter() {
        return new AppSignInAdapter();
    }

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer cfConfig, Environment env) {
        FbConnectionFactory fb = new FbConnectionFactory(
                env.getProperty("facebook.app.id"),
                env.getProperty("facebook.app.secret"));
        fb.setScope("public_profile,email");
        cfConfig.addConnectionFactory(fb);

        VkConnectionFactory vk = new VkConnectionFactory(
                env.getProperty("vkontakte.app.id"),
                env.getProperty("vkontakte.app.secret"));
        vk.setScope("email");
        cfConfig.addConnectionFactory(vk);

        GoogleConnectionFactory go = new GoogleConnectionFactory(
                env.getProperty("google.app.id"),
                env.getProperty("google.app.secret"));
        go.setScope("profile email");
        cfConfig.addConnectionFactory(go);
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        return new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
    }

    @Override
    public UserIdSource getUserIdSource() {
        return new AppUserIdSource();
    }

}