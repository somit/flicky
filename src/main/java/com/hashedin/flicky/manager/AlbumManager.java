package com.hashedin.flicky.manager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.hashedin.flicky.web.Album;
import com.hashedin.flicky.web.Image;

public class AlbumManager {
	private final Map<String, Album> albums = new HashMap<String, Album>();
	private final Map<String, ImageManager> imageManagerMap = new HashMap<String, ImageManager>();
	private List<Image> recentImages = new ArrayList<Image>();

	public Album getAlbum(String name) {
		Album a = null;
		a = albums.get(name);
		return a;
	}

	public Album createAlbum(String name, String description) {
		String creationDate = new SimpleDateFormat("dd/MM/yyyy")
				.format(Calendar.getInstance().getTime());
		UUID uid = UUID.randomUUID();
		String uidAlbum = uid.toString();
		Album album = new Album();
		album.setUid(uidAlbum);
		album.setName(name);
		album.setDescription(description);
		album.setCreationDate(creationDate);
		albums.put(uidAlbum, album);
		ImageManager imageManager = new ImageManager();
		imageManagerMap.put(uidAlbum, imageManager);
		return album;
	}

	/**
	 * @param albums
	 *            the albums to set
	 * @return
	 */
	public Map<String, Album> getAlbums() {
		return albums;
	}

	public Album getTheAlbum(String uid) {
		return albums.get(uid);
	}

	/**
	 * @return the imageManagerMap
	 */
	public Map<String, ImageManager> getImageManagerMap() {
		return imageManagerMap;
	}

	/**
	 * @return the recentImages
	 */
	public List<Image> getRecentImages() {
		return recentImages;
	}

	/**
	 * @param recentImages
	 *            the recentImages to set
	 */
	public void setRecentImages(List<Image> recentImages) {
		this.recentImages = recentImages;
	}

}
