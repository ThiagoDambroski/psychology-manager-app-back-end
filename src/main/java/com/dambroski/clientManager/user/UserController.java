package com.dambroski.clientManager.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	UserService service;
	
	@GetMapping("/getAll")
	public List<User> getAll() {
		return service.getAll();
	}
	
	@PostMapping("/post")
	public User postUser(@RequestBody User user) {
		return service.post(user);
	}
	
	@PutMapping("/put/{userId}")
	public User putUser(@RequestBody User user, @PathVariable("userId") Long userId) {
		return service.put(user,userId);
	}

}
