package com.hashedin.flicky.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hashedin.flicky.manager.AlbumManager;

@Controller
public class HomeController {
	@Autowired
	private AlbumManager db;
	
	@RequestMapping("/")	
	public ModelAndView albums(){
//		ApplicationContext context = new AnnotationConfigWebApplicationContext();
//		context.getBean("");
		
         Album album=db.createAlbum("LEH", "Grt Journey");
         List<Image> listOfImage=new ArrayList<Image>();
		Image image1=new Image();
		image1.setName("1.jpg");
		image1.setDate("2012-2-31");
		image1.setId("1");
		image1.setAlbum(album);
		listOfImage.add(image1);
	//	image1.setPrevious();
		image1=new Image();
		image1.setName("2.jpg");
		image1.setDate("2012-2-31");
		image1.setId("2");
		image1.setAlbum(album);
		listOfImage.add(image1);
		album.setListOfImages(listOfImage);
		Map<String, Album> albumList = db.getAlbums();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("album", albumList);
		ModelAndView modelAndView = new ModelAndView("home", model);
		return modelAndView;
	}

}
