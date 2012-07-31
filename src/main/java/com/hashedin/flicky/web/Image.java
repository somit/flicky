/**
 * 
 */
package com.hashedin.flicky.web;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CollectionOfElements;

/**
 * @author somit
 *
 */

@Entity
public class Image {
	
    @Id
    @GeneratedValue
    private Long imageId;
	
    @ManyToOne
    private Album album;
	private String id;
	private String name;
	private String date;
	private String description;
	
	@CollectionOfElements
	private List<String> comments;
	
	public Image()
	{
		comments = new ArrayList<String>();
		
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
	 * @return the id
	 */
	
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the comments
	 */
	public List<String> getComments() {
		return comments;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	public Long getImageId() {
		return imageId;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public Album getAlbum() {
		return album;
	}

}
