package com.love2code.microservices.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.love2code.microservices.model.User;
import com.love2code.microservices.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	private UserRepository userRepository;
	
	public List<User> getUsersService() {
		return userRepository.findAll();
	}

	public User createUserService(User user) {
		user.setBirthDate(new Date());
		return userRepository.save(user);
	}

	public User getUserByIdService(Integer id) {
		return userRepository.findById(id).orElse(new User());
	}

	public String deleteUserByIdService(Integer id) {
		userRepository.deleteById(id);
		return "User Deleted with id " + id;
	}

	public User updateUserService(User user) {
		user.setBirthDate(new Date());
		return userRepository.save(user);
	}

}
