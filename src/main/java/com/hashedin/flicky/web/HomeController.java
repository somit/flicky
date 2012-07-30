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

import com.hashedin.flicky.manager.AlbumManager;
import com.hashedin.flicky.manager.ImageManager;
import com.hashedin.flicky.manager.RecentImages;

@Controller
public class HomeController {
	private static Logger album_log = Logger.getLogger(HomeController.class);
	@Autowired
	private AlbumManager db;
	
	@Autowired
	private ImageManager dbi;

	@RequestMapping("/")
	public ModelAndView albums() {
		album_log.info("Home Page started");
		Map<String, Album> albumList = db.getAlbums();
		List<RecentImages> reverseRecentImageList = dbi.getRecentImages();
		List<RecentImages> recentImageList=new ArrayList<RecentImages>();
		for(int i=reverseRecentImageList.size()-1;i>=0;i--){
			recentImageList.add(reverseRecentImageList.get(i));
		}
		if(recentImageList.size()==0){
		album_log.info("No images in the albums");
		}
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("album", albumList);
		model.put("recentImages", recentImageList);
		ModelAndView modelAndView = new ModelAndView("home", model);
		return modelAndView;
	}
}
