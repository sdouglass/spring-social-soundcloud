package org.springframework.social.soundcloud.api.impl.json;


import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;
import org.springframework.social.soundcloud.api.SoundCloudProfile;
import org.springframework.social.soundcloud.api.Track;


/**
 * Jackson module for setting up mixin annotations on SoundCloud model types. This enables the use of Jackson annotations without
 * directly annotating the model classes themselves.
 * @author Michael Lavelle
 */
public class SoundCloudModule extends SimpleModule {

	public SoundCloudModule() {
		super("SoundCloudModule", new Version(1, 0, 0, null));
	}
	
	@Override
	public void setupModule(SetupContext context) {
		context.setMixInAnnotations(SoundCloudProfile.class, SoundCloudProfileMixin.class);
		context.setMixInAnnotations(Track.class, TrackMixin.class);

		
	}
}
