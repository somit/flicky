package com.hashedin.flicky.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hashedin.flicky.hibernate.IDataAccessObject;

public class DatabaseHandler {

	@Autowired
	private IDataAccessObject dao;

	@SuppressWarnings("unchecked")
	public List<Image> getRecentImages() {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:dao.xml","classpath:hibernate-config.xml");
        IDataAccessObject dao1 = ctx.getBean(IDataAccessObject.class);
		return (List<Image>) dao
				.find("FROM Image ORDER BY date");
	}

	@SuppressWarnings("unchecked")
	public List<Image> getAllImages() {
		return (List<Image>) dao.find("FROM Image");
	}

	@SuppressWarnings("unchecked")
	public Image getImage(String id) {
		return ((List<Image>) dao.find("FROM Image where id='" + id + "'"))
				.get(0);

	}
	@SuppressWarnings("unchecked")
	public List<Album> getAllAlbums() {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:dao.xml","classpath:hibernate-config.xml");
        IDataAccessObject dao = ctx.getBean(IDataAccessObject.class);
		List<Album> albums = new ArrayList<Album>();
		albums = (List<Album>)dao.find("from Album");
	return albums;
      }

	@SuppressWarnings("unchecked")
	public List<Image> getImagesFromAnAlbum(String uid){
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:dao.xml","classpath:hibernate-config.xml");
        IDataAccessObject dao1 = ctx.getBean(IDataAccessObject.class);
    	return (List<Image>)dao.find("Select listOfImages from Album where uid ='"+uid+"'");
    }
	
	@SuppressWarnings("unchecked")
	public Album getAnAlbum(String uid){
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:dao.xml","classpath:hibernate-config.xml");
        IDataAccessObject dao = ctx.getBean(IDataAccessObject.class);
		String query = "from Album where uid='"+uid+"'";
		List<Album> temp = (List<Album>)dao.find(query);
		return temp.get(0);
	}

    
}
