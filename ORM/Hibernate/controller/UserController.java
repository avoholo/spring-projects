package com.avokey.orm.controller;

import java.security.PublicKey;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avokey.orm.persistence.UserRepository;
import com.avokey.orm.domain.RoleType;
import com.avokey.orm.domain.User;
import com.avokey.orm.exception.OrmException;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@PutMapping("/User")
	public @ResponseBody String updateUser(@RequestBody User user) {
		User findUser = userRepository.findById(user.getId()).orElseThrow(()->{
			return new OrmException(user.getId() + " does not exist.");
		});
		
		findUser.setUsername(user.getUsername());
		findUser.setPassword(user.getPassword());
		findUser.setEmail(user.getEmail());
		userRepository.save(findUser);
		
		return user + " updated.";
	}
	
	@PostMapping("/User")
	public String insertUser(@RequestBody User user) {
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return user.getUsername() + "회원가입 성공!";
	}
	
	@GetMapping("/User/{id}")
	public @ResponseBody User getUser(@PathVariable int id) {
		
		//User findUser = userRepository.findById(id).get();
		
//		User findUser =
//				userRepository.findById(id).orElseThrow(new Supplier<OrmException>() {
//					@Override
//					public OrmException get() {
//					return new OrmException(id + " does not exist.");
//				}
//			});
		
		User findUser = userRepository.findById(id).orElseThrow(()->{
			return new OrmException(id + " does not exist.");
		});
		
		return findUser;
	}
	
	@DeleteMapping("User/{id}")
	public @ResponseBody String deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
		return "User " + id + " Deleted.";
	}
}
