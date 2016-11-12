package com.provectus.prodobro.social.security;

import com.provectus.prodobro.social.user.AppUser;
import com.provectus.prodobro.social.user.AppUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@RestController
@RequestMapping("/api/session")
public class AuthResource {

    @RequestMapping(method = RequestMethod.GET)
    public AppUser session(Principal principal) {
        String name = principal == null ? null : principal.getName();
        return new AppUser(name);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @RequestMapping(value="/details", method = RequestMethod.GET)
    public AppUserDetails details(Principal principal) {
        if (principal != null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            AppAuthentication myAuth = (AppAuthentication) auth;
            return myAuth.getDetails();
        } else {
            return new AppUserDetails();
        }
    }

}