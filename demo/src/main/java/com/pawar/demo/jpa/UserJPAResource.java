package com.pawar.demo.jpa;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
import com.pawar.demo.user.User;

@RestController
public class UserJPAResource {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@GetMapping(path = "/jpa/users")
	public List<User> retriveAll() {
		
		List<User> allUsers = userRepository.findAll();
		
		if (allUsers.size() == 0)
			throw new DataNotFoundException("No Data Found");
		
		return allUsers;
	}

	@GetMapping(path = "/jpa/users/{id}")
	public Resource<User> retrive(@PathVariable int id) {

		Optional<User> user = userRepository.findById(id);
		
		if (!user.isPresent()) 
			throw new UserNotFoundException("id-" + id);
		
		Resource<User> resource = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAll());
		resource.add(linkTo.withRel("all-users"));
			
		return resource;
	}

	@PostMapping(path = "/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {

		User savedUser = userRepository.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		
		userRepository.deleteById(id);

	}	
	
	@GetMapping(path = "/jpa/users/{id}/posts")
	public List<Post> retriveUsersPost(@PathVariable Integer id) {
		
		Optional<User> userOptinal = userRepository.findById(id);
		
		if (!userOptinal.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		
		return userOptinal.get().getPosts();
	}
	
	
	@PostMapping(path = "/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostForUser(@PathVariable Integer id,@RequestBody Post post) {
		
		Optional<User> optinalUser = userRepository.findById(id);
		
		if (!optinalUser.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		
		User user = optinalUser.get();
		
		post.setUser(user);
		
		Post savedPost = postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId()).toUri();
	
		return ResponseEntity.created(location).build();
	}
	
}
