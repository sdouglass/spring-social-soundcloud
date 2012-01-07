package org.springframework.social.soundcloud.api;

import java.util.List;

public interface TracksOperations {
	
	public List<Track> search(String query);

}
