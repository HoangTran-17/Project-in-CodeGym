package vn.tnh.maket.motorcycle.repository;

import vn.tnh.maket.motorcycle.model.User;

import java.io.IOException;
import java.util.List;

public interface IUserRepository {
	User getById(int id);
	
	List<User> getUsers() throws IOException;
	
	boolean exist(int id);
	
	void add(User newUser) throws IOException;
	
	void update(User user);
	
	void delete(int id);
}
