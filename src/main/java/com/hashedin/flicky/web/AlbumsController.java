package com.hashedin.flicky.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hashedin.flicky.manager.AlbumManager;

@Controller
public class AlbumsController {
	@Autowired
	private AlbumManager db;

	@RequestMapping("/albums/{uid}")
	public ModelAndView albums(@PathVariable String uid) {
		Album album = db.getTheAlbum(uid);
		List<Image> albumImages = new ArrayList<Image>();
		albumImages = album.getListOfImages();
		ImageUpload imageUpload = new ImageUpload();
		imageUpload.setAlbumId(uid);
		imageUpload.setImageList(albumImages);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("albumImages", imageUpload);
		ModelAndView modelAndView = new ModelAndView("albums", model);
		return modelAndView;
	}

	@RequestMapping(value = "/album")
	public ModelAndView add(String name, String description) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("albumImages", null);
		ModelAndView modelAndView = new ModelAndView("createalbum", model);
		return modelAndView;
	}

	@RequestMapping(value = "/createalbum", method = RequestMethod.POST)
	public String createAlbum(@RequestParam("name") String name,
			@RequestParam("description") String description) throws IOException {
		Album album = db.createAlbum(name, description);
		String albumId = album.getUid();
		return "redirect:/upload/" + albumId;
	}
	@RequestMapping("/sidebar")
	public ModelAndView recentImages() {
		//List<Image> recentImages = new ArrayList<Image>();
		List<Image> imageList = db.getRecentImages();
		List<Image> recentImageList = new ArrayList<Image>();
		int size = imageList.size();
		System.out.println(size);
		int i= (size<=3)?0:size-3;
		int j=i;
		System.out.println(i);
		for(j=size-1;j>=i;j--){
			Image image=imageList.get(j);
			recentImageList.add(image);
		}
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("recentImages", recentImageList);
		ModelAndView modelAndView = new ModelAndView("sidebar", model);
		return modelAndView;
	}
}
