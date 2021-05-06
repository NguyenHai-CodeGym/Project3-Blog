package controller.Blog;

import model.Category;
import model.Post;
import service.admin.CategoryService;
import service.admin.PostService;
import service.blog.BlogService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BlogCategoryServlet", urlPatterns = "/categoryBlog")
public class BlogCategoryServlet extends HttpServlet {
    BlogService blogService = new BlogService();
    PostService postService = new PostService();
    CategoryService categoryService = new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
           int cateId = Integer.parseInt(request.getParameter("id"));
           RequestDispatcher dispatcher = request.getRequestDispatcher("category-blog.jsp");
           List<Category> categoryList = null;
           List<Post> postList = null;
           List<Post> postListByCategory = null;


           categoryList = categoryService.showAll();
           postList = blogService.showAll();
           postListByCategory = postService.showByCategory(cateId);


           request.setAttribute("categoryList",categoryList);
           request.setAttribute("list",postList);
           request.setAttribute("listByCate",postListByCategory);
           dispatcher.forward(request,response);
       }catch (Exception e){
           response.sendRedirect("/error404Blog");
       }
    }
}
