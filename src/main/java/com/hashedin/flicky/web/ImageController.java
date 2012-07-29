/**
 * 
 */
package com.hashedin.flicky.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author somit
 *
 */
@Controller
public class ImageController {
		
	@RequestMapping("/image/{image}")	
	public ModelAndView albums(@PathVariable Image image){
	//	System.out.println(uid+" "+image);
//		Image image1=new Image();
//		image1.setDate("2012-2-3");
//		image1.setId(5);
		//image.addComments("bakwas");
		//image.addComments("sahi bole be");
//		image1.setName("3.jpg");
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("singleImage",image);
		ModelAndView modelAndView = new ModelAndView("images", model);
		return modelAndView;
	}

    @RequestMapping(value="/upload/{uid}")
    public ModelAndView add (String uid) {
 		ModelAndView modelAndView = new ModelAndView("upload", null);
 		return modelAndView;
     }
     @RequestMapping(value = "/fileupload", method = RequestMethod.POST)
     public String handleFormUpload(@RequestParam("name") String name,
         @RequestParam("file") MultipartFile file) throws IOException {
    	 String filePath = "/home/somit/apps/" + file.getOriginalFilename(); 
    	 File dest = new File(filePath);  
    	 file.transferTo(dest); 
         if (!file.isEmpty()) {
             byte[] bytes = file.getBytes();
             System.out.println(file.getOriginalFilename());
            return "redirect:uploadSuccess";
        } else {
            return "redirect:uploadFailure";
        }
     }
}
