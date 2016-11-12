/**
 * Creating FacebookConnectionFactory with customized FacebookAdapter to fetch user profile.
 *
 * Since spring-social-facebook ver.2.0.3 expecting facebook API to have "bio" parameter in user operations current
 * its standard implementation of Connection.fetchUserProfile() is not working.
 */
package com.provectus.prodobro.social.facebook;