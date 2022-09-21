package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Categoryservice;
import com.example.demo.category.category;
import com.example.demo.category.categoryRepositary;


@Controller 

public class AppController {

	@Autowired
	private Categoryservice service; 

	@RequestMapping("")
	public String viewHomePage1() {
		
		return "home";
	}

}