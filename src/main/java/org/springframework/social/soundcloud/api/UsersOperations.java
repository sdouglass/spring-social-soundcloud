package org.springframework.social.soundcloud.api;

/**
* Defines a means of obtaining UserOperations for a given SoundCloud user id
* @author Michael Lavelle
*/
public interface UsersOperations {

	public UserOperations userOperations(long userId);
	public UserOperations userOperations(String username);

	
}
