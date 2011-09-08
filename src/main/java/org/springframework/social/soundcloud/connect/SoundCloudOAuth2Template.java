package org.springframework.social.soundcloud.connect;

import java.util.Map;

import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;

/**
* SoundCloud-specific extension of OAuth2Template
* @author Michael Lavelle
*/
public class SoundCloudOAuth2Template extends OAuth2Template {

	public SoundCloudOAuth2Template(String clientId, String clientSecret) {
		super(clientId, clientSecret, "https://soundcloud.com/connect", "https://api.soundcloud.com/oauth2/token");
		}

	@Override
	protected AccessGrant createAccessGrant(String accessToken, String scope,
			String refreshToken, Integer expiresIn, Map<String, Object> response) {
		return super.createAccessGrant(accessToken, scope, refreshToken, expiresIn,
				response);
	}

	
	

	
	
	
}
