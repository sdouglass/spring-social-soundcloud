package org.springframework.social.soundcloud.api;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TracksOperations {
	
	public Page<Track> search(String query);
	public Page<Track> search(String query,Pageable pageable);

}
