package org.springframework.social.soundcloud.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.soundcloud.api.SoundCloud;
import org.springframework.social.soundcloud.api.impl.SoundCloudTemplate;

public class SoundCloudServiceProvider extends AbstractOAuth2ServiceProvider<SoundCloud>{


	
	public SoundCloudServiceProvider(String clientId, String clientSecret) {
		super(new SoundCloudOAuth2Template(clientId, clientSecret));
		}

	@Override
	public SoundCloud getApi(String accessToken) {
		return new SoundCloudTemplate(accessToken);
	}

}
