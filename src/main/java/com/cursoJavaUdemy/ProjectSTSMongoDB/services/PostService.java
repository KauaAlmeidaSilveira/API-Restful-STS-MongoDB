package com.cursoJavaUdemy.ProjectSTSMongoDB.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoJavaUdemy.ProjectSTSMongoDB.domain.Post;
import com.cursoJavaUdemy.ProjectSTSMongoDB.repositories.PostRepository;
import com.cursoJavaUdemy.ProjectSTSMongoDB.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	// O @Autowired ja instancia o objeto automaticamente
	@Autowired
	PostRepository repository;

	public List<Post> findAll() {
		return repository.findAll();
	}
	
	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text) {
		return repository.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repository.fullSearch(text, minDate, maxDate);
	}
}