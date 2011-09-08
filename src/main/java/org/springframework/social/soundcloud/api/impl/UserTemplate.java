package org.springframework.social.soundcloud.api.impl;

import org.springframework.social.soundcloud.api.UserOperations;
import org.springframework.web.client.RestTemplate;

public class UserTemplate extends AbstractUserTemplate implements UserOperations {

	
	public UserTemplate(RestTemplate restTemplate, long userId, boolean isAuthorizedForUser) {
		super(restTemplate, isAuthorizedForUser);
		this.userId = userId;
	}
	
	

	private long userId;
 
	@Override
	protected String getUsersResourcePrefix() {
		return  "/users/" + userId;
	}



}
