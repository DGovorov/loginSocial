package com.provectus.prodobro.social.vkontakte;

import org.springframework.social.vkontakte.api.IUsersOperations;
import org.springframework.social.vkontakte.api.VKontakteProfile;
import org.springframework.social.vkontakte.api.vkenums.NameCase;

import java.util.List;

public class VkUsersOperations implements IUsersOperations {

    private IUsersOperations operations;
    private String email;

    public VkUsersOperations(IUsersOperations operations, String email) {
        this.operations = operations;
        this.email = email;
    }

    @Override
    public VKontakteProfile getUser() {
        VkProfile profile = new VkProfile();
        VKontakteProfile basicProfile = operations.getUser();
        profile.setFirstName(basicProfile.getFirstName());
        profile.setLastName(basicProfile.getLastName());
        profile.setId(basicProfile.getId());
        profile.setEmail(email);
        profile.setPhotoId(basicProfile.getPhotoId());
        return profile;
    }

    @Override
    public VKontakteProfile getUser(String s) {
        return operations.getUser(s);
    }

    @Override
    public List<VKontakteProfile> getUsers(List<String> list) {
        return operations.getUsers(list);
    }

    @Override
    public List<VKontakteProfile> getUsers(List<String> list, String s) {
        return operations.getUsers(list, s);
    }

    @Override
    public List<VKontakteProfile> getUsers(List<String> list, String s, NameCase nameCase) {
        return operations.getUsers(list, s, nameCase);
    }
}