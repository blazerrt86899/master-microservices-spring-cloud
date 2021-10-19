package com.love2code.microservices.resources;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
	private MessageSource messageSource;
	
	@GetMapping("hello")
	public String getHelloWorld(
			@RequestHeader(name = "Accept-Language", required = false
			) Locale locale ){
		log.info("Getting Hello World :: Controller");
		return messageSource.getMessage("good-morning.message", null, "Default Message", LocaleContextHolder.getLocale());
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getUsers(){
		log.info("Getting Users :: Controller");
		return ResponseEntity.status(HttpStatus.OK).
				body(userService.getUsersService());
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@Valid  @RequestBody User user){
		log.info("Creating Users :: Controller");
		return ResponseEntity.status(HttpStatus.CREATED).
				body(userService.createUserService(user));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EntityModel<User>> getUserById(@PathVariable("id") Integer id){
		log.info("Get User By Id :: Controller" + id);
		User userByIdService = userService.getUserByIdService(id);
		EntityModel<User> model = EntityModel.of(userByIdService);
		
		WebMvcLinkBuilder linkToUser = linkTo(methodOn(this.getClass()).getUsers());
		model.add(linkToUser.withRel("get-all-users"));
				
		return ResponseEntity.status(HttpStatus.OK).
				body(model);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id){
		log.info("Deleting User with id " + id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).
				body(userService.deleteUserByIdService(id));
	}
	
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestBody User user){
		log.info("Updating User");
		return ResponseEntity.status(HttpStatus.CREATED).
				body(userService.updateUserService(user));
	}

}
