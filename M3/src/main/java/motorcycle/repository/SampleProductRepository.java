package motorcycle.repository;

import motorcycle.connection.MysqlConnection;
import motorcycle.exception.OperationException;
import motorcycle.model.SampleProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SampleProductRepository implements ISampleProductRepo {
    private static final String INSERT_SAMPLE_PRODUCT_SQL = "INSERT INTO sampleProduct (brand, type, line, color, year) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_SAMPLE_PRODUCT_BY_ID= "select * from sampleProduct where id =?";
    private static final String SELECT_SAMPLE_PRODUCT_BY_NAME= "select * from sampleProduct where line =\"?\"";

    private static final String SELECT_ALL_SAMPLE_PRODUCT = "select * from sampleProduct";
    private static final String UPDATE_SAMPLE_PRODUCT_SQL = "update sampleProduct set color = ?,year = ? where id = ?;";



    public SampleProductRepository() {
    }

    @Override
    public SampleProduct getById(long id) {
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SAMPLE_PRODUCT_BY_ID);) {
            preparedStatement.setLong(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return getSampleProduct(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<SampleProduct> getSampleProduct() {
        List<SampleProduct> sampleProducts = new ArrayList<>();
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SAMPLE_PRODUCT)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                sampleProducts.add(getSampleProduct(rs));
            }
        } catch (SQLException e) {
            throw new OperationException(e);
        }
        return sampleProducts;
    }

    @Override
    public boolean exist(long id) {
        return getById(id) != null;
    }

    @Override
    public void add(SampleProduct newSampleProduct) {
        System.out.println(INSERT_SAMPLE_PRODUCT_SQL);
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SAMPLE_PRODUCT_SQL)) {

            preparedStatement.setLong(1, newSampleProduct.getId());
            preparedStatement.setString(2, newSampleProduct.getBrand());
            preparedStatement.setString(3, newSampleProduct.getType());
            preparedStatement.setString(4, newSampleProduct.getLine());
            preparedStatement.setString(5, newSampleProduct.getColor());
            preparedStatement.setString(6, newSampleProduct.getYear());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new OperationException(e);
        }
    }

    @Override
    public SampleProduct update(SampleProduct sampleProduct) {
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_SAMPLE_PRODUCT_SQL);) {
            statement.setString(5, sampleProduct.getColor());
            statement.setString(6, sampleProduct.getYear());

            statement.executeUpdate();
            return getById(sampleProduct.getId());
        } catch (SQLException e) {
            throw new OperationException(e);
        }
    }

    @Override
    public boolean existByName(String name) {
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SAMPLE_PRODUCT_BY_NAME);) {
            preparedStatement.setString(1, name);
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
    public List<SampleProduct> selectAllProduct() {
        List<SampleProduct> sampleProducts = new ArrayList<>();

        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SAMPLE_PRODUCT);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                sampleProducts.add(getSampleProduct(rs));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return sampleProducts;
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
    private SampleProduct getSampleProduct(ResultSet rs) throws SQLException {
        long id = rs.getInt("id");
        String brand = rs.getString("brand");
        String type = rs.getString("type");
        String line = rs.getString("line");
        String color = rs.getString("color");
        String year = rs.getString("year");
        return new SampleProduct(id, brand, type,line,color,year);

    }
}
