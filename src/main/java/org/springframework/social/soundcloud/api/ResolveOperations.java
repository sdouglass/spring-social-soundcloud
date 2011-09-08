package org.springframework.social.soundcloud.api;


/**
* Defines operations for interacting with a SoundCloud resource
* @author Michael Lavelle
*/
public interface ResolveOperations {

	public <T> T resolveSoundCloudResource(String resourceUrl,Class<T> t);
	public SoundCloudProfile resolveUserProfile(String username);
	public Track resolveTrack(String trackUrl);


}
