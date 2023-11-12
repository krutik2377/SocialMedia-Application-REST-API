package com.SMARA.restAPIs.SMARESTAPI.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

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
		User user = service.findUserbyId(Id);
		
		if(user==null)
			throw new UserNotFountException("id:" + Id);
		
		return service.findUserbyId(Id);
	}
	
	@DeleteMapping("/users/{Id}")
	public void deleteUser(@PathVariable int Id)
	{
		service.deleteById(Id);
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> creatUser(@Valid @RequestBody User user)
	{
		User savedUser = service.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		// Location header :- URL location /users/4
		return ResponseEntity.created(location ).build();
	}
}
