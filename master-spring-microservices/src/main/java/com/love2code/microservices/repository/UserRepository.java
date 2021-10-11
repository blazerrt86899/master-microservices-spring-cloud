package com.love2code.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.love2code.microservices.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
