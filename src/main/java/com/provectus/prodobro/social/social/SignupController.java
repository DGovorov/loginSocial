package com.provectus.prodobro.social.social;

import com.provectus.prodobro.social.security.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class SignupController {

    private ProviderSignInUtils utils;

    private Environment env;

    @Autowired
    public SignupController(ConnectionFactoryLocator locator, UsersConnectionRepository repository, Environment env) {
        utils = new ProviderSignInUtils(locator, repository);
        this.env = env;
    }

    @RequestMapping("/signup")
    public String signUp(WebRequest request) {
        Connection<?> connection = utils.getConnectionFromSession(request);
        AuthUtil.authenticate(connection);
        utils.doPostSignUp(connection.getDisplayName(), request);
        return "redirect:" + env.getProperty("url.postSignIn");
    }

}