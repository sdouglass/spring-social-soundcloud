package org.springframework.social.soundcloud.api.impl;

import java.net.URLEncoder;
import java.util.List;

import org.springframework.social.soundcloud.api.Track;
import org.springframework.social.soundcloud.api.TracksOperations;
import org.springframework.social.soundcloud.api.impl.json.TrackList;
import org.springframework.web.client.RestTemplate;

public class TracksTemplate extends AbstractSoundCloudResourceOperations implements TracksOperations {

	public TracksTemplate(String clientId,RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(clientId,restTemplate, isAuthorizedForUser,true);
	}
	
	

	@Override
	public List<Track> search(String query) {
		 return  restTemplate.getForObject(getApiResourceUrl("?q=" + URLEncoder.encode(query)), TrackList.class);	 
	}



	@Override
	protected String getApiResourceBaseUrl() {
		return getApiBaseUrl() + "/tracks";
	}



}
