package org.springframework.social.soundcloud.api.impl;

import java.net.URLEncoder;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.social.soundcloud.api.Track;
import org.springframework.social.soundcloud.api.TracksOperations;
import org.springframework.social.soundcloud.api.impl.json.TrackList;
import org.springframework.web.client.RestTemplate;

public class TracksTemplate extends AbstractSoundCloudResourceOperations implements TracksOperations {

	public TracksTemplate(String clientId,RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(clientId,restTemplate, isAuthorizedForUser,true);
	}
	
	@Override
	public Page<Track> search(String query) {
		return search(query,null);
	}
	

	@Override
	public Page<Track> search(String query,Pageable pageable) {
		 List<Track> tracks =  restTemplate.getForObject(getApiResourceUrl("?q=" + URLEncoder.encode(query),pageable), TrackList.class);
		 return new PageImpl<Track>(tracks,pageable,tracks.size());
	}



	@Override
	protected String getApiResourceBaseUrl() {
		return getApiBaseUrl() + "/tracks";
	}



}
