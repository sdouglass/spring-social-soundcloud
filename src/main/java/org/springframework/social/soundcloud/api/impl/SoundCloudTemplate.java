package org.springframework.social.soundcloud.api.impl;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.soundcloud.api.SoundCloud;
import org.springframework.social.soundcloud.api.UserOperations;
import org.springframework.social.soundcloud.api.impl.json.SoundCloudModule;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.web.client.RestTemplate;

public class SoundCloudTemplate extends AbstractOAuth2ApiBinding implements
		SoundCloud {

	private UserOperations userOperations;

	private ObjectMapper objectMapper;

	/**
	 * Create a new instance of SoundCloudTemplate. This constructor creates a
	 * new SoundCloudTemplate able to perform unauthenticated operations against
	 * SoundCloud's API. Some operations do not require OAuth authentication.
	 * For example, retrieving a specified user's profile or feed does not
	 * require authentication . A SoundCloudTemplate created with this
	 * constructor will support those operations. Those operations requiring
	 * authentication will throw {@link NotAuthorizedException}.
	 */
	public SoundCloudTemplate() {
		initialize(null);
	}

	/**
	 * Create a new instance of FacebookTemplate. This constructor creates the
	 * FacebookTemplate using a given access token.
	 * 
	 * @param accessToken
	 *            An access token given by Facebook after a successful OAuth 2
	 *            authentication (or through Facebook's JS library).
	 */
	public SoundCloudTemplate(String accessToken) {
		super(accessToken);
		System.out.println("MY ACCESS TOKEN IS:" + accessToken);
		initialize(accessToken);
	}
	
	
	@Override
	protected List<HttpMessageConverter<?>> getMessageConverters() {
	List<HttpMessageConverter<?>> messageConverters = super.getMessageConverters();
	messageConverters.add(new ByteArrayHttpMessageConverter());
	return messageConverters;
	}

	@Override
	public UserOperations userOperations() {
		return userOperations;
	}

	private void initSubApis(String accessToken) {
		userOperations = new UserTemplate(getRestTemplate(),accessToken,isAuthorized());

	}

	// private helpers
	private void initialize(String accessToken) {
		registerSoundCloudJsonModule(getRestTemplate());
		getRestTemplate().setErrorHandler(new SoundCloudErrorHandler());
		// Wrap the request factory with a BufferingClientHttpRequestFactory so
		// that the error handler can do repeat reads on the response.getBody()
		super.setRequestFactory(ClientHttpRequestFactorySelector
				.bufferRequests(getRestTemplate().getRequestFactory()));
		initSubApis(accessToken);
	}

	private void registerSoundCloudJsonModule(RestTemplate restTemplate2) {
		objectMapper = new ObjectMapper();
		objectMapper.registerModule(new SoundCloudModule());
		List<HttpMessageConverter<?>> converters = getRestTemplate()
				.getMessageConverters();
		for (HttpMessageConverter<?> converter : converters) {
			if (converter instanceof MappingJacksonHttpMessageConverter) {
				MappingJacksonHttpMessageConverter jsonConverter = (MappingJacksonHttpMessageConverter) converter;
				jsonConverter.setObjectMapper(objectMapper);
			}
		}
	}

}
