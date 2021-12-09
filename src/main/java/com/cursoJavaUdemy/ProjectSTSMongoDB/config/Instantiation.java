package com.cursoJavaUdemy.ProjectSTSMongoDB.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.cursoJavaUdemy.ProjectSTSMongoDB.domain.Comment;
import com.cursoJavaUdemy.ProjectSTSMongoDB.domain.Post;
import com.cursoJavaUdemy.ProjectSTSMongoDB.domain.User;
import com.cursoJavaUdemy.ProjectSTSMongoDB.dto.AuthorDTO;
import com.cursoJavaUdemy.ProjectSTSMongoDB.repositories.CommentRepository;
import com.cursoJavaUdemy.ProjectSTSMongoDB.repositories.PostRepository;
import com.cursoJavaUdemy.ProjectSTSMongoDB.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		postRepository.deleteAll();
		commentRepository.deleteAll();
		userRepository.deleteAll();
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com");
		User u2 = new User(null, "Alex Green", "alex@gmail.com");
		User u3 = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		
		Comment c1 = new Comment(null, "Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(u2));
		Comment c2 = new Comment(null, "Aproveite!", sdf.parse("22/03/2018"), new AuthorDTO(u3));
		Comment c3 = new Comment(null, "Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(u2));
		
		commentRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(u1));
		Post p2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(u2));
		
		p1.getComments().addAll(Arrays.asList(c1, c2));
		p2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(p1, p2));
		
		u1.getPosts().addAll(Arrays.asList(p1, p2));
		userRepository.save(u1);
		
		
	}
}
