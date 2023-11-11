package com.SMARA.restAPIs.SMARESTAPI.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	
	private UserDaoService service;
	
	public UserResource(UserDaoService service)
	{
		this.service = service;
	}
	//GET/users
	@GetMapping("/users")
	public List<User> retriveAllUsers()
	{
		return service.findAll();
	}
	
	//GET/users
	@GetMapping("/users/{Id}")
	public User retriveSpecificUser(@PathVariable int Id)
	{
		return service.findUserbyId(Id);
	}
	
	@PostMapping("/users")
	public void creatUser(@RequestBody User user)
	{
		service.save(user);
	}
}
