package org.sixtynine.stock.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.sixtynine.stock.model.FileUploadForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	 @RequestMapping(value = "/show", method = RequestMethod.GET)
	    public String displayForm() {
	        return "file_upload_form";
	    }
	     
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(
	            @ModelAttribute("uploadForm") FileUploadForm uploadForm,
	                    Model map) {
	        
	    	InputStream inputStream = null;  
	    	OutputStream outputStream = null;
	    	  
	        List<MultipartFile> files = uploadForm.getFiles();
	 
	        List<String> fileNames = new ArrayList<String>();
	         
	        if(null != files && files.size() > 0) {
	            for (MultipartFile multipartFile : files) {
	 
	                String fileName = multipartFile.getOriginalFilename();
	                fileNames.add(fileName);
	                //Handle file content - multipartFile.getInputStream()
	                
	                try {  
	                	   inputStream = multipartFile.getInputStream();  
	                	  
	                	   File newFile = new File("D:/CSE_ANALYZER/ANALYZER/upload/" + fileName);  
	                	   if (!newFile.exists()) {  
	                	    newFile.createNewFile();  
	                	   }  
	                	   outputStream = new FileOutputStream(newFile);  
	                	   int read = 0;  
	                	   byte[] bytes = new byte[1024];  
	                	  
	                	   while ((read = inputStream.read(bytes)) != -1) {  
	                	    outputStream.write(bytes, 0, read);  
	                	   }  
	                	  } catch (IOException e) {  
	                	   // TODO Auto-generated catch block  
	                	   e.printStackTrace();  
	                	  }  
	 
	            }
	        }
	         
	        map.addAttribute("files", fileNames);
	        return "file_upload_success";
	  }
	
}
