package org.springframework.social.soundcloud.api.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.social.soundcloud.api.SoundCloudProfile;
import org.springframework.social.soundcloud.api.Track;
import org.springframework.social.soundcloud.api.UserOperations;
import org.springframework.social.soundcloud.api.impl.json.TrackList;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractUserTemplate extends AbstractSoundCloudResourceOperations implements UserOperations {
	
	public AbstractUserTemplate(String clientId,RestTemplate restTemplate,
			boolean isAuthorizedForUser,boolean appendClientIdIfNotAuthorized) {
		super(clientId,restTemplate, isAuthorizedForUser,appendClientIdIfNotAuthorized);
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
	public Page<Track> getFavorites() {
		 return  getFavorites(null);
	}

	@Override
	public Page<Track> getFavorites(Pageable pageable) {

		 SoundCloudProfile soundCloudProfile = getUserProfile();
		 List<Track> tracks = restTemplate.getForObject(getApiResourceUrl("/favorites",pageable), TrackList.class);	 
		 if (pageable == null)
		 {
			 return new PageImpl<Track>(tracks,new PageRequest(0,50),soundCloudProfile.getFavoritesCount());
		 }
		 else
		 {
			 return new PageImpl<Track>(tracks,new PageRequest(pageable.getPageNumber(),pageable.getPageSize()),soundCloudProfile.getFavoritesCount());
		 }
		 
	}
	
	@Override
	public Page<Track> getTracks() {
		return getTracks(null);
	}
	
	@Override
	public Page<Track> getTracks(Pageable pageable) {
		 SoundCloudProfile soundCloudProfile = getUserProfile();

		 List<Track> tracks =  restTemplate.getForObject(getApiResourceUrl("/tracks",pageable), TrackList.class);	
		 if (pageable == null)
		 {
			 return new PageImpl<Track>(tracks,new PageRequest(0,50),soundCloudProfile.getTrackCount());
		 }
		 else
		 {
			 return new PageImpl<Track>(tracks,new PageRequest(pageable.getPageNumber(),pageable.getPageSize()),soundCloudProfile.getTrackCount());
		 }
		 
		 
		 
	}



}
