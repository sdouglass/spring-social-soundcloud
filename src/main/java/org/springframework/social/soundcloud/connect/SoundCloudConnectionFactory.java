package org.springframework.social.soundcloud.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.soundcloud.api.SoundCloud;

public class SoundCloudConnectionFactory extends OAuth2ConnectionFactory<SoundCloud> {

	public SoundCloudConnectionFactory(String clientId, String clientSecret) {
		super("soundcloud", new SoundCloudServiceProvider(clientId, clientSecret), new SoundCloudAdapter());
	}

}
