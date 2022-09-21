package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.category.category;
import com.example.demo.category.categoryRepositary;
@Service
@Transactional
public class Categoryservice {

	@Autowired
	private categoryRepositary repo;
	
	@Autowired
	
	
	
	public List<category> listAll() {
		return repo.findAll();
	}
	
	public void save(category category) {
		repo.save(category);
	}
	
	
	public category get(long id) {
		return repo.findById(id).get();
	}
	
	
}
