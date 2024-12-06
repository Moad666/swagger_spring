package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/save")
	public void save(@RequestBody User user) {
		System.out.println("Received User: " + user.getFullName());
		userService.save(user);
	}
	
	@GetMapping("/all")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public Optional<User> findById(@PathVariable Long id){
		return userService.findById(id);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable Long id) {
		userService.deleteById(id);
	}
	
}
