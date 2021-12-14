package motorcycle.repository;

import motorcycle.exception.AuthorizationException;
import motorcycle.exception.OperationException;
import motorcycle.model.Role;
import motorcycle.model.User;
import motorcycle.model.UserStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserRepository implements IUserRepository {
	private static final String INSERT_USERS_SQL = "INSERT INTO users(userId,userName,role,status,phoneNumber,address,password) VALUES (?, ?, ?, ?, ?, ?, ?);";
	private static final String SELECT_USER_BY_ID = "select * from users where id =?";
	private static final String SELECT_USER_BY_PHONE_NUMBER = "select * from users where phoneNumber =\"?\"";
	private static final String SELECT_USER_BY_USERNAME = "select * from users where userName =\"?\"";
	private static final String SELECT_USER_BY_PHONE_NUMBER_PASSWORD = "select * from users where phoneNumber =? and password=?";
	private static final String SELECT_ALL_USERS = "select * from users where role = 'USER'";
	private static final String SELECT_ALL_ADMINS = "select * from users where role = 'ADMIN'";
	private static final String UPDATE_USERS_SQL = "update users set userName = ?,address = ?, password = ? where id = ?;";
	private static final String UPDATE_USER_STATUS_SQL = "update users set status = ? where id = ?;";
	private static final String DELETE_USERS_SQL = "delete from users where id = ?";

	public UserRepository() {
	}

	@Override
	public User changeStatus(long id, UserStatus status) {
		try (Connection connection = MysqlConnection.getInstance().getConnection();
			 PreparedStatement statement = connection.prepareStatement(UPDATE_USER_STATUS_SQL)) {
			statement.setString(1, status.getValue());
			statement.setLong(2, id);
			return getById(id);
		} catch (SQLException e) {
			throw new OperationException(e);
		}	}

	@Override
	public User getById(long id) {
		try (Connection connection = MysqlConnection.getInstance().getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setLong(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return getInfo(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void getUserByPhoneNumberAndPassword(String phoneNumber, String password) {
		try (Connection connection = MysqlConnection.getInstance().getConnection();
			 PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_PHONE_NUMBER)) {
			statement.setString(1, phoneNumber);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				getInfo(rs);
				return;
			}
		} catch (SQLException e) {
			throw new OperationException(e);
		}
		throw new AuthorizationException("info user invalid");
	}

	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<>();
		try (Connection connection = MysqlConnection.getInstance().getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				users.add(getInfo(rs));
			}
		} catch (SQLException e) {
			throw new OperationException(e);
		}
		return users;
	}

	@Override
	public List<User> selectAllUsers() {
		List<User> users = new ArrayList<>();

		try (Connection connection = MysqlConnection.getInstance().getConnection();


			 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();


			while (rs.next()) {
				users.add(getInfo(rs));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	@Override
	public List<User> getAdmins() {
		List<User> admins = new ArrayList<>();
		try (Connection connection = MysqlConnection.getInstance().getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADMINS)) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				admins.add(getInfo(rs));
			}
		} catch (SQLException e) {
			throw new OperationException(e);
		}
		return admins;
	}

	@Override
	public List<User> selectAllAdmins() {
		List<User> admins = new ArrayList<>();

		try (Connection connection = MysqlConnection.getInstance().getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADMINS);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				admins.add(getInfo(rs));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return admins;
	}


	private User getInfo(ResultSet rs) throws SQLException {
		long id = rs.getLong("id");
		String username = rs.getString("username");
		UserStatus status = UserStatus.fromValue(rs.getString("status"));
		Role role = Role.fromValue(rs.getString("role"));
		String phoneNumber = rs.getString("phoneNumber");
		String address = rs.getString("address");
		String password = rs.getString("password");
		return new User(id, username, status, role, phoneNumber, address,password);
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}


	@Override
	public boolean exist(long id) {
		return getById(id) != null;
	}



	@Override
	public void add(User newUser) {
		System.out.println(INSERT_USERS_SQL);
		try (Connection connection = MysqlConnection.getInstance().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			setUser(preparedStatement, newUser);
			preparedStatement.setString(2, newUser.getStatus().getValue());
			preparedStatement.setString(3, newUser.getRole().getValue());
			preparedStatement.setString(8, newUser.getPassword());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new OperationException(e);
		}
	}
	private void setUser(PreparedStatement preparedStatement, User user) throws SQLException {
		preparedStatement.setLong(1, user.getId());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setString(6, user.getPhoneNumber());
		preparedStatement.setString(7, user.getAddress());
	}
	
	@Override
	public User update(User newUser) {
		try (Connection connection = MysqlConnection.getInstance().getConnection();
			 PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, newUser.getName());
			statement.setString(2, newUser.getAddress());
			statement.setString(3, newUser.getPassword());
			statement.executeUpdate();
			return getById(newUser.getId());
		} catch (SQLException e) {
			throw new OperationException(e);
		}
	}

		@Override
		public boolean existByPhoneNumber(String phoneNumber) {
			try (Connection connection = MysqlConnection.getInstance().getConnection();
				 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_PHONE_NUMBER);) {
				preparedStatement.setString(1, phoneNumber);
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}

	@Override
	public void delete(long id) {
		try (
				Connection connection = MysqlConnection.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);)
		{
			statement.setLong(1,id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
