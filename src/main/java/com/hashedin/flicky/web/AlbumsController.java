package com.hashedin.flicky.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlbumsController {

	//private Database db;
	@RequestMapping("/albums/{id}")	
	public ModelAndView albums(String id) {
		Album album = getAlbum(id);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("album", album);
		
		ModelAndView modelAndView = new ModelAndView("albums", model);
		return modelAndView;
	}

	private Album getAlbum(String id) {
		// TODO Read from Database
		Album a = new Album();
		a.setID(id);
		a.setName("Leh Photos");
		a.setDescription("Photos shot during my Leh visit in 2010");
		return a;
	}
}
