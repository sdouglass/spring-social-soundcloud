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



import org.springframework.social.soundcloud.api.ResolveOperations;
import org.springframework.social.soundcloud.api.SoundCloudProfile;
import org.springframework.social.soundcloud.api.Track;
import org.springframework.web.client.RestTemplate;

public class ResolveTemplate extends AbstractSoundCloudResourceOperations implements ResolveOperations {


	
	
	public ResolveTemplate(String clientId,RestTemplate restTemplate,
			boolean isAuthorizedForUser) {
		super(clientId,restTemplate, isAuthorizedForUser,true);
	}
	
	protected String getResolvableResourceBaseUrl()
	{
		return "http://soundcloud.com";
	}
	
	protected String getResolvableResourceUrl(String resourcePath)
	{
		return getResolvableResourceBaseUrl() + resourcePath;
	}

	@Override
	protected String getApiResourceBaseUrl() {
		return getApiBaseUrl() + "/resolve";
	}
	
	@Override
	public <T> T resolveSoundCloudResource(String resourceUrl,Class<T> t)
	{
		return restTemplate.getForObject(getApiResourceUrl("?url=" + resourceUrl), t);
	}
	
	@Override
	public SoundCloudProfile resolveUserProfile(String username)
	{
		return resolveSoundCloudResource(getResolvableResourceUrl("/" + username),SoundCloudProfile.class);
	}
	
	@Override
	public Track resolveTrack(String trackUrl)
	{
		return resolveSoundCloudResource(trackUrl,Track.class);
	}



	


}
