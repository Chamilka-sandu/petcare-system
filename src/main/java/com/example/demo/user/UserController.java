package com.example.demo.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.product.product;


@Controller
public class UserController {

	@Autowired
	private UserRepository UserRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@GetMapping("/users")
	public String showUserList(Model model) {
		List<User>listUsers = UserRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}
	
	@GetMapping("/users/new")
	public String showCreateNewUserList(Model model) {
		List<Role>listRoles= roleRepo.findAll();
		model.addAttribute("user", new User());
		model.addAttribute("listRoles", listRoles);
		return "user_form";
	}
	
	@PostMapping("/users/save")
	public String saveuser(User user) {
	UserRepo.save(user);

	return "redirect:/users";
	}

	@GetMapping("/users/edit/{id}")
	public String showEditUsers(@PathVariable("id")Integer id, Model model) {
	User user =UserRepo.findById(id).get();
	model.addAttribute("user",user);
	List<Role>listRoles= roleRepo.findAll();
	model.addAttribute("listRoles", listRoles);
		return "user_form";
	}
	
	@GetMapping("/users/delete/{id}")
	public String deleteUsers(@PathVariable("id")Integer id) {
		 UserRepo.deleteById(id);
		 return "redirect:/users";
	}
	
}
