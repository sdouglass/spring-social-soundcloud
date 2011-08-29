package org.springframework.social.soundcloud.connect;

import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;

public class SoundCloudOAuth2Template extends OAuth2Template {

	public SoundCloudOAuth2Template(String clientId, String clientSecret) {
		super(clientId, clientSecret, "https://soundcloud.com/connect", "https://api.soundcloud.com/oauth2/token");
		}

	
	
	
}
