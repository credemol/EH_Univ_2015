package kr.ac.ewha.helloworld.dao;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import kr.ac.ewha.helloworld.domain.User;

public class UserDaoTest {
	
	UserDao userDao = null;
	@Before
	public void init() {
		userDao = new UserDaoImpl();
	}
	
	@Test
	public void testGetAllUsers() throws Exception {
		Collection<User> users = userDao.getAllUsers();
		
		for(User user : users) {
			System.out.println(user);
		}
	}

}
