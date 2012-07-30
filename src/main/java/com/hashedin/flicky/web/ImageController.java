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

/**
 * @author somit
 *
 */
@Controller
public class ImageController {
	@Autowired
	private AlbumManager db;
	
	@RequestMapping("/images/{albumUid}/{imageId}")	
	public ModelAndView albums(@PathVariable String albumUid, @PathVariable String imageId){
          ImageManager imageManager=db.getImageManagerMap().get(albumUid);
          Image image=imageManager.getImage(imageId);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("singleImage",image);
		ModelAndView modelAndView = new ModelAndView("images", model);
		return modelAndView;
	}

    @RequestMapping(value="/upload/{uid}")
    public ModelAndView add (@PathVariable String uid){
    	Map<String, Object> model = new HashMap<String, Object>();
		model.put("albumid",uid);
 		ModelAndView modelAndView = new ModelAndView("upload", model);
 		return modelAndView;
     }
     @RequestMapping(value = "/fileupload/{uid}", method = RequestMethod.POST)
     public String handleFormUpload(@PathVariable String uid, @RequestParam("description")String description,@RequestParam("file") MultipartFile file) throws IOException {
    	Properties properties=new Properties();
    	try {
    	    properties.load(new FileInputStream("config.properties"));
        	System.out.println(properties.get("path"));
    	} catch (IOException e) {
    	}
    	String filePath=properties.getProperty("path")+file.getOriginalFilename();
    	 File dest = new File(filePath); 
    	 file.transferTo(dest); 
    	 String name=file.getOriginalFilename();
    	 ImageManager imageManager=db.getImageManagerMap().get(uid);
    	 Album album=db.getTheAlbum(uid);
    	  Image newImage=imageManager.createImage(album, name, description);
    	  List<Image> recent = db.getRecentImages();
    	  recent.add(newImage);
    	  album.getListOfImages().add(newImage);
         if (newImage!=null) {
            return "redirect:/upload/"+uid;
        } else {
            return "redirect:/upload/"+uid;
        }
     }
     
     @RequestMapping(value = "/comments/{albumUid}/{imageId}", method = RequestMethod.POST)
     public String addComments(@PathVariable String albumUid,@PathVariable String imageId, @RequestParam("comment")String comment) throws IOException {
    	
    	 ImageManager imageManager=db.getImageManagerMap().get(albumUid);
    	 Image image = imageManager.getImage(imageId);
    	 List<String> comments= new ArrayList<String>();
    	 comments=image.getComments();
     	 comments.add(comment);
     	 String path=albumUid+"/"+imageId;
         return "redirect:/images/"+path;
     }
     
}
