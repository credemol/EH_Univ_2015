package kr.ac.ewha.helloworld.dao;

import org.junit.Before;
import org.junit.Test;

public class UserDaoDBCPTest {

	UserDao userDaoImpl;
	UserDao userDaoDbcp;
	
	@Before
	public void init() {
		userDaoImpl = new UserDaoImpl();
		userDaoDbcp = new UserDaoDBCP();
	}
	
	@Test
	public void comparePerformance() {
		int repeatCount = 100;
		
		userDaoDbcp.getAllUsers();
		userDaoImpl.getAllUsers();
		
		long start = 0L;
		
		start = System.currentTimeMillis();
		for(int i = 0; i < repeatCount; i++) {
			this.userDaoDbcp.getAllUsers();
		}
		System.out.println("UserDaoDbcp elapsed: " + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		
		for(int i = 0; i < repeatCount; i++) {
			this.userDaoImpl.getAllUsers();
		}
		System.out.println("UserDaoImpl elapsed: " + (System.currentTimeMillis() - start));
		
	}
}
