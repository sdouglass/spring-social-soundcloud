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

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.social.soundcloud.api.Playlist;
import org.springframework.social.soundcloud.api.PlaylistUpdate;
import org.springframework.social.soundcloud.api.PlaylistsOperations;
import org.springframework.social.soundcloud.api.ResolveOperations;
import org.springframework.social.soundcloud.api.Track;
import org.springframework.social.soundcloud.api.TrackReference;
import org.springframework.social.soundcloud.api.impl.xml.XmlPlaylistUpdate;
import org.springframework.web.client.RestTemplate;


public class PlaylistsTemplate extends AbstractSoundCloudResourceOperations
		implements PlaylistsOperations {

	private ResolveOperations resolveOperations;
	
	public PlaylistsTemplate(String clientId, RestTemplate restTemplate,
			boolean isAuthorizedForUser,ResolveOperations resolveOperations) {
		super(clientId, restTemplate, isAuthorizedForUser,
				true);
		this.resolveOperations = resolveOperations;
	}
	
	
	protected void populateMissingTrackIds(PlaylistUpdate playlistUpdate)
	{
		if (playlistUpdate.getTrackReferences() != null)
		{
		for (TrackReference trackReference : playlistUpdate.getTrackReferences())
		{
			if (trackReference.getId() == null && trackReference.getPermalinkUrl() != null)
			{
				Track track = resolveOperations.resolveTrack(trackReference.getPermalinkUrl());
				if (track != null)
				{
					trackReference.setId(track.getId());
				}
			}
		}
		}
	}
	
	protected PlaylistUpdate populatePlaylistUpdate(PlaylistUpdate playlistUpdate)
	{

		populateMissingTrackIds(playlistUpdate);
		return new XmlPlaylistUpdate(playlistUpdate);	
	
	}

	@Override
	public Playlist updatePlaylist(String id,PlaylistUpdate playlistUpdate) {

		requireAuthorization();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		HttpEntity<PlaylistUpdate> entity = new HttpEntity<PlaylistUpdate>(populatePlaylistUpdate(playlistUpdate),headers);
		restTemplate.put(getApiResourceBaseUrl() + "/" + id, entity);
		return getPlaylist(id);
	}

	@Override
	protected String getApiResourceBaseUrl() {
		return getApiBaseUrl() + "/playlists";
	}

	@Override
	public Playlist createPlaylist(PlaylistUpdate playlistUpdate) {
		
		requireAuthorization();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		HttpEntity<PlaylistUpdate> entity = new HttpEntity<PlaylistUpdate>(populatePlaylistUpdate(playlistUpdate),headers);
		return restTemplate.postForObject(getApiResourceBaseUrl(), entity,Playlist.class);
	}


	@Override
	public void deletePlaylist(String id) {
		
		requireAuthorization();
		
		restTemplate.delete(getApiResourceBaseUrl() + "/" + id);
		
	}


	@Override
	public Playlist getPlaylist(String id) {
		return restTemplate.getForObject(getApiResourceBaseUrl() + "/" + id,Playlist.class);
	}

}
