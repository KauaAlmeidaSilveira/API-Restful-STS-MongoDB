package com.cursoJavaUdemy.ProjectSTSMongoDB.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoJavaUdemy.ProjectSTSMongoDB.domain.User;
import com.cursoJavaUdemy.ProjectSTSMongoDB.dto.UserDTO;
import com.cursoJavaUdemy.ProjectSTSMongoDB.repositories.UserRepository;
import com.cursoJavaUdemy.ProjectSTSMongoDB.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	// O @Autowired ja instancia o objeto automaticamente
	@Autowired
	UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}
