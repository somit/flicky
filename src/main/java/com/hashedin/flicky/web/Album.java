package com.hashedin.flicky.web;

import java.util.List;

public class Album {
	private String uid;
	private String name;
	private String description;
	private String creationDate;
	private List<Image> listOfImages;

	/**
	 * @return the name
	 */
	public String getName() {
		
		return name;
		
	}
	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the creationDate
	 */
	public String getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the listOfImages
	 */
	public List<Image> getListOfImages() {
		return listOfImages;
	}
	/**
	 * @param listOfImages the listOfImages to set
	 */
	public void setListOfImages(List<Image> listOfImages) {
		this.listOfImages = listOfImages;
	}
	public void addImagetoList(Image image){
		this.listOfImages.add(image);
	}
}
