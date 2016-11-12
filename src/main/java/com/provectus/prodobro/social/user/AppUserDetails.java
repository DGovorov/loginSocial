package com.provectus.prodobro.social.user;

public class AppUserDetails {
    private String firstName;
    private String lastName;
    private String email;
    private String socialProviderId;
    private String socialProvider;

    public AppUserDetails() {
    }

    public AppUserDetails(String firstName, String lastName, String email, String socialProviderId, String socialProvider) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.socialProviderId = socialProviderId;
        this.socialProvider = socialProvider;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocialProviderId() {
        return socialProviderId;
    }

    public void setSocialProviderId(String socialProviderId) {
        this.socialProviderId = socialProviderId;
    }

    public String getSocialProvider() {
        return socialProvider;
    }

    public void setSocialProvider(String socialProvider) {
        this.socialProvider = socialProvider;
    }
}