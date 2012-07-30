/**
 * 
 */
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

/**
 * @author somit
 *
 */
public class ImageManager {
	private final Map<String, Image> images = new HashMap<String, Image>();
	private List<RecentImages> recentImages = new ArrayList<RecentImages>();
	public Image getImage(String uid) {
		return images.get(uid);
	}

	public Image createImage(Album album, String name, String description) {
		String creationDate = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		UUID id= UUID.randomUUID();
		String idImage = id.toString();
		Image newImage = new Image();
		newImage.setId(idImage);
		newImage.setName(name);
		newImage.setDate(creationDate);
		newImage.setDescription(description);
		List<Image> imageList=album.getListOfImages();
		imageList.add(newImage);
		images.put(idImage,newImage);
		addToRecent(album, newImage);
		return newImage;
	}
	private void addToRecent(Album album, Image newImage){
		RecentImages temp= new RecentImages();
		temp.setAlbum(album);
		temp.setImage(newImage);
		recentImages.add(temp);
		int size = recentImages.size();
          if(size>=4)
          {
			List<RecentImages> tempList = new ArrayList<RecentImages>();
			for(int i=size-4;i<size;i++){
			temp=recentImages.get(i);
				tempList.add(temp);
			}
			recentImages=tempList;
		  }
	}

	/**
	 * @return the recentImages
	 */
	public List<RecentImages> getRecentImages() {
		return recentImages;
	}

	/**
	 * @param recentImages the recentImages to set
	 */
	public void setRecentImages(List<RecentImages> recentImages) {
		this.recentImages = recentImages;
	}

	/**
	 * @return the images
	 */
	public Map<String, Image> getImages() {
		return images;
	}

}
