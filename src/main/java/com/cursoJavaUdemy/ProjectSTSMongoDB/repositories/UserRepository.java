package com.cursoJavaUdemy.ProjectSTSMongoDB.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cursoJavaUdemy.ProjectSTSMongoDB.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
