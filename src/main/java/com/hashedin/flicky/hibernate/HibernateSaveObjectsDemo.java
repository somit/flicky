package com.hashedin.flicky.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @see http://docs.jboss.org/hibernate/orm/3.5/reference/en/html/
 * @see http://docs.jboss.org/hibernate/annotations/3.5/reference/en/html_single/ 
 *
 */
public class HibernateSaveObjectsDemo {
    
  //  private static Logger s_log = Logger.getLogger(HibernateSaveObjectsDemo.class);
    
    public static void main(String[] args) {
        
        ApplicationContext ctx = new GenericXmlApplicationContext("classpath:dao.xml","classpath:hibernate-config.xml");
        IDataAccessObject dao = ctx.getBean(IDataAccessObject.class);
        
        // Object Creation
     
//        Person newPerson = new Person();
//        newPerson.setName("Somit");
//        dao.saveOrUpdate(newPerson);
//        
//        Person newPerson1 = new Person();
//        newPerson1.setName("Mohit");
//        dao.saveOrUpdate(newPerson1);
//        
//        Person newPerson2 = new Person();
//        newPerson2.setName("Harshit");
//        dao.saveOrUpdate(newPerson2);
//        // dao.flush();
//         
//        Person newPerson3 = new Person();
//        newPerson3.setName("Anshu");
//        dao.saveOrUpdate(newPerson3);
         //There is no cascade on the association and so need to save it first
//        newPerson.getFriends().add(newPerson1);
//        newPerson.getFriends().add(newPerson2);
//        newPerson.getFriends().add(newPerson3);
  
//        dao.saveOrUpdate(newPerson);
//        
//        newPerson1.getFriends().add(newPerson);
//        newPerson1.getFriends().add(newPerson2);
//        dao.saveOrUpdate(newPerson1);
//        
//        newPerson3.getFriends().add(newPerson);
//        dao.saveOrUpdate(newPerson3);
//        Album album = new Album();
//        album.setOwner(another);
//        
//        album.getMedia().add(new Media());
//        album.getMedia().add(new Media());
//        album.getMedia().add(new Media());
//        
//        // One to many association has a cascade and so media are saved automatically
//        // on saving the album
//        dao.saveOrUpdate(album);
          
        dao.flush();
    }
    
}
