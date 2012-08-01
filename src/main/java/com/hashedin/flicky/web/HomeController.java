package com.hashedin.flicky.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hashedin.flicky.manager.AlbumManager;
import com.hashedin.flicky.manager.ImageManager;
import com.hashedin.flicky.model.Album;
import com.hashedin.flicky.model.Image;

@Controller
public class HomeController {
//	private static Logger album_log = Logger.getLogger(HomeController.class);
	
	@Autowired
	private AlbumManager db;

	@Autowired
	private ImageManager dbi;


	//@SuppressWarnings("unchecked")
	@RequestMapping("/")
	public ModelAndView albums() {
		//DatabaseHandler dh = new DatabaseHandler();
	//album_log.info("Home Page Working");
		//	List<Album> albumList = (List<Album>)dao.find("from Album");
		//(List<Image>)dao.find("from Image order by imageId desc limit 5");
		
     	List<Album> albumList = db.getAllAlbums();
		List<Image> recentImageList = dbi.getRecentImages();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("album", albumList);
		model.put("recentImages", recentImageList);
		ModelAndView modelAndView = new ModelAndView("home", model);
		return modelAndView;
	}
}
