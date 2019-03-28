package com.pawar.demo.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pawar.demo.exception.DataNotFoundException;
import com.pawar.demo.exception.UserNotFoundException;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDaoService;

	@GetMapping(path = "/users")
	public List<User> retriveAll() {
		
		List<User> allUsers = userDaoService.findAll();
		
		if (allUsers.size() == 0)
			throw new DataNotFoundException("No Data Found");
		
		return allUsers;
	}

	@GetMapping(path = "/users/{id}")
	public Resource<User> retrive(@PathVariable int id) {

		User user = userDaoService.findOne(id);
		
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAll());
		resource.add(linkTo.withRel("all-users"));
		
		if (user == null) 
			throw new UserNotFoundException("id-" + id);
			
		return resource;
	}

	@PostMapping(path = "/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {

		User savedUser = userDaoService.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/users/{id}")
	public void deleteUser(@PathVariable int id) {
		
		if(userDaoService.deleteUserById(id) == null)
			throw new UserNotFoundException("id-" + id);
	}	
}
