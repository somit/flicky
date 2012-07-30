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
	
	@Autowired
	private ImageManager dbi;
	
	@RequestMapping("/images/{albumUid}/{imageId}")	
	public ModelAndView albums(@PathVariable String albumUid, @PathVariable String imageId){
         Image image = dbi.getImage(imageId);
         Album album = db.getAlbum(albumUid);
         List<Image> imageListOfAlbum = album.getListOfImages();
         //ImageView singleImage = new ImageView();
         //setImageView(singleImage,album,image);
         Image previousImage = image;
         Image nextImage = image;
 		for(int i=0;i<imageListOfAlbum.size();i++){
			Image temp = imageListOfAlbum.get(i);
			if(temp.getId() == image.getId()){
				break;
			}
			if(i!=0){
				temp = imageListOfAlbum.get(i-1);
				previousImage = temp;
			}
			if(i!= imageListOfAlbum.size()){
				temp = imageListOfAlbum.get(i+1);
				nextImage = temp;
			}
			
		}
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("singleImage",image);
		model.put("prev",previousImage);
		model.put("next",nextImage);
		model.put("album", album);
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
    	//File dir = new File(properties.getProperty("path")+uid);  
    //	dir.mkdir();
    	String filePath=properties.getProperty("path")+file.getOriginalFilename();
    	 File dest = new File(filePath); 
    	 file.transferTo(dest); 
    	 String name=file.getOriginalFilename();
    	  Album album=db.getAlbum(uid);
    	  dbi.createImage(album, name, description);
            return "redirect:/upload/"+uid;
     }
     
     @RequestMapping(value = "/comments/{albumUid}/{imageId}", method = RequestMethod.POST)
     public String addComments(@PathVariable String albumUid,@PathVariable String imageId, @RequestParam("comment")String comment) throws IOException {
    	  
    	 
    	 Image image = dbi.getImage(imageId);
    	 List<String> comments= new ArrayList<String>();
    	 comments=image.getComments();
     	 comments.add(comment);
     	 String path=albumUid+"/"+imageId;
         return "redirect:/images/"+path;
     }
     
}
