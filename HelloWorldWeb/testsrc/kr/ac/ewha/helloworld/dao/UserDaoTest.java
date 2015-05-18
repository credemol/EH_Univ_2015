package kr.ac.ewha.helloworld.dao;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import kr.ac.ewha.helloworld.domain.User;

public class UserDaoTest {
	
	private static final String LOGIN_ID = "testuser_xxxx";
	
	UserDao userDao = null;
	
	User testUser = null;
	
	@Before
	public void init() {
		userDao = new UserDaoImpl();
		
		testUser = new User();
		testUser.setLoginId(LOGIN_ID);
		testUser.setFirstName("test_firstname");
		testUser.setLastName("test_lastName");
		testUser.setDisplayName("test_displayName");
		testUser.setEmail("test_email");
		testUser.setPassword("test_password");
		
	}
	
	@Test
	public void testGetAllUsers() throws Exception {
		Collection<User> users = userDao.getAllUsers();
		
		for(User user : users) {
			System.out.println(user);
		}
	}

	@Test
	public void testGetUser() throws Exception {
		int id = 2;
		User user = userDao.getUser(id);
		System.out.println(user);
	}
	
	@Test
	public void testInsert() throws Exception {
		User user = userDao.getUserByLoginId(LOGIN_ID);
		
		if(user != null) {
			System.out.println("User already exists!");
			return;
		}
		
		System.out.println("before: " + testUser);
		userDao.insertUser(testUser);
		
		System.out.println("after: " + testUser);
		
	}
	
	@Test
	public void testDelete() throws Exception {
		User user = userDao.getUserByLoginId(LOGIN_ID);
		
		if(user == null) {
			System.out.println("User not found!");
			return;
			
		}
		
		userDao.deleteUser(user.getId());
		
	}
	
	@Test
	public void testUpdate() throws Exception {
		User user = userDao.getUserByLoginId(LOGIN_ID);
		
		if(user == null) {
			System.out.println("User not found!");
			return;
			
		}
		
		long currentMillis = System.currentTimeMillis();
		user.setFirstName("first_" + currentMillis);
		user.setLastName("lastName_" + currentMillis);
		
		userDao.updateUser(user);
	}
}
