package com.hashedin.flicky.manager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.hashedin.flicky.web.Album;

public class AlbumManager {
	private final Map<String, Album> albums = new HashMap<String, Album>();
	
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

	public Album getAlbum(String uid) {
		return albums.get(uid);
	}
}
