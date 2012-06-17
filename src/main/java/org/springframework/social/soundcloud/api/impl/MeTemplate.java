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

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.social.soundcloud.api.Activity;
import org.springframework.social.soundcloud.api.MeOperations;
import org.springframework.social.soundcloud.api.impl.json.ActivityList;
import org.springframework.web.client.RestTemplate;

public class MeTemplate extends AbstractUserTemplate implements MeOperations {

	public MeTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(null,restTemplate, isAuthorizedForUser,false);
	}

	@Override
	protected String getUsersResourcePrefix() {
		return "/me";
	}


	@Override
	public Page<Activity> getActivities() {
		return getActivities(null);
	}
	
	@Override
	public Page<Activity> getActivities(Pageable pageable) {

		requireAuthorization();
		
		List<Activity> activities =  restTemplate.getForObject(getApiResourceUrl("/activities",pageable), ActivityList.class).getActivities();		
		 return new PageImpl<Activity>(activities,pageable,activities.size());
		
		 
		 
	}


	

	

}
