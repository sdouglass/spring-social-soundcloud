package org.springframework.social.soundcloud.api.impl;

import org.springframework.web.client.RestTemplate;

public abstract class AbstractSoundCloudOperations {
	
	protected final RestTemplate restTemplate;
	protected final boolean isAuthorizedForUser;
	protected final String clientId;

	
	public AbstractSoundCloudOperations(String clientId,RestTemplate restTemplate, boolean isAuthorizedForUser) {
		this.restTemplate = restTemplate;
		this.isAuthorizedForUser = isAuthorizedForUser;
		this.clientId = clientId;
		}
	
	protected String getApiBaseUrl()
	{
		return "https://api.soundcloud.com";
	}
	
	
	
	
}
	
