/**
 * 
 */
package com.hashedin.flicky.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hashedin.flicky.manager.AlbumManager;

/**
 * @author somit
 *
 */
@Controller
public class ImageController {
	
	@Autowired
	private AlbumManager db;
	
	@RequestMapping("/image/{id}")	
	public ModelAndView albums(){
		Map<String, Album> albumList = db.getAlbums();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("album", albumList);
		ModelAndView modelAndView = new ModelAndView("images", model);
		return modelAndView;
	}
}
