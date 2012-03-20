package org.springframework.social.soundcloud.api;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
* Defines operations for interacting with a SoundCloud User
* @author Michael Lavelle
*/
public interface UserOperations {

	public SoundCloudProfile getUserProfile();
	public Page<Track> getFavorites();
	public Page<Track> getFavorites(Pageable pageable);

	public Page<Track> getTracks(Pageable pageable);
	public Page<Track> getTracks();


	public void favoriteTrack(long trackId);
	
}
