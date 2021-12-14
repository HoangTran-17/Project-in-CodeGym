package motorcycle.services;

import motorcycle.model.User;

import java.util.List;

public interface IUserService {

	void login(String phoneNumber, String password);

	User getById(long id);


	void addUser(User user);

	User updateUser(User user);

	void deleteUser(long id);


	List<User> getUsers();
	List<User> selectAllUsers();

	List<User> getAdmins();
	List<User> selectAllAdmins();



//	User getById(int id) throws Exception;
//
//	boolean exist(int id);
//
//	List<User> getUsers() throws Exception;
//
//	void signUp(User user) throws Exception;
//
//	void update(User user) throws Exception;
//
//	void delete(int choice);
//
//	User signIn(int id, String password);
//
//	User signInAdmin(int id, String password, Role role);
}

