package com.todo.webApplication.todo.user;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;

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
public class UserControllar {
	
	@Autowired
	private UserDaoService userDaoService;
	
	@RequestMapping(method=RequestMethod.GET,path="/users")
	@SuppressWarnings("unused")
	protected List<user> listAllUsers()
	{
		return userDaoService.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/users/{id}")
	private Resource<user> listOneUser(@PathVariable int id)
	{
		user User = userDaoService.findById(id);
		if(User==null) {
			throw new UserNotFoundException("id not found : " + id);
		}
		
		Resource<user> resource = new Resource<user>(User);
		ControllerLinkBuilder linkto = linkTo(methodOn(this.getClass()).listAllUsers());
		resource.add(linkto.withRel("all users link"));
		return resource;
	}
	
	@RequestMapping(method=RequestMethod.POST,path="/users")
	private ResponseEntity<Object> createUser(@Valid @RequestBody user user) {
		user createdUser = userDaoService.save(user);
		URI location =ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	private void deleteUser(@PathVariable int id) {
		user deleteduser = userDaoService.deleteById(id);
		if(deleteduser==null) {
			throw new UserNotFoundException("id not found : " + id);
		}
	}
}
