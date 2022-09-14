package com.tbp.crud.controller;

import java.util.List;

import com.tbp.crud.entity.Textnode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tbp.crud.entity.User;
import com.tbp.crud.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value="addUser",method = RequestMethod.POST)
	public User addUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	//@PostMapping("/addUsers")
	//public List<User> addUsers(@RequestBody List<User> users) {
		//return userService.createUsers(users);
	//}

	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getUsers();
	}
	
	@PutMapping("/updateUser/{id}")
	public User updateUser(@RequestBody User user,@PathVariable String id) {
		return userService.updateUser(user);
	}

	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		return userService.deleteUserById(id);
	}



}
