package com.cursoJavaUdemy.ProjectSTSMongoDB.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoJavaUdemy.ProjectSTSMongoDB.domain.Comment;
import com.cursoJavaUdemy.ProjectSTSMongoDB.repositories.CommentRepository;
import com.cursoJavaUdemy.ProjectSTSMongoDB.services.exception.ObjectNotFoundException;

@Service
public class CommentService {

	// O @Autowired ja instancia o objeto automaticamente
	@Autowired
	CommentRepository repository;

	public List<Comment> findAll() {
		return repository.findAll();
	}
	
	public Comment findById(String id) {
		Optional<Comment> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	
}
