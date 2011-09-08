package org.springframework.social.soundcloud.api.impl;



import org.springframework.social.soundcloud.api.ResolveOperations;
import org.springframework.social.soundcloud.api.SoundCloudProfile;
import org.springframework.social.soundcloud.api.Track;
import org.springframework.web.client.RestTemplate;

public class ResolveTemplate extends AbstractSoundCloudResourceOperations implements ResolveOperations {


	
	
	public ResolveTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser) {
		super(restTemplate, isAuthorizedForUser);
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
