package com.hashedin.flicky.manager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hashedin.flicky.hibernate.IDataAccessObject;
import com.hashedin.flicky.model.Album;
import com.hashedin.flicky.model.Image;

@Service
public class AlbumManager {

	@Autowired
	private IDataAccessObject dao;

	public Album createAlbum(String name, String description) {
		Album album = new Album();
		Calendar timestamp = Calendar.getInstance();
		album.setTimestamp(timestamp);
		String creationDate = new SimpleDateFormat("dd/MM/yyyy").format(timestamp.getTime());
		album.setCreationDate(creationDate);
		UUID uid = UUID.randomUUID();
		String uidAlbum = uid.toString();
		album.setUid(uidAlbum);
		album.setName(name);
		album.setDescription(description);
		dao.saveOrUpdate(album);
		dao.flush();
		return album;
	}
	
	@SuppressWarnings("unchecked")
	public List<Album> getAllAlbums() {
		List<Album> albums = new ArrayList<Album>();
		albums = (List<Album>)dao.find("from Album");
	return albums;
      }

	@SuppressWarnings("unchecked")
	public List<Image> getImagesFromAnAlbum(String uid){
    	return (List<Image>)dao.find("Select listOfImages from Album where uid ='"+uid+"'");
    }
	
	@SuppressWarnings("unchecked")
	public Album getAnAlbum(String uid){
		List<Album> temp = (List<Album>)dao.find("from Album where uid='"+uid+"'");
		return temp.get(0);
	}
} 
