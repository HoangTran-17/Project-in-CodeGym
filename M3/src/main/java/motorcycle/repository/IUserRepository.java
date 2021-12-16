package motorcycle.repository;

import motorcycle.model.User;
import motorcycle.model.UserStatus;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {

	User changeStatus(long id, UserStatus status) throws SQLException;

	User getById(long id);

	User getUserByPhoneNumberAndPassword(String phone, String password);

	List<User> getUsers();

	List<User> selectAllUsers();

	List<User> getAdmins();

	List<User> selectAllAdmins();

	void add(User newUser);

	User update(User user);

	boolean exist(long id);


	boolean existByPhoneNumber(String phoneNumber);


	void delete(long id);
}
