package com.todo.webApplication.todo.user;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJPAControllar {
	
	@Autowired
	private UserDaoService userDaoService;
	
	@Autowired
	private UserJPARepository userRepository;
	
	@RequestMapping(method=RequestMethod.GET,path="/jpa/users")
	@SuppressWarnings("unused")
	protected List<user> listAllUsers()
	{
		return userRepository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/jpa/users/{id}")
	private Optional<user> listOneUser(@PathVariable int id)
	{
		Optional<user> User = userRepository.findById(id);
		if(User==null) {
			throw new UserNotFoundException("id not found : " + id);
		}
		return User;
	}
	
	@RequestMapping(method=RequestMethod.POST,path="/jpa/users")
	private ResponseEntity<Object> createUser(@Valid @RequestBody user user) {
		user createdUser = userRepository.save(user);
		URI location =ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	private void deleteUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
	}
}
