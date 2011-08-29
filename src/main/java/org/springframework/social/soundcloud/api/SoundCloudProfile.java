package org.springframework.social.soundcloud.api;

import java.io.Serializable;
import java.util.List;

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
