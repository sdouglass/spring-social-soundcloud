package org.springframework.social.soundcloud.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import java.util.List;

import org.junit.Test;

public class TrackTemplateTest extends AbstractSoundCloudApiTest {

	@Test
	public void search()
	{
		
		mockUnauthorizedServer
		.expect(requestTo("https://api.soundcloud.com/tracks?q=monsieur%2Badi&client_id=someApiKey"))
		.andExpect(method(GET))
		.andRespond(
				withResponse(jsonResource("testdata/searchresults"),
						responseHeaders));

		List<Track> tracks = unauthorizedSoundCloud.tracksOperations().search("monsieur adi");
		assertNotNull(tracks);
		assertEquals(46,tracks.size());
		Track firstTrack = tracks.get(0);
		assertEquals("Obsessions (Monsieur Adi Remix)",firstTrack.getTitle());
		assertEquals("http://soundcloud.com/bangnmash/obsessions-monsieur-adi-remix",firstTrack.getPermalinkUrl());
		assertEquals("3252916",firstTrack.getId());
	
	}
	
	@Test
	public void search_NoSearchResults()
	{
		
		mockUnauthorizedServer
		.expect(requestTo("https://api.soundcloud.com/tracks?q=monsieur%2Badi&client_id=someApiKey"))
		.andExpect(method(GET))
		.andRespond(
				withResponse(jsonResource("testdata/emptysearchresults"),
						responseHeaders));

		List<Track> tracks = unauthorizedSoundCloud.tracksOperations().search("monsieur adi");
		assertNotNull(tracks);
		assertEquals(0,tracks.size());
	}
	
}
