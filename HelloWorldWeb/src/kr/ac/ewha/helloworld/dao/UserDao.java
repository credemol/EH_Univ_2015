package kr.ac.ewha.helloworld.dao;

import java.util.Collection;

import kr.ac.ewha.helloworld.domain.User;

public interface UserDao {

	public Collection<User> getAllUsers() throws DaoException;
	public Collection<User> findUser(int pageNo, int pageSize, User query) throws DaoException;
	public void insertUser(User user) throws DaoException;
	public void updateUser(User user) throws DaoException;
	public void deleteUser(int id) throws DaoException;
}
