package vn.tnh.maket.motorcycle.repository;

import vn.tnh.maket.motorcycle.model.Role;
import vn.tnh.maket.motorcycle.model.User;
import vn.tnh.maket.motorcycle.model.UserStatus;
import vn.tnh.maket.motorcycle.utils.JacksonParser;
import vn.tnh.maket.motorcycle.utils.TextFileUtils;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
	private final String USER_PATH = "data\\users.json";
	
	public UserRepository() {
	}
	
	@Override
	public User getById(int id) {
		for (User user : getUsers()) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	@Override
	public List<User> getUsers() {
		String json = TextFileUtils.read(USER_PATH);
		return json.isEmpty() ? new ArrayList<User>() : JacksonParser.INSTANCE.toList(json, User.class);
	}
	
	@Override
	public boolean exist(int id) {
		return getById(id) != null;
	}
	
	@Override
	public void add(User newUser) {
		List<User> users = getUsers();
		users.add(newUser);
		String json = JacksonParser.INSTANCE.toJson(users);
		TextFileUtils.write(USER_PATH, json);
	}
	
	@Override
	public void update(User newUser) {
		List<User> users = getUsers();
		for (User user : users) {
			if (user.getId() == newUser.getId()) {
				User.transferFields(user, newUser);
			}
		}
		String json = JacksonParser.INSTANCE.toJson(users);
		TextFileUtils.write(USER_PATH, json);
	}
	
	@Override
	public void delete(int id) {
		List<User> users = getUsers();
		
		for (User user : users) {
			if (user.getId() == id) users.remove(user);
		}
		
		String json = JacksonParser.INSTANCE.toJson(users);
		TextFileUtils.write(USER_PATH, json);
	}
	
	public static void main(String[] args) {
		UserRepository userRepository = new UserRepository();
		userRepository.add(new User(868686,
				"Director administrator",
				UserStatus.AVAILABLE, Role.SUPER_ADMIN,
				"0973017102",
				"trannhathoang.c@gmail.com",
				"28 Nguyen tri phuong",
				"686868"));
		userRepository.add(new User(123451,
				"Admin 1",
				UserStatus.AVAILABLE, Role.ADMIN,
				"0973017104",
				"trannhathoang.4@gmail.com",
				"28 Nguyen tri phuong",
				"123451"));
		userRepository.add(new User(123452,
				"Admin 2",
				UserStatus.AVAILABLE, Role.ADMIN,
				"0973017105",
				"trannhathoang.5@gmail.com",
				"28 Nguyen tri phuong",
				"123452"));
		userRepository.add(new User(123453,
				"Admin 3",
				UserStatus.AVAILABLE, Role.ADMIN,
				"0973017103",
				"trannhathoang.3@gmail.com",
				"28 Nguyen tri phuong",
				"123453"));
		List<User> list = userRepository.getUsers();
		System.out.printf("%s%n", list);
	}
}
