package kr.ac.ewha.helloworld.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import kr.ac.ewha.helloworld.DBConnectionManager;
import kr.ac.ewha.helloworld.domain.User;

public class UserDaoImpl implements UserDao{

	private static final String JDBC_URL = "jdbc:derby://localhost:1527/seconddb;create=true";
	@Override
	public Collection<User> getAllUsers() throws DaoException {
		
		Collection<User> users = new ArrayList<User>();
		
		final String sql = "select * from EH_USER";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		
			conn = DriverManager.getConnection(JDBC_URL);
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
		final String sql = 
				"insert into EH_USER(login_id, first_name, last_name, display_name, email, password) values(?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnectionManager.getConnection();
			String[] keys = { "id" };
			stmt = conn.prepareStatement(sql, keys);
			
			stmt.setString(1, user.getLoginId());
			stmt.setString(2, user.getFirstName());
			stmt.setString(3,  user.getLastName());
			stmt.setString(4,  user.getDisplayName());
			stmt.setString(5, user.getEmail());
			stmt.setString(6,  user.getPassword());
			
			int inserted = stmt.executeUpdate();
			
			System.out.println("inserted: " + (inserted == 1));
			
			rs = stmt.getGeneratedKeys();
			
			if(rs.next()) {
				user.setId(rs.getInt(1));
			}
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			if(rs != null) {
				try { rs.close(); } catch(Exception e) {}
			}
			if(stmt != null) {
				try { stmt.close(); } catch(Exception e) {}
			}
			if(conn != null) {
				try { conn.close(); } catch(Exception e) {}
			}
		}
		
	}

	@Override
	public void updateUser(User user) throws DaoException {
		final String sql = 
				"update EH_USER set login_id = ?, first_name = ?, last_name = ?, display_name = ?, email = ? where id = ?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBConnectionManager.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, user.getLoginId());
			stmt.setString(2, user.getFirstName());
			stmt.setString(3,  user.getLastName());
			stmt.setString(4,  user.getDisplayName());
			stmt.setString(5, user.getEmail());
			stmt.setInt(6, user.getId());
			
			int update = stmt.executeUpdate();
			System.out.println("updated: " + (update == 1));
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			if(stmt != null) {
				try { stmt.close(); } catch(Exception e) {}
			}
			if(conn != null) {
				try { conn.close(); } catch(Exception e) {}
			}
		}
	}
	
	

	@Override
	public void savePassword(int id, String password) throws DaoException {
		final String sql = 
				"update EH_USER set password = ? where id = ?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBConnectionManager.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, password);
			stmt.setInt(2, id);
			
			int update = stmt.executeUpdate();
			System.out.println("updated: " + (update == 1));
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			if(stmt != null) {
				try { stmt.close(); } catch(Exception e) {}
			}
			if(conn != null) {
				try { conn.close(); } catch(Exception e) {}
			}
		}
	}

	@Override
	public void deleteUser(int id) throws DaoException {
		final String sql = 
				"delete from EH_USER where id = ?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBConnectionManager.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			int update = stmt.executeUpdate();
			System.out.println("deleted: " + (update == 1));
		} catch(SQLException e) {
			throw new DaoException(e);
		} finally {
			if(stmt != null) {
				try { stmt.close(); } catch(Exception e) {}
			}
			if(conn != null) {
				try { conn.close(); } catch(Exception e) {}
			}
		}
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

	@Override
	public User getUser(int id) throws DaoException {
		final String sql = "select * from EH_USER where id = ?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		
			conn = DriverManager.getConnection(JDBC_URL);
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return (toUser(rs));
			} else {
				return null;
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
		
	}

	@Override
	public User getUserByLoginId(String loginId) throws DaoException {
		final String sql = "select * from EH_USER where login_id = ?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		
			conn = DriverManager.getConnection(JDBC_URL);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, loginId);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return (toUser(rs));
			} else {
				return null;
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
	}
	
	
}
