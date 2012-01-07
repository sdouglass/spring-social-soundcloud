package org.springframework.social.soundcloud.api.impl;

import org.springframework.web.client.RestTemplate;

public abstract class AbstractSoundCloudResourceOperations extends AbstractSoundCloudOperations{
	
	private boolean appendClientIfIfNotAuthorized;
	
	public AbstractSoundCloudResourceOperations(String clientId,RestTemplate restTemplate, boolean isAuthorizedForUser,boolean appendClientIfIfNotAuthorized) {
		super(clientId,restTemplate,isAuthorizedForUser);
		this.appendClientIfIfNotAuthorized = appendClientIfIfNotAuthorized;
		}
	
	
	protected abstract String getApiResourceBaseUrl();
	
	
	protected String getApiResourceUrl(String resourcePath)
	{
		String resourceUrl = getApiResourceBaseUrl() + resourcePath;
		if (appendClientIfIfNotAuthorized && !isAuthorizedForUser && clientId != null)
		{
			String querySeparator = resourceUrl.indexOf("?") == -1 ? "?" : "&";
			resourceUrl = resourceUrl + querySeparator + "client_id=" + clientId;
		}
		return resourceUrl;
	}
	
	
	
	
}
