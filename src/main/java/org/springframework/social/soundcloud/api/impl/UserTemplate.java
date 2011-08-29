package org.springframework.social.soundcloud.api.impl;

import org.codehaus.jackson.JsonNode;
import org.springframework.social.soundcloud.api.SoundCloudProfile;
import org.springframework.social.soundcloud.api.UserOperations;
import org.springframework.web.client.RestTemplate;

public class UserTemplate implements UserOperations {

	private final RestTemplate restTemplate;
	
	private String accessToken;
	
	
	@Override
	public SoundCloudProfile getUserProfile() {
		return  restTemplate.getForObject("https://api.soundcloud.com/me?oauth_token=" + accessToken, SoundCloudProfile.class);
	}
	
	public UserTemplate(RestTemplate restTemplate, String accessToken, boolean isAuthorizedForUser) {
		this.restTemplate = restTemplate;
		this.accessToken = accessToken;
		}
	
	



}
