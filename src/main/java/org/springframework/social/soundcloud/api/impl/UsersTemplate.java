package org.springframework.social.soundcloud.api.impl;

import org.springframework.social.soundcloud.api.ResolveOperations;
import org.springframework.social.soundcloud.api.SoundCloudProfile;
import org.springframework.social.soundcloud.api.UserOperations;
import org.springframework.social.soundcloud.api.UsersOperations;
import org.springframework.web.client.RestTemplate;

public class UsersTemplate extends AbstractSoundCloudOperations implements UsersOperations {

	public UsersTemplate(String clientId,RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(clientId,restTemplate, isAuthorizedForUser);
	}

	@Override
	public UserOperations userOperations(long userId) {
		return new UserTemplate(clientId,restTemplate,userId,isAuthorizedForUser);
	}
	
	@Override
	public UserOperations userOperations(String username) {
		ResolveOperations resolveOperations = new ResolveTemplate(clientId,restTemplate,isAuthorizedForUser);
		SoundCloudProfile soundCloudProfile = resolveOperations.resolveUserProfile(username);
		return new UserTemplate(clientId,restTemplate,Long.parseLong(soundCloudProfile.getId()),isAuthorizedForUser);
	}


}
