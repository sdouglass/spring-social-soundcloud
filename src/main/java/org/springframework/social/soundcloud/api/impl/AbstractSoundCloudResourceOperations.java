package org.springframework.social.soundcloud.api.impl;

import org.springframework.web.client.RestTemplate;

public abstract class AbstractSoundCloudResourceOperations extends AbstractSoundCloudOperations{
	
	public AbstractSoundCloudResourceOperations(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(restTemplate,isAuthorizedForUser);
		}
	
	protected abstract String getApiResourceBaseUrl();
	
	protected String getApiResourceUrl(String resourcePath)
	{
		return getApiResourceBaseUrl() + resourcePath;
	}
	
	
	
	
}
