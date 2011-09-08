package org.springframework.social.soundcloud.api;

import org.springframework.social.soundcloud.api.impl.SoundCloudTemplate;


/**
* Interface specifying a basic set of operations for interacting with SoundCloud.
* Implemented by {@link SoundCloudTemplate}.
* @author Michael Lavelle
*/
public interface SoundCloud {
	
	public MeOperations meOperations();
	public UsersOperations usersOperations();
	public ResolveOperations resolveOperations();


}
