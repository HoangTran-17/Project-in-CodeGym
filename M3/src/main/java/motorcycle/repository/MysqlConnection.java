package motorcycle.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/Case_study_module3?useSSL=false";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "Dt080796";
    private static MysqlConnection instance;

    private MysqlConnection() { }

    public static MysqlConnection getInstance() {
        if (instance == null)
            instance = new MysqlConnection();
        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}