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

import java.io.Serializable;

/**
* Model class containing a SoundCloud user's profile information.
* @author Michael Lavelle
*/
public class SoundCloudProfile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String id;
	private String username;
	private String avatarUrl;
	private String permalinkUrl;
	private String fullName;
	private String uri;
	private String city;
	private int favoritesCount;
	private int trackCount;
	private int playlistCount;
	
	
	
	
	public int getPlaylistCount() {
		return playlistCount;
	}

	public void setPlaylistCount(int playlistCount) {
		this.playlistCount = playlistCount;
	}

	public int getTrackCount() {
		return trackCount;
	}

	public void setTrackCount(int trackCount) {
		this.trackCount = trackCount;
	}

	public int getFavoritesCount() {
		return favoritesCount;
	}

	public void setFavoritesCount(int favoritesCount) {
		this.favoritesCount = favoritesCount;
	}

	public SoundCloudProfile()
	{
		
	}

	public SoundCloudProfile(String id,String username,String avatarUrl,String permalinkUrl,String fullName,String uri,String city)
	{
		this.id = id;
		this.username = username;
		this.avatarUrl = avatarUrl;
		this.permalinkUrl = permalinkUrl;
		this.fullName = fullName;
		this.uri = uri;
		this.city = city;
		
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public String getPermalinkUrl() {
		return permalinkUrl;
	}
	public void setPermalinkUrl(String permalinkUrl) {
		this.permalinkUrl = permalinkUrl;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
