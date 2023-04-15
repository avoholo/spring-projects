package com.avokey.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/htmlmapping")
	public String html() {
		System.out.println("HTML Files requested.");
		return "redirect:hello.html";
	}
	
	@GetMapping("/puppy")
	public String puppy() {
		System.out.println("Puppy Image requested.");
		return "redirect:image/puppy.jpeg";
	}
	
	@GetMapping("/jsp")
	public String jsp(Model model) {
		model.addAttribute("username", "John");
		return "hellos";
	}

}
