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

import com.hashedin.flicky.hibernate.IDataAccessObject;
import com.hashedin.flicky.manager.AlbumManager;

@Controller
public class AlbumsController {
	@Autowired
	private AlbumManager db;
	
	@Autowired
	private IDataAccessObject dao;

	@RequestMapping("/albums/{uid}")
	public ModelAndView albums(@PathVariable String uid) {
		DatabaseHandler dh = new DatabaseHandler();
		List<Image> albumImages = new ArrayList<Image>();
		albumImages= dh.getImagesFromAnAlbum(uid);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("album", albumImages);
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
		dao.saveOrUpdate(album);
		dao.flush();
		String albumId = album.getUid();
		return "redirect:/upload/" + albumId;
	}

}
