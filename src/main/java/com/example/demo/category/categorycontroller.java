package com.example.demo.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.category.categoryRepositary;
@Controller
public class categorycontroller {
	
	@Autowired
	private categoryRepositary repo;
	
	@GetMapping("/index")
	public String listCategories(Model model) {
		List<category> listCategories = repo.findAll();
		model.addAttribute("listCategories", listCategories);
   return "index";
}
	@GetMapping("/index/new")
	public String showCategories(Model model) {
			model.addAttribute("category", new category());
   return "newcategory";
	
}
	@PostMapping("/categories/save")
	public String saveCategory(category category) {
		repo.save(category);
		return "redirect:/index";
	}
}