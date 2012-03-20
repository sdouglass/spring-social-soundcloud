package org.springframework.social.soundcloud.api.impl;

import org.springframework.data.domain.Pageable;
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
		return getApiResourceUrl(resourcePath,null);
	}
	
	private String getQuerySeparator(String existingResourceUrl)
	{
		return existingResourceUrl.indexOf("?") == -1 ? "?" : "&";

	}
	
	protected String getApiResourceUrl(String resourcePath,Pageable pageable)
	{
		String resourceUrl = getApiResourceBaseUrl() + resourcePath;
		if (appendClientIfIfNotAuthorized && !isAuthorizedForUser && clientId != null)
		{
			resourceUrl = resourceUrl + getQuerySeparator(resourceUrl) + "client_id=" + clientId;
		}
		if (pageable != null)
		{
			resourceUrl = resourceUrl + getQuerySeparator(resourceUrl)  + "limit=" + pageable.getPageSize() + "&offset=" + pageable.getOffset();
		}
		return resourceUrl;
	}
	
	
	
	
}
