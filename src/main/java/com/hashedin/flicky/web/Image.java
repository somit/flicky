/**
 * 
 */
package com.hashedin.flicky.web;

import java.util.ArrayList;
import java.util.List;

/**
 * @author somit
 *
 */
public class Image {
	private String id;
	private String name;
	private String date;
	private List<String> comments;
	private String previous;
	private String next;
	private Album album;
	
	public Image()
	{    previous=null;
	     next=null;
		comments =new ArrayList<String>();
		comments.add("kya bakwas");
		comments.add("bas karo");
	}
	
	/**
	 * @return the previous
	 */
	public String getPrevious() {
		return previous;
	}

	/**
	 * @param previous the previous to set
	 */
	public void setPrevious(String previous) {
		this.previous=previous;
	}

	/**
	 * @return the next
	 */
	public String getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(String next) {
		this.next = next;
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
