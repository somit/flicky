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
import com.hashedin.flicky.manager.ImageManager;
import com.hashedin.flicky.manager.RecentImages;

@Controller
public class HomeController {
	@Autowired
	private AlbumManager db;
	
	@Autowired
	private ImageManager dbi;

	@RequestMapping("/")
	public ModelAndView albums() {
		Map<String, Album> albumList = db.getAlbums();
		List<RecentImages> reverseRecentImageList = dbi.getRecentImages();
		List<RecentImages> recentImageList=new ArrayList<RecentImages>();
		for(int i=reverseRecentImageList.size()-1;i>=0;i--){
			recentImageList.add(reverseRecentImageList.get(i));
		}
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("album", albumList);
		model.put("recentImages", recentImageList);
		ModelAndView modelAndView = new ModelAndView("home", model);
		return modelAndView;
	}
}
