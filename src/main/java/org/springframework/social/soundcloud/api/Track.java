package org.springframework.social.soundcloud.api;

public class Track {
	
	private String permalinkUrl;
	private String title;
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPermalinkUrl() {
		return permalinkUrl;
	}
	public void setPermalinkUrl(String permalinkUrl) {
		this.permalinkUrl = permalinkUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Track(String permalinkUrl,String title,String id)
	{
		this.title = title;
		this.permalinkUrl = permalinkUrl;
		this.id = id;
	}

}
