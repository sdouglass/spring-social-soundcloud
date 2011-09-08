package org.springframework.social.soundcloud.connect;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.soundcloud.api.MeOperations;
import org.springframework.social.soundcloud.api.SoundCloud;
import org.springframework.social.soundcloud.api.SoundCloudProfile;


public class SoundCloudAdapterTest {

	private SoundCloudAdapter apiAdapter = new SoundCloudAdapter();
	
	private SoundCloud soundCloud = Mockito.mock(SoundCloud.class);
	
	@Test
	public void fetchProfileForFirstNameLastName() {		
		MeOperations userOperations = Mockito.mock(MeOperations.class);
		Mockito.when(soundCloud.meOperations()).thenReturn(userOperations);
		Mockito.when(userOperations.getUserProfile()).thenReturn(new SoundCloudProfile("12345678", "michaellavelle", "http://a1.sndcdn.com/images/default_avatar_large.png?8460df1","http://soundcloud.com/michaellavelle","Michael Lavelle","https://api.soundcloud.com/users/7031365","London"));
		UserProfile profile = apiAdapter.fetchUserProfile(soundCloud);
		assertEquals("Michael Lavelle", profile.getName());
		assertEquals("Michael", profile.getFirstName());
		assertEquals("Lavelle", profile.getLastName());
		assertNull(profile.getEmail());
		assertEquals("michaellavelle", profile.getUsername());
	}

	@Test
	public void fetchProfileForOnlyFirstName() {		
		MeOperations userOperations = Mockito.mock(MeOperations.class);
		Mockito.when(soundCloud.meOperations()).thenReturn(userOperations);
		Mockito.when(userOperations.getUserProfile()).thenReturn(new SoundCloudProfile("01248", "mattslip", "http://a1.sndcdn.com/images/default_avatar_large.png?8460df1","http://soundcloud.com/mattslip","mattslip","https://api.soundcloud.com/users/3510549","London"));
		UserProfile profile = apiAdapter.fetchUserProfile(soundCloud);
		assertEquals("mattslip", profile.getName());
		assertEquals("mattslip", profile.getFirstName());
		assertNull(profile.getLastName());
		assertNull(profile.getEmail());
		assertEquals("mattslip", profile.getUsername());
	}
	
	
	@Test
	public void setConnectionValues() {		
		MeOperations meOperations = Mockito.mock(MeOperations.class);
		Mockito.when(soundCloud.meOperations()).thenReturn(meOperations);
		Mockito.when(meOperations.getUserProfile()).thenReturn(new SoundCloudProfile("12345678", "michaellavelle", "http://a1.sndcdn.com/images/default_avatar_large.png?8460df1","http://soundcloud.com/michaellavelle","Michael Lavelle","https://api.soundcloud.com/users/7031365","London"));
		TestConnectionValues connectionValues = new TestConnectionValues();
		apiAdapter.setConnectionValues(soundCloud, connectionValues);
		assertEquals("Michael Lavelle", connectionValues.getDisplayName());
		assertEquals("http://a1.sndcdn.com/images/default_avatar_large.png?8460df1", connectionValues.getImageUrl());
		assertEquals("http://soundcloud.com/michaellavelle", connectionValues.getProfileUrl());
		assertEquals("12345678", connectionValues.getProviderUserId());
	}

	private static class TestConnectionValues implements ConnectionValues {

		private String displayName;
		private String imageUrl;
		private String profileUrl;
		private String providerUserId;

		public String getDisplayName() {
			return displayName;
		}

		public void setDisplayName(String displayName) {
			this.displayName = displayName;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		public String getProfileUrl() {
			return profileUrl;
		}

		public void setProfileUrl(String profileUrl) {
			this.profileUrl = profileUrl;
		}

		public String getProviderUserId() {
			return providerUserId;
		}

		public void setProviderUserId(String providerUserId) {
			this.providerUserId = providerUserId;
		}
		
	}
}
