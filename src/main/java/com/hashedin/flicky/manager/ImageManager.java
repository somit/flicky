/**
 * 
 */
package com.hashedin.flicky.manager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import com.hashedin.flicky.web.Album;
import com.hashedin.flicky.web.Image;

/**
 * @author somit
 * 
 */
public class ImageManager{
	public Image createImage(Album album, String name, String description) {
		String creationDate = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		UUID id = UUID.randomUUID();
		String idImage = id.toString();
		Image newImage = new Image();
		newImage.setId(idImage);
		newImage.setName(name);
		newImage.setDate(creationDate);
		newImage.setDescription(description);
		return newImage;
	}

//   @SuppressWarnings("unchecked")
//   public List<Image> getRecentImages(){
//	   return (List<Image>)dao.find("FROM Image ORDER BY creationDate LIMIT 5");
//   }
//
// 
//	@SuppressWarnings("unchecked")
//	public List<Image> getAllImages() {
//		return (List<Image>)dao.find("FROM Image");
//	}
//    
//	@SuppressWarnings("unchecked")
//	public Image getImage(String id){
//		return ((List<Image>)dao.find("FROM Image where id='"+id+"'")).get(0);
//		
//	}
}
