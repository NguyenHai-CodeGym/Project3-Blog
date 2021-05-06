package service.admin;

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

public class PostService implements IBaseService<Post> {
    ConnectionService connectionService = new ConnectionService();
    protected final String SELECT_ALL = "select post.id as id, title, fullContent, shortContent, publishDate, image, idCategory, nameCategory from post left join category on post.idCategory = category.id";
    protected final String INSERT_POST = "INSERT INTO post (title,fullContent,shortContent,image,idCategory) VALUES (?,?,?,?,?)";
    protected final String UPDATE_POST = "UPDATE post SET title = ?, fullContent= ?, shortContent = ?, image = ?, idCategory = ? where post.id = ?";
    protected final String FINDBYID = "select post.id as id, title, fullContent, shortContent, publishDate, image, idCategory, nameCategory from post left join category on post.idCategory = category.id where post.id = ?";
    protected  final String DELETE = "delete from post where post.id = ? ";
    protected final String FINDBYCATEGORY = "select post.id as id, title, fullContent, shortContent, publishDate, image, idCategory, nameCategory from post left join category on post.idCategory = category.id where post.idCategory = ?";


    @Override
    public List<Post> showAll() throws SQLException {
        List<Post> poList = new ArrayList<>();
        try(PreparedStatement statement = connectionService.getConnection().prepareStatement(SELECT_ALL)){
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
        try(PreparedStatement statement = connectionService.getConnection().prepareStatement(INSERT_POST)) {
            statement.setString(1, data.getTitle());
            statement.setString(2, data.getFullContent());
            statement.setString(3, data.getShortContent());
            statement.setString(4, data.getImage());
            statement.setInt(5,data.getCategory().getId());

            statement.executeUpdate();

        }catch (Exception e){
            e.getMessage();
        }

    }


    @Override
    public void update(Post data, int id) throws SQLException {
        try(PreparedStatement statement = connectionService.getConnection().prepareStatement(UPDATE_POST))
        {
            statement.setString(1, data.getTitle());
            statement.setString(2, data.getFullContent());
            statement.setString(3, data.getShortContent());
            statement.setString(4, data.getImage());
            statement.setInt(5,data.getCategory().getId());
            statement.setInt(6,id);

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

    public List<Post> showByCategory(int cateID) throws SQLException{
        List<Post> poList = new ArrayList<>();
        try(PreparedStatement statement = connectionService.getConnection().prepareStatement(FINDBYCATEGORY)){
            statement.setInt(1,cateID);
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
