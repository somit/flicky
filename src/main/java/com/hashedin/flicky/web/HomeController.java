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
		Map<String, Album> albumList = db.getAlbums();
//		List<Image> recentImageList=new ArrayList<Image>();
//		recentImageList=getRecent();
//		HomeClass modelHome=new HomeClass();
//		modelHome.setRecentImages(recentImageList);
//		modelHome.setAlbums(albumList);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("album", albumList);
		ModelAndView modelAndView = new ModelAndView("home", model);
		return modelAndView;
	}
	@RequestMapping("/sidebar")
	public ModelAndView recentImages(){
		List<Image> recentImages= new ArrayList<Image>();
          recentImages=getRecent();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("recentimages",recentImages);
		ModelAndView modelAndView = new ModelAndView("sidebar", model);
		return modelAndView;
	}
	public List<Image> getRecent()
	{
		List<Image> recentImages= db.getRecentImages();
        List<Image> recentImageList=new ArrayList<Image>();
        int size= recentImages.size();
        int j=1;
        while(j<4 && size!=0){
       	 recentImageList.add(recentImages.get(size-j));
       	 j++;
        }
		return recentImageList;
		
	}
}
