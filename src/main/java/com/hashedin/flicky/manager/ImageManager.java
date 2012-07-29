/**
 * 
 */
package com.hashedin.flicky.manager;

import java.text.SimpleDateFormat;
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
		newImage.setAlbum(album);
		newImage.setDate(creationDate);
		newImage.setDescription(description);
		newImage.setNext(idImage);
		newImage.setPrevious(idImage);
		
		List<Image> imageList=album.getListOfImages();
		//int size=imageList.size();
         if(!imageList.isEmpty()){
        	 Image previousImage=imageList.get(imageList.size()-1);
        	 newImage.setPrevious(previousImage.getId());
        	 previousImage.setNext(idImage);
         }

		images.put(idImage,newImage);
		return newImage;
	}
	
}
