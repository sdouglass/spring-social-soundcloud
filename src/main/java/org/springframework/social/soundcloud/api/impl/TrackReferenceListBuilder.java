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

import java.util.ArrayList;
import java.util.List;

import org.springframework.social.soundcloud.api.TrackReference;

public class TrackReferenceListBuilder {

	private List<TrackReference> tracks;
	
	public TrackReferenceListBuilder(String[] permalinkUrls)
	{
		tracks = new ArrayList<TrackReference>();
		for (String permalinkUrl : permalinkUrls)
		{
			tracks.add(new TrackReference(permalinkUrl));
		}
	}
	
	public TrackReferenceListBuilder(long[] trackIds)
	{
		tracks = new ArrayList<TrackReference>();
		for (long trackId : trackIds)
		{
			tracks.add(new TrackReference(trackId));
		}
	}
	
	public TrackReferenceListBuilder(List<TrackReference> trackReferences)
	{
		tracks = trackReferences;
	}
	
	
	public List<TrackReference> build() {
		return tracks;
	}

}
