package org.springframework.social.soundcloud.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.PUT;

import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import static org.springframework.social.test.client.RequestMatchers.header;


import java.util.List;

import org.junit.Test;


public class MeTemplateTest extends AbstractSoundCloudApiTest {

	@Test
	public void getFavorites() {
		
		mockServer
		.expect(requestTo("https://api.soundcloud.com/me/favorites"))
		.andExpect(method(GET))
		.andExpect(header("Authorization","OAuth " + ACCESS_TOKEN))
		.andRespond(
				withResponse(jsonResource("testdata/favorites"),
						responseHeaders));

		List<Track> tracks = soundCloud.meOperations().getFavorites();
		assertNotNull(tracks);
		assertEquals(50,tracks.size());
		Track firstTrack = tracks.get(0);
		assertEquals("Sneaky Sound System - Big (Oliver Remix)",firstTrack.getTitle());
		assertEquals("http://soundcloud.com/weareoliver/sneaky-sound-system-big-oliver",firstTrack.getPermalinkUrl());
		assertEquals("22905377",firstTrack.getId());
	
	}
	
	@Test
	public void getTracks() {

		
		mockServer
		.expect(requestTo("https://api.soundcloud.com/me/tracks"))
		.andExpect(header("Authorization","OAuth " + ACCESS_TOKEN))
		.andExpect(method(GET))
		.andRespond(
				withResponse(jsonResource("testdata/tracks"),
						responseHeaders));

		List<Track> tracks = soundCloud.meOperations().getTracks();

		assertNotNull(tracks);
		assertEquals(50,tracks.size());
		Track firstTrack = tracks.get(0);
		assertEquals("Kid Sister vs Daft Punk (Monsieur Adi Mashup)",firstTrack.getTitle());
		assertEquals("http://soundcloud.com/monsieuradi/kid-sister-vs-daft-punk",firstTrack.getPermalinkUrl());
		assertEquals("39679670",firstTrack.getId());
	
		
	}
	
	@Test
	public void getUserProfile() {


		mockServer
		.expect(requestTo("https://api.soundcloud.com/me"))
		.andExpect(header("Authorization","OAuth " + ACCESS_TOKEN))
		.andExpect(method(GET))
		.andRespond(
				withResponse(jsonResource("testdata/userprofile1"),
						responseHeaders));

		SoundCloudProfile userProfile = soundCloud.meOperations().getUserProfile();
		assertNotNull(userProfile);

		assertEquals("mattslip",userProfile.getUsername());
		assertEquals("Matt Slip",userProfile.getFullName());
		assertEquals("https://i1.sndcdn.com/avatars-000002866761-cj637a-large.jpg?cc23540",userProfile.getAvatarUrl());
		assertEquals("London",userProfile.getCity());
		assertEquals("https://api.soundcloud.com/users/3510549",userProfile.getUri());
		assertEquals("http://soundcloud.com/mattslip",userProfile.getPermalinkUrl());

	}
	
	@Test
	public void favoriteTrack() {


		mockServer
		.expect(requestTo("https://api.soundcloud.com/me/favorites/12345"))
		.andExpect(header("Authorization","OAuth " + ACCESS_TOKEN))
		.andExpect(method(PUT))
		.andRespond(
				withResponse(jsonResource("testdata/userprofile1"),
						responseHeaders));

		soundCloud.meOperations().favoriteTrack(12345);
	
	}
	

	
}
