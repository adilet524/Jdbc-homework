package peaksoft.dao;

import peaksoft.Config.Configuration;
import peaksoft.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {
    }

    private final Configuration config = new Configuration();

    public void createUsersTable() {
        String query = "create table if not exists users( " +
                "id serial primary key," +
                "name varchar(50) not null," +
                "last_name varchar(50) not null," +
                "age smallint not null);";

        try (Connection connection = config.getconnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            System.out.println("Table is created on database!");
        } catch (SQLException e) {
            System.out.println("Table is not created on database!");
        }
    }

    public void dropUsersTable() {
        String query = "drop table users";
        try (Connection connection = config.getconnection();
        Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            System.out.println("Table deleted on database!");
        } catch (SQLException e) {
            System.out.println("Something went wrong!");
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String query = "insert into users(name, last_name, age) values (?,?,?)";
        try (Connection connection = config.getconnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.executeUpdate();
            System.out.println("User is added on database!");
        }
        catch (SQLException e) {
            System.out.println("User is not added on database!");
        }
    }

    public void removeUserById(long id) {
        String query = "delete from users where id = ?";
        try(Connection connection = config.getconnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            System.out.println("Successfully deleted user by id!");
        } catch (SQLException e) {
            System.out.println("Something went wrong!");
        }
    }

    public List<User> getAllUsers() throws SQLException {
        String query = "select * from users;";
        try (Connection connection = config.getconnection();
        Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getByte("age")));
            }
            return users;
        } catch (SQLException e) {
            System.out.println("!!!");
            throw new SQLException();
        }
    }

    public void cleanUsersTable() {
        String query = "truncate table users";
        try(Connection connection = config.getconnection();
        Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
            System.out.println("Table is truncated on database!");
        } catch (SQLException e) {
            System.out.println("Something went wrong!");
        }
    }
}