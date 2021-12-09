package com.cursoJavaUdemy.ProjectSTSMongoDB.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cursoJavaUdemy.ProjectSTSMongoDB.domain.Comment;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String>{

}
