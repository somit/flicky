package com.hashedin.flicky.web;

import java.util.HashMap;
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
	public ModelAndView albums() {
		Map<String, Album> albumList = db.getAlbums();
		// List<Image> recentImageList=new ArrayList<Image>();
		// recentImageList=getRecent();
		// HomeClass modelHome=new HomeClass();
		// modelHome.setRecentImages(recentImageList);
		// modelHome.setAlbums(albumList);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("album", albumList);
		ModelAndView modelAndView = new ModelAndView("home", model);
		return modelAndView;
	}

}
