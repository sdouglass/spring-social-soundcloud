package org.springframework.social.soundcloud.api.impl;

import org.springframework.social.soundcloud.api.MeOperations;
import org.springframework.web.client.RestTemplate;

public class MeTemplate extends AbstractUserTemplate implements MeOperations {

	public MeTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(restTemplate, isAuthorizedForUser);
	}

	@Override
	protected String getUsersResourcePrefix() {
		return "/me";
	}


	

	

}
