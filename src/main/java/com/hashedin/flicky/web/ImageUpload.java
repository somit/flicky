package com.hashedin.flicky.web;

import java.util.ArrayList;
import java.util.List;

public class ImageUpload { 
	private String albumId;
	private List<Image> imageList;
	public ImageUpload(){
		imageList=new ArrayList<Image>();
	}
	/**
	 * @return the albumId
	 */
	public String getAlbumId() {
		return albumId;
	}
	/**
	 * @param albumId the albumId to set
	 */
	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}
	/**
	 * @return the imageList
	 */
	public List<Image> getImageList() {
		return imageList;
	}
	/**
	 * @param imageList the imageList to set
	 */
	public void setImageList(List<Image> imageList) {
		this.imageList = imageList;
	}

}
