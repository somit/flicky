/**
 * 
 */
package com.hashedin.flicky.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.sql.Select;


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
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar timestamp;
	private String description;
	
	@CollectionOfElements (targetElement = String.class, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<String> comments = new ArrayList<String>();
	
	public Image()
	{
		//comments = new ArrayList<String>();
		
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
	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}
	public Calendar getTimestamp() {
		return timestamp;
	}

}
