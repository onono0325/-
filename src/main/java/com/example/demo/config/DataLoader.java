package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner{
	
	private final CommentRepository repository;
	
	@Override
	public void run(String... args)throws Exception{
		Comment comment = new Comment();
		comment.setName("山田太郎");
		comment.setAge(30);
		comment.setEmail("yamada@gmail.com");
		repository.save(comment);
		
		comment = new Comment();
		comment.setName("ああああ");
		comment.setAge(30);
		comment.setEmail("aaaaa@gmail.com");
		repository.save(comment);
	}

}
