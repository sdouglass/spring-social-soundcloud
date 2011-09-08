package org.springframework.social.soundcloud.api.impl;

import java.util.List;

import org.springframework.social.soundcloud.api.SoundCloudProfile;
import org.springframework.social.soundcloud.api.Track;
import org.springframework.social.soundcloud.api.UserOperations;
import org.springframework.social.soundcloud.api.impl.json.TrackList;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractUserTemplate extends AbstractSoundCloudResourceOperations implements UserOperations {
	
	public AbstractUserTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser) {
		super(restTemplate, isAuthorizedForUser);
	}
	protected abstract String getUsersResourcePrefix();
	
	@Override
	protected String getApiResourceBaseUrl() {
		return getApiBaseUrl() + getUsersResourcePrefix();
	}
	
	@Override
	public void favoriteTrack(long trackId) {
		restTemplate.put(getApiResourceUrl("/favorites/" + trackId),null);

	}
	
	@Override 
	public SoundCloudProfile getUserProfile() {
		return  restTemplate.getForObject(getApiResourceUrl(""), SoundCloudProfile.class);
	}

	@Override
	public List<Track> getFavorites() {
		 return  restTemplate.getForObject(getApiResourceUrl("/favorites"), TrackList.class);	 
	}
	
	@Override
	public List<Track> getTracks() {
		 return  restTemplate.getForObject(getApiResourceUrl("/tracks"), TrackList.class);	 
	}



}
