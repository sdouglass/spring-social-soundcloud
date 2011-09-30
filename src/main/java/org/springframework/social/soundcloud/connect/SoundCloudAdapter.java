package org.springframework.social.soundcloud.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.soundcloud.api.SoundCloud;
import org.springframework.social.soundcloud.api.SoundCloudProfile;

/**
* SoundCloud ApiAdapter implementation.
* @author Michael Lavelle
*/
public class SoundCloudAdapter implements ApiAdapter<SoundCloud> {

	@Override
	public UserProfile fetchUserProfile(SoundCloud soundCloud) {
		SoundCloudProfile profile = soundCloud.meOperations().getUserProfile();
		return new UserProfileBuilder().setName(profile.getFullName()).setUsername(profile.getUsername()).build();

	}

	@Override
	public void setConnectionValues(SoundCloud soundCloud, ConnectionValues values) {
		SoundCloudProfile profile = soundCloud.meOperations().getUserProfile();
		values.setProviderUserId(profile.getId());
		values.setDisplayName(profile.getUsername());
		values.setProfileUrl(profile.getPermalinkUrl());
		values.setImageUrl(profile.getAvatarUrl());
	}


	
	@Override
	public boolean test(SoundCloud soundCloud) {
		try {
			soundCloud.meOperations().getUserProfile();
			return true;
			} catch (ApiException e) {
			return false;
			}
	}

	@Override
	public void updateStatus(SoundCloud soundCloud, String arg1) {
		
	}

}
