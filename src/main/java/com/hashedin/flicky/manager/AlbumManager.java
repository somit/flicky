package com.hashedin.flicky.manager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import com.hashedin.flicky.web.Album;

public class AlbumManager {

	public Album createAlbum(String name, String description) {
		String date = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		UUID uid = UUID.randomUUID();
		String uidAlbum = uid.toString();
		Album album = new Album();
		album.setCreationDate(date);
		album.setUid(uidAlbum);
		album.setName(name);
		album.setDescription(description);
		return album;
	}
	
//	@SuppressWarnings("unchecked")
//	public List<Album> getAllAlbums() {
//		List<Album> albums = new ArrayList<Album>();
//		albums = (List<Album>)dao.find("from Album");
//	return albums;
//      }
//
//	@SuppressWarnings("unchecked")
//	public List<Image> getImagesFromAnAlbum(String uid){
//    	return (List<Image>)dao.find("Select listOfImages from Album where uid ='"+uid+"'");
//    }
//	
//	@SuppressWarnings("unchecked")
//	public Album getAnAlbum(String uid){
//		List<Album> temp = (List<Album>)dao.find("from Album where uid='"+uid+"'");
//		return temp.get(0);
//	}
} 
