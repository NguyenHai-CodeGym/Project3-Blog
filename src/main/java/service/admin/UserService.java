package service.admin;

import model.User;
import service.ConnectionService;
import service.IBaseService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IBaseService<User> {

    ConnectionService connectionService = new ConnectionService();
    protected final String SELECT_ALL = "select * from users";
    protected final String SELECT_USER_ID = "select * from users where id = ?";
    protected final String SELECT_USER_PASS = "select * from users where username = ? and password = ?";
    protected final String INSERT_INTO = "insert into users (username, password, fullname) values (?,?,?)";
    protected final String UPDATE = "update users set username = ?, fullname = ? where id = ? ";
    protected final String DELETE = "delete from users where id = ? ";


    @Override
    public List<User> showAll() throws SQLException {
        List<User> userList = new ArrayList<>();
        try(PreparedStatement statement = connectionService.getConnection().prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String fullname = resultSet.getString("fullname");
                String username = resultSet.getString("username");

                User user = new User(id,username,fullname);
                userList.add(user);

            }
        }catch (Exception e){
            e.getMessage();
        }
        return userList;
    }

    @Override
    public void insert(User data) throws SQLException {
        try(PreparedStatement statement = connectionService.getConnection().prepareStatement(INSERT_INTO)) {
            statement.setString(1,data.getUsername());
            statement.setString(2,data.getPassword());
            statement.setString(3,data.getFullname());

            statement.executeUpdate();
        }catch (Exception e){
            e.getMessage();
        }

    }

    @Override
    public void update(User data, int id) throws SQLException {
        try(PreparedStatement statement = connectionService.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1,data.getUsername());
            statement.setString(2,data.getFullname());
            statement.setInt(3,id);

            statement.executeUpdate();
        }catch (Exception e){
            e.getMessage();
        }
    }

    @Override
    public void delete(int id) {
        try(PreparedStatement statement = connectionService.getConnection().prepareStatement(DELETE)) {
           statement.setInt(1,id);

            statement.executeUpdate();
        }catch (Exception e){
            e.getMessage();
        }
    }

    @Override
    public User findByID(int id) {
        User user = null;
        try(PreparedStatement statement = connectionService.getConnection().prepareStatement(SELECT_USER_ID)) {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                String fullname = resultSet.getString("fullname");
                String username = resultSet.getString("username");

                user = new User(id,username,fullname);
            }
        }catch (Exception e){
            e.getMessage();
        }
        return user;
    }

    public User findByUserAndPass(String username, String password) {
        User user = null;
        try(PreparedStatement statement = connectionService.getConnection().prepareStatement(SELECT_USER_PASS)) {
            statement.setString(1,username);
            statement.setString(2,password);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                String fullname = resultSet.getString("fullname");
                int id = resultSet.getInt("id");

                user = new User(id,username,fullname);
            }
        }catch (Exception e){
            e.getMessage();
        }
        return user;
    }
}
