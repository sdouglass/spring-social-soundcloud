package org.springframework.social.soundcloud.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.soundcloud.api.SoundCloud;

/**
* SoundCloud ConnectionFactory implementation.
* @author Michael Lavelle
*/
public class SoundCloudConnectionFactory extends OAuth2ConnectionFactory<SoundCloud> {

	public SoundCloudConnectionFactory(String clientId, String clientSecret) {
		this(clientId,clientSecret,null);
	}
	
	public SoundCloudConnectionFactory(String clientId, String clientSecret,String redirectUri) {
		super("soundcloud", new SoundCloudServiceProvider(clientId, clientSecret,redirectUri), new SoundCloudAdapter());
	}

}
