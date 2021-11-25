package vn.tnh.maket.motorcycle.services;

import vn.tnh.maket.motorcycle.model.Role;
import vn.tnh.maket.motorcycle.model.User;

import java.util.List;

public interface IUserService {
	User getById(int id) throws Exception;
	
	boolean exist(int id);
	
	List<User> getUsers() throws Exception;
	
	void signUp(User user) throws Exception;
	
	void update(User user) throws Exception;
	
	void delete(int choice);
	
	User signIn(int id, String password);
	
	User signInAdmin(int id, String password, Role role);
}
