package com.hashedin.flicky.web;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Album {
    @Id
    @GeneratedValue
    private Long albumId;
 
	private String uid;
	private String name;
	private String description;
	private String creationDate;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Image> listOfImages;
	public Album(){
		listOfImages=new ArrayList<Image>();
	}
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
	public void addImageToList(Image image){
		this.listOfImages.add(image);
	}
	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}
	public Long getAlbumId() {
		return albumId;
	}
}
