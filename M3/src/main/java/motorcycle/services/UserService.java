package motorcycle.services;

import motorcycle.exception.ExitsException;
import motorcycle.exception.NotFoundException;
import motorcycle.model.User;
import motorcycle.repository.IUserRepository;
import motorcycle.repository.UserRepository;


import java.util.List;

public class UserService implements IUserService {
	private IUserRepository userRepository;
	
	public UserService() {
		userRepository = new UserRepository();
	}

	@Override
	public void signIn(String phoneNumber, String password) {
		userRepository.getUserByPhoneNumberAndPassword(phoneNumber, password);
	}

	@Override
	public User getById(long userId) {
		User user = userRepository.getById(userId);
		if (user == null) {
			throw new NotFoundException("User is not existed!");
		}
		return user;
	}
	@Override
	public void addUser(User newUser) {
		if (userRepository.existByPhoneNumber(newUser.getPhone()))
			throw new ExitsException("Số điện thoại đã tồn tại!");
		userRepository.add(newUser);
	}
	@Override
	public User updateUser(User user) {
		if (userRepository.exist(user.getId())) {
			if (userRepository.existByPhoneNumber(user.getPhone()))
				throw new ExitsException("Phone number  already exists");
			return userRepository.update(user);
		} else
			throw new NotFoundException("user not already exists");

	}

	@Override
	public void deleteUser(long userId) {
		userRepository.delete(userId);
	}

    @Override
    public User getUserByPhoneNumberAndPassword(String phoneNumber, String password) {
		return userRepository.getUserByPhoneNumberAndPassword(phoneNumber, password);
    }

    @Override
	public List<User> getUsers() {
		return userRepository.getUsers();
	}

	@Override
	public List<User> selectAllUsers() {
		return userRepository.selectAllUsers();
	}

	@Override
	public List<User> getAdmins() {
		return userRepository.getAdmins();
	}

	@Override
	public List<User> selectAllAdmins() {
		return userRepository.selectAllAdmins();
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
