package com.gon.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/v2")
public class TestController {

	@Value("${test}")
	private String test;
	
	private static final Logger log = LoggerFactory.getLogger(TestController.class);
	
	@GetMapping("/test.do")
	public String test(Model model) {
		
		System.out.println("test="+test);
		log.info("test={}","aaa");
		model.addAttribute("test", test);
		return "test"; 
		
	}
	
//	@PostMapping("/upload")
//	public String saveFile(@RequestParam String itemName,
//							@RequestParam MultipartFile file,
//							HttpServletRequest request) {
//		
//		System.out.println("request="+request);
//		System.out.println("file = "+file);
//		
//		if(!file.isEmpty()) {
//			
//		}
//		
//	}
	
	
	
	
}
