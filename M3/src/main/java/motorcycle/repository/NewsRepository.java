package motorcycle.repository;

import motorcycle.connection.MysqlConnection;
import motorcycle.exception.OperationException;
import motorcycle.model.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class NewsRepository implements INewsRepository {
	private static final String INSERT_NEWS_SQL = "INSERT INTO product (id,brand, type, line, color, year, km, price, description) VALUES (?,?,?,?, ?,?,?, ?, ?);";
	private static final String SELECT_NEWS_BY_ID = "select * from product where id =?";
	private static final String SELECT_NEWS_BY_NAME = "select * from news where line =\"?\"";

	private static final String SELECT_ALL_NEWS = "select * from product";
	private static final String UPDATE_NEWS_SQL = "update product set color = ?,year = ?, km = ?,price = ?,description = ? where id = ?;";



	public NewsRepository(){}
	
	@Override
	public News getById(long id) {
		try (Connection connection = MysqlConnection.getInstance().getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NEWS_BY_ID);) {
			preparedStatement.setLong(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return getNew(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<News> getNew() {
		List<News> news = new ArrayList<>();
		try (Connection connection = MysqlConnection.getInstance().getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NEWS)) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {

				news.add(getNew(rs));
			}
		} catch (SQLException e) {
			throw new OperationException(e);
		}
		return news;
	}
	
	@Override
	public Boolean exist(long id) { return getById(id) != null;}
	
	@Override
	public void add(News newNews) {
		System.out.println(INSERT_NEWS_SQL);
		try (Connection connection = MysqlConnection.getInstance().getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEWS_SQL)) {
			preparedStatement.setLong(1, newNews.getId());
			preparedStatement.setString(2, newNews.getBrand());
			preparedStatement.setString(3, newNews.getType());
			preparedStatement.setString(4, newNews.getLine());
			preparedStatement.setString(5, newNews.getColor());
			preparedStatement.setInt(6, newNews.getYear());
			preparedStatement.setString(7, newNews.getKm());
			preparedStatement.setDouble(8, newNews.getPrice());
			preparedStatement.setString(9, newNews.getDescription());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new OperationException(e);
		}
	}
	
	
	@Override
	public News update(News newNews)  {
		try (Connection connection = MysqlConnection.getInstance().getConnection();
			 PreparedStatement statement = connection.prepareStatement(UPDATE_NEWS_SQL);) {
			statement.setLong(1, newNews.getId());
			statement.setString(2, newNews.getBrand());
			statement.setString(3, newNews.getType());
			statement.setString(4, newNews.getLine());
			statement.setString(5, newNews.getColor());
			statement.setInt(6, newNews.getYear());
			statement.setString(7, newNews.getKm());
			statement.setDouble(8, newNews.getPrice());
			statement.setString(9, newNews.getDescription());
			statement.executeUpdate();
			return getById(newNews.getId());
		} catch (SQLException e) {
			throw new OperationException(e);
		}
	}

	@Override
	public List<News> selectAllNews() {
		List<News> news = new ArrayList<>();
		try (Connection connection = MysqlConnection.getInstance().getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NEWS);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				news.add(getNew(rs));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return news;
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


	private News getNew(ResultSet rs) throws SQLException {
		long id = rs.getLong("id");
		String brand = rs.getString("brand");
		long userId = rs.getLong("userId");
		String type = rs.getString("type");
		String line = rs.getString("line");
		String color = rs.getString("color");
		int year = rs.getInt("year");
		String km = rs.getString("km");
		double price = rs.getLong("price");
		String description = rs.getString("description");
		return new News(id, userId,brand, type,line,color,year,km,price,description);
	}
}
