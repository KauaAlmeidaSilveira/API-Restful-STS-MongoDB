package com.cursoJavaUdemy.ProjectSTSMongoDB.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cursoJavaUdemy.ProjectSTSMongoDB.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
