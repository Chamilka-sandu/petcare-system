package com.example.demo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.example.demo.user.Role;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

 @Autowired
private UserRepository repo ;
	
 @Autowired
 private TestEntityManager entityManager;
 
@Test
public void testCreateRoles() {
	
	Role roleAdmin = new Role("Administor");
	Role roleEditor = new Role("Editor");
	Role roleVisitor = new Role("Visitor");
	
	
	entityManager.persist(roleAdmin);
	entityManager.persist(roleEditor);
	entityManager.persist(roleVisitor);
	}


@Test

public void testCreateNewUserWithOneRole() {
	Role roleAdmin = entityManager.find(Role.class, 1);
	User user =  new User("namhm@codejava.net", "nam2020");
	user.addRole(roleAdmin);
	
	repo.save(user);
}

@Test

public void testCreateNewUserWithTwoRoles() {
	Role roleEditor = entityManager.find(Role.class, 2);
	Role roleVisitor = entityManager.find(Role.class, 3);
	User user =  new User("abc@codejava.net", "kl2020");
	user.addRole(roleEditor);
	user.addRole(roleVisitor);
	repo.save(user);
}
@Test
public void testAssignRoleToExistingUser() {
	User user = repo.findById(1).get();
	Role roleEditor = entityManager.find(Role.class, 2);
    user.addRole(roleEditor);
}

@Test
public void testRemoveRoleFromExistingUser() {
	User user = repo.findById(1).get();
	Role role = new Role(2);
	user.removeRole(role);
}

@Test
 public void testCreateNewUserWithNewRole() {
	Role roleSalesperson = new Role("Salesperson");
	User user = new User ("Jon2gamil.com", "123");
			user.addRole(roleSalesperson);
			repo.save(user);
}
@Test
public void testGetUser() {
	User user = repo.findById(1).get();
	entityManager.detach(user);
	System.out.println(user.getEmail());
	System.out.println(user.getRoles());
}

@Test
public void testRemoveUser() {
	repo.deleteById(4);
	
}

}
