/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
