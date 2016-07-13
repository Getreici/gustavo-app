package com.gustavo.web.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.google.common.base.FinalizablePhantomReference;
import com.gustavo.web.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
public List<User> findAll();
public User findByidUser(final Integer idUser);
}
