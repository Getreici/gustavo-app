package com.gustavo.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.web.model.User;
import com.gustavo.web.repository.UserRepository;

@Service("userService")
public class UserService {
@Autowired
private UserRepository userRepository;

public List<User> findAll(){
	return userRepository.findAll();
}

public User findById(final Integer id){
	return userRepository.findByidUser(id);
}
}
