package com.hashedin.flicky.web;

import java.util.HashMap;
import java.util.Map;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hashedin.flicky.manager.AlbumManager;
import com.hashedin.flicky.manager.ImageManager;
import com.hashedin.flicky.model.Album;

@Controller
public class DeleteAlbumImage {
	
	
	@Autowired
	private AlbumManager db;

	@Autowired
	private ImageManager dbi;

	@RequestMapping(value = "/albums/delete/{uid}" , method = RequestMethod.POST)
	public ModelAndView deleteAlbum(@PathVariable String uid) {
		//DatabaseHandler dh = new DatabaseHandler();
		Album album = db.getAnAlbum(uid);
		//List<Album> album = (List<Album>)dao.find("from Album where uid in('"+uid+"')");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("album", album);
		ModelAndView modelAndView = new ModelAndView("albums", model);
		return modelAndView;
	}


}
