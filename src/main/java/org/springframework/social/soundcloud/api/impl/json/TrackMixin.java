package org.springframework.social.soundcloud.api.impl.json;



import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Annotated mixin to add Jackson annotations to Track. 
 * @author Michael Lavelle
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class TrackMixin {

	
	@JsonCreator
	TrackMixin(
			@JsonProperty("permalink_url") String permalinkUrl, 
			@JsonProperty("title") String title,@JsonProperty("id") String id) {} 
	
	
}
