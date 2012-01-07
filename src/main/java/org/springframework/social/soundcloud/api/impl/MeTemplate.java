package org.springframework.social.soundcloud.api.impl;

import org.springframework.social.soundcloud.api.MeOperations;
import org.springframework.web.client.RestTemplate;

public class MeTemplate extends AbstractUserTemplate implements MeOperations {

	public MeTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(null,restTemplate, isAuthorizedForUser,false);
	}

	@Override
	protected String getUsersResourcePrefix() {
		return "/me";
	}


	

	

}
