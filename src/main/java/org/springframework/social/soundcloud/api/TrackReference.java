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

public class TrackReference {

	private String id;
	private String permalinkUrl;
	
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
	
	public TrackReference(String id,String permalinkUrl)
	{
		this.id = id;
		this.permalinkUrl = permalinkUrl;
	}
	
	public TrackReference(String permalinkUrl)
	{
		this.permalinkUrl = permalinkUrl;
	}
	
	public TrackReference(long id)
	{
		this.id = new Long(id).toString();
	}
	
	
	
	
}
