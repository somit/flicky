package com.hashedin.flicky.manager;

import com.hashedin.flicky.web.Album;
import com.hashedin.flicky.web.Image;

public class RecentImages {
	private Image image;
	private Album album;
	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}
	/**
	 * @return the album
	 */
	public Album getAlbum() {
		return album;
	}
	/**
	 * @param album the album to set
	 */
	public void setAlbum(Album album) {
		this.album = album;
	}
	

}
