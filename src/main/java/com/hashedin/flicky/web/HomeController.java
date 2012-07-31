package com.hashedin.flicky.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hashedin.flicky.hibernate.IDataAccessObject;

@Controller
public class HomeController {
	private static Logger album_log = Logger.getLogger(HomeController.class);
	
//	@Autowired
//	private AlbumManager db;

//	@Autowired
//	private ImageManager dbi;
	
	@Autowired
	private IDataAccessObject dao;

	//@SuppressWarnings("unchecked")
	@RequestMapping("/")
	public ModelAndView albums() {
		DatabaseHandler dh = new DatabaseHandler();
		album_log.info("Home Page Working");
		List<Album> albumList = dh.getAllAlbums();
		List<Image> recentImageList = new ArrayList<Image>();
		recentImageList = dh.getRecentImages();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("album", albumList);
		model.put("recentImages", recentImageList);
		ModelAndView modelAndView = new ModelAndView("home", model);
		return modelAndView;
	}
}
