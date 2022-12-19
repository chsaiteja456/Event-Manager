package com.csun.csunevent.saiteja;

import com.csun.csunevent.saiteja.Repository.CommentsRepo;
import com.csun.csunevent.saiteja.Repository.UserRepo;
import com.csun.csunevent.saiteja.models.Comment;
import com.csun.csunevent.saiteja.models.Department;
import com.csun.csunevent.saiteja.models.User;
import com.csun.csunevent.saiteja.models.event;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(locations={"classpath:/resources/application.properties"})
public class ApplicationTests {
	public ApplicationTests() {
	}

	/*public ApplicationTests(CommentsRepo commentsRepo, com.csun.csunevent.saiteja.Repository.eventRepo eventRepo, UserRepo userRepo) {
		this.commentsRepo = commentsRepo;
		this.eventRepo = eventRepo;
		this.userRepo = userRepo;
	}*/

	@Autowired
	public CommentsRepo commentsRepo;
	@Autowired
	public com.csun.csunevent.saiteja.Repository.eventRepo eventRepo;
	@Autowired
	public UserRepo userRepo;
	@Test
	public void getUser() {
		Comment message = commentsRepo.findById(1).get();
		assertEquals("Hello, World!", message);

	}
	@Test
	public void isUserExitsById() {
		User person = new User("junit@gmail.com", "junit", "testing");
		userRepo.save(person);
		boolean actualResult = userRepo.existsById("junit@gmail.com");
		assertTrue(actualResult);
	}
	@Test
	public void isEventExitsById() {
		event event7 = eventRepo.findById(7).get();
		User u=userRepo.findByEmailId("saiteja@gmail.com");
		List<Comment> listOfComm=eventRepo.findByEventId(7).getComments();
		List<Department> listOfDept=new ArrayList<>();
		event expected=new event(7,"freshers pary", listOfComm,u,"free food","university union",listOfDept);
assertEquals(expected,event7);
	}
}
