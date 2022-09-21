package com.example.demo.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.category.category;
import com.example.demo.category.categoryRepositary;


@Controller
public class ProductController {

	@Autowired
	private ProductRepository productrepo;
	@Autowired
	private categoryRepositary  categoryRepo;
	
	@GetMapping("/product/new")
	public String listCategories(Model model) {
		
		List<category> listCategories=categoryRepo.findAll() ;	
		
	model.addAttribute("product", new product());
	model.addAttribute("listCategories", listCategories);
	
   return "newproduct";
}
	@PostMapping("/products/save")
	public String saveproduct(product product) {
		productrepo.save(product);
		
		return "redirect:/product";
	}
	
	@GetMapping("/product")
	public String listProducts(Model model) {
	List<product> listProducts = productrepo.findAll();
	model.addAttribute("listProducts",listProducts );

	return "productlist";
	}
}
