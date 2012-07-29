package com.hashedin.flicky.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hashedin.flicky.manager.AlbumManager;

@Controller
public class AlbumsController {
	@Autowired
	private AlbumManager db;

	@RequestMapping("/albums/{uid}")	
	public ModelAndView albums(@PathVariable String uid){
		//Map<String, Album> album = db.getAlbums();

	//		List<Image> listImages= album.getListOfImages();
//		Image image = new Image();
//		image.setDate("2012-2-3");
//		image.setId(1);
//		image.setName("1.jpg");
//		albumSearch.addImagetoList(image);
//		
//		image = new Image();
//		image.setDate("2012-2-4");
//		image.setId(2);
//		image.setName("2.jpg");
//		albumSearch.addImagetoList(image);
//		
//		image = new Image();
//		image.setDate("2012-2-3");
//		image.setId(3);
//		image.setName("3.jpg");
//		albumSearch.addImagetoList(image);
//	
//		
//		image = new Image();
//		image.setDate("2012-2-3");
//		image.setId(4);
//		image.setName("4.jpg");
//		albumSearch.addImagetoList(image);
//		
//		image = new Image();
//		image.setDate("2012-2-3");
//		image.setId(5);
//		image.setName("5.jpg");
//		albumSearch.addImagetoList(image);

//		List<Integer> listImages=new ArrayList<Integer>();
//		listImages.add(1);
//		listImages.add(2);
//		listImages.add(3);
//		listImages.add(4);
//		listImages.add(5);
//		listImages.add(6);
		//String[] listOfImages= {"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg"};
		//List<Image> listOfImages= new ArrayList<Image>();
		//listOfImages=album.getListOfImages();
		System.out.println(uid);
		Album album=db.getTheAlbum(uid);
		Map<String, Object> model = new HashMap<String, Object>();
	      model.put("albumImages", album.getListOfImages());
		ModelAndView modelAndView = new ModelAndView("albums", model);
		return modelAndView;
	}
	
    @RequestMapping(value="/albums", method = RequestMethod.GET)
   public ModelAndView add (String name,String description) {
    	Map<String, Object> model = new HashMap<String, Object>();
		model.put("albumImages", null);
		ModelAndView modelAndView = new ModelAndView("upload", model);
		return modelAndView;
//    	System.out.println("asdasd");
//    	System.out.println(name+"   "+description);
////        if (result.hasErrors()) {
////            return "/albums
////        }
////       // appointmentBook.addAppointment(appointment);
////        return "redirect:/albums/";
//    	Map<String, Object> model = new HashMap<String, Object>();
//		model.put("albumImages", null);
//		ModelAndView modelAndView = new ModelAndView("upload", model);
//		return modelAndView;
//    }
    }
}
	


