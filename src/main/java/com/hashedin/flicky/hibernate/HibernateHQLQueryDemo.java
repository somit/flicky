package com.hashedin.flicky.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hashedin.flicky.manager.AlbumManager;
import com.hashedin.flicky.manager.ImageManager;
import com.hashedin.flicky.web.Album;
import com.hashedin.flicky.web.DatabaseHandler;

public class HibernateHQLQueryDemo {
	
	@Autowired
	private AlbumManager db;
	
	@Autowired
	private ImageManager dbi;
	
	//@Autowired
	//private IDataAccessObject dao;
    //private static Logger s_log = Logger.getLogger(HibernateSaveObjectsDemo.class);
	
	public static void main(String[] args) {
          DatabaseHandler dh = new DatabaseHandler();
          
  ApplicationContext ctx = new GenericXmlApplicationContext("classpath:dao.xml","classpath:hibernate-config.xml");
        IDataAccessObject dao = ctx.getBean(IDataAccessObject.class);
        String uid ="123-1-32";
//        String len = "from Album where uid='"+uid+"'";
//     List<Album> album =   (List<Album>)dao.find(len);
//   System.out.println(album.get(0).getName());
//        String query = "from Album where uid='"+uid+"'";
//		List<Album> temp = (List<Album>)dao.find(query);
//		System.out.println(temp.get(0).getName());
  System.out.println(dh.getAnAlbum(uid).getName());
		
      
}
}
