package kr.ac.ewha.helloworld.dao;

import java.sql.Connection;

import org.junit.Test;

public class DBCPDataSourceTest {

	@Test
	public void testGetConnection() throws Exception {
		Connection conn = null;
		try {
			conn = DBCPDataSource.getInstance().getConnection();
			System.out.println(conn.getClass());
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
		
		
	}
}
