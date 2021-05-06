package service.admin;

import model.Category;
import service.ConnectionService;
import service.IBaseService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements IBaseService<Category> {

    ConnectionService connectionService = new ConnectionService();
    protected final String SELECT_ALL = "select * from category";
    protected final String INSERT_INTO = "insert into category(nameCategory) values (?)";
    protected final String UPDATE = "UPDATE category SET `nameCategory` = ? WHERE id = ?";
    protected final String FINDBYID = "select * from category where id = ?";
    protected final String DELETE_CATE = "call DELETE_CATEGORY(?)";

    @Override
    public List<Category> showAll() throws SQLException {
        List<Category> categoryList = new ArrayList<>();
        try(PreparedStatement statement = connectionService.getConnection().prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String nameCategory = resultSet.getString("nameCategory");

                Category category = new Category(id,nameCategory);
                categoryList.add(category);
            }
        }catch (Exception e){
            e.getMessage();
        }
        return categoryList;
    }

    @Override
    public void insert(Category data) throws SQLException {
    try(PreparedStatement statement = connectionService.getConnection().prepareStatement(INSERT_INTO)) {
        statement.setString(1, data.getNameCategory());

        statement.executeUpdate();
    }catch (Exception e){
        e.getMessage();
    }
    }

    @Override
    public void update(Category data, int id) throws SQLException {
    try(PreparedStatement statement = connectionService.getConnection().prepareStatement(UPDATE)) {
        statement.setString(1,data.getNameCategory());
        statement.setInt(2,id);

        statement.executeUpdate();
    }catch (Exception e){
        e.getMessage();
    }
    }

        @Override
        public void delete(int id) {
        try {
            Connection connection = connectionService.getConnection();
            CallableStatement statement = connection.prepareCall(DELETE_CATE);

            statement.setInt(1,id);

            statement.executeUpdate();
        }catch (Exception e){
            e.getMessage();
        }
        }

    @Override
    public Category findByID(int data) throws SQLException {
        Category category = new Category();
        try(PreparedStatement statement = connectionService.getConnection().prepareStatement(FINDBYID)) {
            statement.setInt(1,data);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String nameCategory = resultSet.getString("nameCategory");

                 category = new Category(id,nameCategory);
            }
        }
        return category;
    }
}
