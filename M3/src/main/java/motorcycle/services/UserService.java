package motorcycle.services;

import motorcycle.exception.ExitsException;
import motorcycle.exception.NotFoundException;
import motorcycle.model.Role;
import motorcycle.model.User;
import motorcycle.model.UserStatus;
import motorcycle.repository.IUserRepository;
import motorcycle.repository.UserRepository;


import java.util.List;

public class UserService implements IUserService {
	private IUserRepository userRepository;
	
	public UserService() {
		userRepository = new UserRepository();
	}

	@Override
	public void login(String phoneNumber, String password) {
		userRepository.getUserByPhoneNumberAndPassword(phoneNumber, password);
	}

	@Override
	public User getById(long id) {
		User user = userRepository.getById(id);
		if (user == null) {
			throw new NotFoundException("User is not existed!");
		}
		return user;
	}
	@Override
	public void addUser(User newUser) {
		if (userRepository.existByPhoneNumber(newUser.getPhoneNumber()))
			throw new ExitsException("mobile already exist");
		newUser.setStatus(UserStatus.AVAILABLE);
		newUser.setRole(Role.USER);
		userRepository.add(newUser);
	}
	@Override
	public User updateUser(User user) {
		if (userRepository.exist(user.getId())) {
			if (userRepository.existByPhoneNumber(user.getPhoneNumber()))
				throw new ExitsException("Phone number  already exists");
			return userRepository.update(user);
		} else
			throw new NotFoundException("user not already exists");

	}

	@Override
	public void deleteUser(long id) {
		userRepository.delete(id);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.getUsers();
	}

	@Override
	public List<User> selectAllUsers() {
		List<User> userList = userRepository.selectAllUsers();
		if (userList == null)
			throw new NotFoundException("user not already exists");
		userRepository.selectAllUsers();
		return userList;
	}

	@Override
	public List<User> getAdmins() {
		return userRepository.getAdmins();
	}

	@Override
	public List<User> selectAllAdmins() {
		List<User> adminList = userRepository.selectAllAdmins();

		if (adminList == null)
			throw new NotFoundException("admin not already exists");
		userRepository.selectAllAdmins();
		return adminList;
	}
//	@Override
//	public boolean exist(int id) {
//		return userRepository.exist(id);
//	}
//
//
//	@Override
//	public void signUp(User newUser) throws Exception {
//		if (userRepository.exist(newUser.getId())) {
//			throw new Exception("User is existed!");
//		}
//		userRepository.add(newUser);
//	}
//
//	@Override
//	public void update(User user) throws Exception {
//		if (!userRepository.exist(user.getId())) {
//			throw new Exception("User isn't exist!");
//		}
//		userRepository.update(user);
//	}
//
//	@Override
//	public void delete(int id) {
//		userRepository.delete(id);
//	}
//
//	@Override
//	public User signIn(int id, String password) {
//		User user = userRepository.getById(id);
//		if (user != null && user.getPassword().equals(password) && user.getRole() == Role.USER)
//			return user;
//		return null;
//	}
//
//
//	@Override
//	public User signInAdmin(int id, String password, Role role) {
//		User user = userRepository.getById(id);
//		if (user != null && user.getPassword().equals(password) && user.getRole() == role)
//			return user;
//		return null;
//	}
}
