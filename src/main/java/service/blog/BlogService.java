package service.blog;

import model.Category;
import model.Post;
import service.ConnectionService;
import service.IBaseService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BlogService implements IBaseService<Post> {

    ConnectionService connectionService = new ConnectionService();

    protected final String SELECT_NEW_POST = "select post.id as id, title, fullContent, shortContent, publishDate, image, idCategory, nameCategory from post inner join category on post.idCategory = category.id order by id desc limit 3";
    protected final String SELECT_RAM = "select post.id as id, title, fullContent, shortContent, publishDate, image, idCategory, nameCategory from post inner join category on post.idCategory = category.id order by RAND() limit 3";
    protected final String FINDBYID = "select post.id as id, title, fullContent, shortContent, publishDate, image, idCategory, nameCategory from post inner join category on post.idCategory = category.id where post.id = ?";
    protected final String SEARCHBYTITLE = "select post.id as id, title, fullContent, shortContent, publishDate, image, idCategory, nameCategory from post inner join category on post.idCategory = category.id where title like concat('%',?,'%')";

    @Override
    public List<Post> showAll() throws SQLException {
        List<Post> poList = new ArrayList<>();
        try(PreparedStatement statement = connectionService.getConnection().prepareStatement(SELECT_NEW_POST)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String fullContent = resultSet.getString("fullContent");
                String shortContent = resultSet.getString("shortContent");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String dateTime = resultSet.getString("publishDate");
                LocalDateTime publishDate = LocalDateTime.parse(dateTime, formatter);
                String image = resultSet.getString("image");
                int idCategory = resultSet.getInt("idCategory");
                String categoryName = resultSet.getString("nameCategory");
                Category category = new Category(idCategory, categoryName);
                Post post = new Post(id, title, fullContent, shortContent, publishDate, image, category);

                poList.add(post);

            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return poList;
    }

    @Override
    public void insert(Post data) throws SQLException {

    }

    @Override
    public void update(Post data, int id) throws SQLException {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Post findByID(int data) {
        Post post = new Post();
        try(PreparedStatement statement = connectionService.getConnection().prepareStatement(FINDBYID)) {
            statement.setInt(1,data);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String fullContent = resultSet.getString("fullContent");
                String shortContent = resultSet.getString("shortContent");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String dateTime = resultSet.getString("publishDate");
                LocalDateTime publishDate = LocalDateTime.parse(dateTime, formatter);
                String image = resultSet.getString("image");
                int idCategory = resultSet.getInt("idCategory");
                String categoryName = resultSet.getString("nameCategory");
                Category category = new Category(idCategory, categoryName);
                post = new Post(id, title, fullContent, shortContent, publishDate, image, category);
            }
        }catch (Exception e){
            e.getMessage();
        }
        return post;
    }

    public List<Post> selectRamDom() throws SQLException{
        List<Post> poList = new ArrayList<>();
        try(PreparedStatement statement = connectionService.getConnection().prepareStatement(SELECT_RAM)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String fullContent = resultSet.getString("fullContent");
                String shortContent = resultSet.getString("shortContent");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String dateTime = resultSet.getString("publishDate");
                LocalDateTime publishDate = LocalDateTime.parse(dateTime, formatter);
                String image = resultSet.getString("image");
                int idCategory = resultSet.getInt("idCategory");
                String categoryName = resultSet.getString("nameCategory");
                Category category = new Category(idCategory, categoryName);
                Post post = new Post(id, title, fullContent, shortContent, publishDate, image, category);

                poList.add(post);

            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return poList;
    }


    public List<Post> selectSearch(String data) throws SQLException{
        List<Post> poList = new ArrayList<>();
        try(PreparedStatement statement = connectionService.getConnection().prepareStatement(SEARCHBYTITLE)){
            statement.setString(1,data);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String fullContent = resultSet.getString("fullContent");
                String shortContent = resultSet.getString("shortContent");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String dateTime = resultSet.getString("publishDate");
                LocalDateTime publishDate = LocalDateTime.parse(dateTime, formatter);
                String image = resultSet.getString("image");
                int idCategory = resultSet.getInt("idCategory");
                String categoryName = resultSet.getString("nameCategory");
                Category category = new Category(idCategory, categoryName);
                Post post = new Post(id, title, fullContent, shortContent, publishDate, image, category);

                poList.add(post);

            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return poList;
    }
}
