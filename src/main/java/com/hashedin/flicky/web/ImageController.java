/**
 * 
 */
package com.hashedin.flicky.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hashedin.flicky.manager.AlbumManager;
import com.hashedin.flicky.manager.ImageManager;
import com.hashedin.flicky.model.Album;
import com.hashedin.flicky.model.Image;

/**
 * @author somit
 * 
 */
@Controller
public class ImageController {
	private static Logger s_log = Logger.getLogger(ImageController.class);

	@Autowired
	private ImageManager dbi;
	
	@Autowired
	private AlbumManager db;

	@RequestMapping("/images/{imageId}")
	public ModelAndView albums(@PathVariable String imageId) {
         Image image = dbi.getImage(imageId);
		List<Image> imageListOfAlbum = new ArrayList<Image>();
		Album album = image.getAlbum();
			imageListOfAlbum = album.getListOfImages();
		int i = 0;
		for (i = 0; i < imageListOfAlbum.size(); i++) {
			Image temp = imageListOfAlbum.get(i);
			if (temp.getId() == image.getId()) {
				break;
			}
		}
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("singleImage", image);
		model.put("prev", getPrevious(i, imageListOfAlbum));
		model.put("next", getNext(i, imageListOfAlbum));
		model.put("album", album);
		ModelAndView modelAndView = new ModelAndView("images", model);
		return modelAndView;
	}

	public Image getPrevious(int i, List<Image> imageListOfAlbum) {
		if (i != 0) {
			return imageListOfAlbum.get(i - 1);
		}
		return imageListOfAlbum.get(i);
	}

	public Image getNext(int i, List<Image> imageListOfAlbum) {
		if (i != imageListOfAlbum.size() - 1) {
			return imageListOfAlbum.get(i + 1);
		}
		return imageListOfAlbum.get(i);
	}

	@RequestMapping(value = "/upload/{uid}")
	public ModelAndView add(@PathVariable String uid) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("albumid", uid);
		ModelAndView modelAndView = new ModelAndView("upload", model);
		return modelAndView;
	}

	@RequestMapping(value = "/fileupload/{uid}", method = RequestMethod.POST)
	public String handleFormUpload(@PathVariable String uid,
			@RequestParam("description") String description,
			@RequestParam("file") MultipartFile file) throws IOException {
		
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("config.properties"));

			// System.out.println(properties.get("path"));
		} catch (IOException e) {
			s_log
					.info("Config.properties not found . "
							+ "Please pull from http://github.com/somithashedin.com and set path paramtere");
		}
		File dir = new File(properties.getProperty("path")+uid);
		dir.mkdir();
		String filePath = properties.getProperty("path")+uid+"/"+ file.getOriginalFilename();
		File dest = new File(filePath);
		file.transferTo(dest);
		String name = file.getOriginalFilename();
		Album album = db.getAnAlbum(uid);
		dbi.createImage(album, name, description);
		return "redirect:/upload/" + uid;
	}

	@RequestMapping(value = "/comments/{imageId}", method = RequestMethod.POST)
	public String addComments(@PathVariable String imageId,
			@RequestParam("comment") String comment) throws IOException {
		dbi.addComment(comment, imageId);
		return "redirect:/images/" + imageId;
	}

}
