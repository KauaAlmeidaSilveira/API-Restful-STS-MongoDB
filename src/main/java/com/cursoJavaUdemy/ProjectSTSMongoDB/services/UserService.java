package com.cursoJavaUdemy.ProjectSTSMongoDB.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoJavaUdemy.ProjectSTSMongoDB.domain.User;
import com.cursoJavaUdemy.ProjectSTSMongoDB.repositories.UserRepository;

@Service
public class UserService {

	
	//O @Autowired ja instancia o objeto automaticamente
	@Autowired
	UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
}
