package com.hashedin.flicky.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeClass {
	private Map<String, Album> album;
	private List<Image> recentImages;

	public HomeClass() {
		album = new HashMap<String, Album>();
		recentImages = new ArrayList<Image>();
	}

	/**
	 * @return the albums
	 */
	public Map<String, Album> getAlbums() {
		return album;
	}

	/**
	 * @return the recentImages
	 */
	public List<Image> getRecentImages() {
		return recentImages;
	}

	public void setAlbums(Map<String, Album> albums) {
		this.album = albums;
	}

	/**
	 * @param recentImages
	 *            the recentImages to set
	 */
	public void setRecentImages(List<Image> recentImages) {
		this.recentImages = recentImages;
	}

}
