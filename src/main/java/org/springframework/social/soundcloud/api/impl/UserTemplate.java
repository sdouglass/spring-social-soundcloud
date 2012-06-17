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
package org.springframework.social.soundcloud.api.impl;

import org.springframework.social.soundcloud.api.UserOperations;
import org.springframework.web.client.RestTemplate;

public class UserTemplate extends AbstractUserTemplate implements UserOperations {

	
	public UserTemplate(String clientId,RestTemplate restTemplate, long userId, boolean isAuthorizedForUser) {
		super(clientId,restTemplate, isAuthorizedForUser,true);
		this.userId = userId;
	}
	
	

	private long userId;
 
	@Override
	protected String getUsersResourcePrefix() {
		return  "/users/" + userId;
	}



}
