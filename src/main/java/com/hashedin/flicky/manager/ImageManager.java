/**
 * 
 */
package com.hashedin.flicky.manager;

import java.io.IOError;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hashedin.flicky.hibernate.IDataAccessObject;
import com.hashedin.flicky.model.Album;
import com.hashedin.flicky.model.Image;
import com.hashedin.flicky.web.ImageController;

/**
 * @author somit
 * 
 */
@Service
public class ImageManager {

	@Autowired
	private IDataAccessObject dao;

	private static Logger s_log = Logger.getLogger(ImageController.class);

	public Image createImage(Album album, String name, String description) {
		Image newImage = new Image();
		Calendar timestamp = Calendar.getInstance();
		newImage.setTimestamp(timestamp);
		String creationDate = new SimpleDateFormat("dd/MM/yyyy")
				.format(timestamp.getTime());
		newImage.setDate(creationDate);
		UUID id = UUID.randomUUID();
		String idImage = id.toString();
		newImage.setId(idImage);
		newImage.setName(name);
		newImage.setAlbum(album);
		newImage.setDescription(description);
		String uid = album.getUid();
		List<Album> albums = (List<Album>)dao.find("from Album where uid in('"+uid+"')");
		albums.get(0).getListOfImages().add(newImage);
		try {
			dao.saveOrUpdate(newImage);
			dao.saveOrUpdate(albums.get(0));
			dao.flush();
			s_log.info(" Image upload successful");
		} catch (IOError e) {
			s_log.warn(" Image upload have failed");
		}
		return newImage;
	}

	@SuppressWarnings("unchecked")
	public List<Image> getRecentImages() {
		List<Image> query = (List<Image>) dao
				.find("from Image order by timestamp");
		int size = query.size();
		List<Image> list = new ArrayList<Image>();
		if (size >= 4) {
			list = query.subList(0, 4);
		}else {
			list = query;
		}
		return list;

	}

	@SuppressWarnings("unchecked")
	public List<Image> getAllImages() {
		return (List<Image>) dao.find("FROM Image");
	}

	@SuppressWarnings("unchecked")
	public Image getImage(String id) {
		return (((List<Image>) dao.find("FROM Image where id='" + id + "'")).get(0));
	}
	
	public void addComment(String comment , String id){
		Image image = getImage(id);
		image.getComments().add(comment);
		dao.saveOrUpdate(image);
		dao.flush();
	}
}
