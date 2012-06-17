/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.soundcloud.api;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.social.test.client.RequestMatchers.body;
import static org.springframework.social.test.client.RequestMatchers.header;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;
import org.springframework.social.soundcloud.api.impl.PlaylistUpdateBuilder;

public class PlaylistsTemplateTest extends AbstractSoundCloudApiTest {

	@Test
	public void getPlaylist()
	{
		
		mockUnauthorizedServer
		.expect(requestTo("https://api.soundcloud.com/playlists/somePlaylistId"))
		.andExpect(method(GET))
		.andRespond(
				withResponse(jsonResource("testdata/playlist"),
						responseHeaders));

		Playlist playlist = unauthorizedSoundCloud.playlistsOperations().getPlaylist("somePlaylistId");
		assertPlaylistData(playlist);

	}
	
	
	@Test
	public void createPlaylist() throws IOException
	{
		 BufferedReader in
		   = new BufferedReader(new InputStreamReader(xmlResource("testdata/playlist").getInputStream()));
		 
		 
		 String xml = in.readLine();
		
		mockServer
		.expect(requestTo("https://api.soundcloud.com/playlists"))
		.andExpect(method(POST))
		.andExpect(header("Content-Type","application/xml"))
		.andExpect(body(xml))
		.andRespond(
				withResponse(jsonResource("testdata/playlist"),
						responseHeaders));

		PlaylistUpdateBuilder builder = new PlaylistUpdateBuilder();
		builder.setTitle("My Test Playlist");
		builder.addTrack(123456);
		
		
		Playlist playlist = soundCloud.playlistsOperations().createPlaylist(builder.build());
		assertPlaylistData(playlist);

	}
	
	@Test
	public void updatePlaylist() throws IOException
	{
		 BufferedReader in
		   = new BufferedReader(new InputStreamReader(xmlResource("testdata/playlist").getInputStream()));
		 
		 
		 String xml = in.readLine();
		
		mockServer
		.expect(requestTo("https://api.soundcloud.com/playlists/somePlaylistId"))
		.andExpect(method(PUT))
		.andExpect(header("Content-Type","application/xml"))
		.andExpect(body(xml))
		.andRespond(
				withResponse(jsonResource("testdata/playlist"),
						responseHeaders));
		
		mockServer
		.expect(requestTo("https://api.soundcloud.com/playlists/somePlaylistId"))
		.andExpect(method(GET))
		.andRespond(
				withResponse(jsonResource("testdata/playlist"),
						responseHeaders));

		

		PlaylistUpdateBuilder builder = new PlaylistUpdateBuilder();
		builder.setTitle("My Test Playlist");
		builder.addTrack(123456);
		
		
		Playlist playlist = soundCloud.playlistsOperations().updatePlaylist("somePlaylistId",builder.build());
		assertPlaylistData(playlist);

	}
	
	@Test
	public void updatePlaylistWithoutTracksUpdate() throws IOException
	{
		 BufferedReader in
		   = new BufferedReader(new InputStreamReader(xmlResource("testdata/playlistwithouttracks").getInputStream()));
		 
		 
		 String xml = in.readLine();
		
		mockServer
		.expect(requestTo("https://api.soundcloud.com/playlists/somePlaylistId"))
		.andExpect(method(PUT))
		.andExpect(header("Content-Type","application/xml"))
		.andExpect(body(xml))
		.andRespond(
				withResponse(jsonResource("testdata/playlist"),
						responseHeaders));
		
		mockServer
		.expect(requestTo("https://api.soundcloud.com/playlists/somePlaylistId"))
		.andExpect(method(GET))
		.andRespond(
				withResponse(jsonResource("testdata/playlist"),
						responseHeaders));

		

		PlaylistUpdateBuilder builder = new PlaylistUpdateBuilder();
		builder.setTitle("My Test Playlist");
		
		
		Playlist playlist = soundCloud.playlistsOperations().updatePlaylist("somePlaylistId",builder.build());
		assertPlaylistData(playlist);

	}
	
	
	
	
	
	

}
