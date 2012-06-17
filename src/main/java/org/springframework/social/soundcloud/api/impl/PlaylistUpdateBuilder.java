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

import java.util.ArrayList;
import java.util.List;

import org.springframework.social.soundcloud.api.Playlist;
import org.springframework.social.soundcloud.api.PlaylistUpdate;
import org.springframework.social.soundcloud.api.TrackReference;

public class PlaylistUpdateBuilder {

	private PlaylistUpdate playlistUpdate;
	
	public PlaylistUpdateBuilder()
	{
		this.playlistUpdate = new PlaylistUpdate();
	}
	
	public PlaylistUpdateBuilder(Playlist playlist)
	{
		this.playlistUpdate = new PlaylistUpdate();
		setTrackReferences(playlist.getTracks());
	}
	
	public PlaylistUpdateBuilder setTracks(String[] permalinkUrls)
	{
		playlistUpdate.setTrackReferences(new TrackReferenceListBuilder(permalinkUrls).build());
		return this;
	}
	
	public PlaylistUpdateBuilder setTracks(long[] trackIds)
	{
		playlistUpdate.setTrackReferences(new TrackReferenceListBuilder(trackIds).build());
		return this;
	}
	
	public PlaylistUpdateBuilder setTrackReferences(List<? extends TrackReference> trackReferences)
	{
		List<TrackReference> trackReferencesList = new ArrayList<TrackReference>();
		for (TrackReference trackReference : trackReferences)
		{
			trackReferencesList.add(new TrackReference(trackReference.getId(),trackReference.getPermalinkUrl()));
		}
		playlistUpdate.setTrackReferences(trackReferencesList);
		return this;
	}
	
	public PlaylistUpdateBuilder addTrack(long trackId)
	{
		addTrack(new TrackReference(trackId));
		return this;
	}
	
	public PlaylistUpdateBuilder addTrack(String permalinkUrl)
	{
		addTrack(new TrackReference(permalinkUrl));
		return this;
	}
	
	public PlaylistUpdateBuilder addTrack(TrackReference trackReference)
	{
		List<TrackReference> existingTracks = playlistUpdate.getTrackReferences();
		if (existingTracks == null)
		{
			existingTracks = new ArrayList<TrackReference>();
		}
		existingTracks.add(trackReference);
		setTrackReferences(existingTracks);
		return this;
	}
	
	
	public PlaylistUpdateBuilder setTitle(String title)
	{
		playlistUpdate.setTitle(title);
		return this;
	}
	
	
	public PlaylistUpdate build()
	{
		return playlistUpdate;
	}
	

	
}
