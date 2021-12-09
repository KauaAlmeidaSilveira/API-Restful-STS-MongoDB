package com.cursoJavaUdemy.ProjectSTSMongoDB.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cursoJavaUdemy.ProjectSTSMongoDB.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	@Query("{ 'title' : { $regex: ?0, $options:'i' } }")
	List<Post> searchTitle(String txt);
	
	List<Post> findByTitleContainingIgnoreCase(String txt);

}
