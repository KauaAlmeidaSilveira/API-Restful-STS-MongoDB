package com.cursoJavaUdemy.ProjectSTSMongoDB.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cursoJavaUdemy.ProjectSTSMongoDB.domain.Comment;
import com.cursoJavaUdemy.ProjectSTSMongoDB.services.CommentService;

@RestController
@RequestMapping(value="/comments")
public class CommentResource {

	@Autowired
	CommentService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Comment>> findAll(){
		List<Comment> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
 	public ResponseEntity<Comment> findById(@PathVariable String id) {
		Comment obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
