/**
 * Classes extended from spring-social-vkontakte to add possibility of getting user email field using abstract
 * spring-social-core.connect.Connection fetchUserProfile() method.
 *
 * In ver.1.1.0 of spring-social-vkontakte UserProfile is fetched without email field, and there is no email field
 * in provided VKontakteProfile class.
 * Since vk.com OAuth provider gives user email as parameter in same response with request_token, this email is stored
 * for later usage in UserProfile creation process.
 *
 * Register VkConnectionFactory instead of VKontakteConnectionFactory in your social configuration to make use of this package.
 */
package com.provectus.prodobro.social.vkontakte;