package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class CommentController {
	
	private final CommentRepository repository;
	
	@GetMapping("/")
	public String getAllComments(Model model) {
		model.addAttribute("comments" , repository.findAll());
		return "list";
	}
	
	@GetMapping("/add")
	public String addcomments(@ModelAttribute Comment comment , Model model) {
		model.addAttribute("comments" , repository.findAll());
		return "form";
	}
	
	@PostMapping("/process")
	public String addComment(@Validated @ModelAttribute Comment comment , BindingResult result , Model model) {
		model.addAttribute("comments" , repository.findAll());
		if (result.hasErrors()) {
			return "form";
		}
		repository.save(comment);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editComment(@PathVariable Long id , Model model) {
		model.addAttribute("comment" , repository.findById(id));
		return "form";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteComment(@PathVariable Long id) {
		repository.deleteById(id);
		return "redirect:/";
	}
}
