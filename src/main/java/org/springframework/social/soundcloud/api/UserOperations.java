package org.springframework.social.soundcloud.api;

import java.util.List;

/**
* Defines operations for interacting with a SoundCloud User
* @author Michael Lavelle
*/
public interface UserOperations {

	public SoundCloudProfile getUserProfile();
	public List<Track> getFavorites();
	public List<Track> getTracks();

	public void favoriteTrack(long trackId);
	
}
