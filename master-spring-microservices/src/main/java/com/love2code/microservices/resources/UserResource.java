package com.love2code.microservices.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.love2code.microservices.model.User;
import com.love2code.microservices.services.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
@Slf4j
public class UserResource {
	
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getUsers(){
		log.info("Getting Users :: Controller");
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUsersService());
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		log.info("Creating Users :: Controller");
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUserService(user));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id){
		log.info("Get User By Id " + id);
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByIdService(id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id){
		log.info("Deleting User with id " + id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(userService.deleteUserByIdService(id));
	}
	
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user){
		log.info("Updating User");
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateUserService(user));
	}

}
