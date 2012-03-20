package org.springframework.social.soundcloud.api.impl.json;



import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Annotated mixin to add Jackson annotations to SoundCloudProfile. 
 * @author Michael Lavelle
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class SoundCloudProfileMixin {

	
	@JsonCreator
	SoundCloudProfileMixin(
			@JsonProperty("id") String id, 
			@JsonProperty("username") String username, 
			@JsonProperty("avatar_url") String avatarUrl, 
			@JsonProperty("permalink_url") String permalinkUrl, 
			@JsonProperty("full_name") String fullName, 
			@JsonProperty("uri") String uri, 
			@JsonProperty("city") String city) {} 
	
	
	@JsonProperty("public_favorites_count")
	void setFavoritesCount(int favoritesCount) {}
	
	@JsonProperty("track_count")
	void setTrackCount(int trackCount) {}
	
}
