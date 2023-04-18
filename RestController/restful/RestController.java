package com.avokey.jblog.controller;

import com.avokey.jblog.domain.User;

import lombok.Builder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {	

	@GetMapping("/jblog")
	public User httpGet() {
		User findUser = User.builder()
				.id(1)
				.username("John")
				.password("1234")
				.email("test@gmail.com")
				.build();		
		return findUser;
	}
	
	@PostMapping("/jblog")
	public String httpPost(User user) {
		return "Post Response: " + user.toString();
	}
	
	@PutMapping("/jblog")
	public String httpPut() {
		return "Put Response.";
	}
	
	@DeleteMapping("/jblog")
	public String httpDelete() {
		return "Delete Response.";
	}
	
	@PostMapping("/jblog/json")
	public String httpPostJson(@RequestBody User user) {
		return "Post Response in Json: " + user.toString();
	}
	
	@PutMapping("/jblog/json")
	public String httpPutJson(@RequestBody User user) {
		return "Put Response in Json: " + user.toString();
	}
	
	@DeleteMapping("/jblog/json")
	public String httpDeleteJson(@RequestParam int id) {
		return "Delete Response in Json: " + id;
	}
	
}
