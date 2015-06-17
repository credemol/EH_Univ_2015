package kr.ac.ewha.helloworld.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import kr.ac.ewha.helloworld.domain.User;

public class UserDaoDBCP implements UserDao{

	@Override
	public Collection<User> getAllUsers() throws DaoException {
	Collection<User> users = new ArrayList<User>();
		
		final String sql = "select * from EH_USER";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {		
			conn = DBCPDataSource.getInstance().getConnection();
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				users.add(toUser(rs));
			}
		
		} catch(Exception e) {
			throw new DaoException(e);
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch(Exception e) { throw new DaoException(e); }
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch(Exception e) { throw new DaoException(e); }
			}
			if(conn != null) {
				try {
					conn.close();
				} catch(Exception e) { throw new DaoException(e); }
			}
		}
		
		return users;
	}

	@Override
	public Collection<User> findUser(int pageNo, int pageSize, User query) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUser(User user) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void savePassword(int id, String password) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUser(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByLoginId(String loginId) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	private User toUser(ResultSet rs) throws DaoException {
		User user = new User();
		
		try {
			user.setId(rs.getInt("id"));
			user.setLoginId(rs.getString("login_id"));
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setDisplayName(rs.getString("display_name"));
			user.setEmail(rs.getString("email"));
		} catch(Exception e) {
			throw new DaoException(e);
		}
		return user;
	}
}
