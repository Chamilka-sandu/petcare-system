package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.example.demo.category.category;
import com.example.demo.category.categoryRepositary;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class categoryrepositorytest {
	
	@Autowired
 private categoryRepositary repo;
	
	@Test
	public void testCreateCategory() {
	category savedcategory = repo.save(new category("opoj"));
	
	assertThat(savedcategory.getId()).isGreaterThan(0);
	}
}
