package vn.tnh.maket.motorcycle.services;

import vn.tnh.maket.motorcycle.model.Role;
import vn.tnh.maket.motorcycle.repository.UserRepository;
import vn.tnh.maket.motorcycle.model.User;

import java.util.List;

public class UserService implements IUserService {
	private UserRepository userRepository;
	
	public UserService() {
		userRepository = new UserRepository();
	}
	
	@Override
	public User getById(int id) throws Exception {
		User user = userRepository.getById(id);
		if (user == null) {
			throw new Exception("User is not existed!");
		}
		return user;
	}
	
	@Override
	public boolean exist(int id) {
		return userRepository.exist(id);
	}
	
	@Override
	public List<User> getUsers() {
		return userRepository.getUsers();
	}
	
	@Override
	public void signUp(User newUser) throws Exception {
		if (userRepository.exist(newUser.getId())) {
			throw new Exception("User is existed!");
		}
		userRepository.add(newUser);
	}
	
	@Override
	public void update(User user) throws Exception {
		if (!userRepository.exist(user.getId())) {
			throw new Exception("User isn't exist!");
		}
		userRepository.update(user);
	}
	
	@Override
	public void delete(int id) {
		userRepository.delete(id);
	}
	
	@Override
	public User signIn(int id, String password) {
		User user = userRepository.getById(id);
		if (user != null && user.getPassword().equals(password) && user.getRole() == Role.USER)
			return user;
		return null;
	}
	
	
	@Override
	public User signInAdmin(int id, String password, Role role) {
		User user = userRepository.getById(id);
		if (user != null && user.getPassword().equals(password) && user.getRole() == role)
			return user;
		return null;
	}
}
