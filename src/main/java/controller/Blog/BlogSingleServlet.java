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

@WebServlet(name = "BlogSingleServlet", urlPatterns = "/blogSingle")
public class BlogSingleServlet extends HttpServlet {
    BlogService blogService = new BlogService();
    PostService postService = new PostService();
    CategoryService categoryService = new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try {
          RequestDispatcher dispatcher = request.getRequestDispatcher("blog-single.jsp");
          List<Category> categoryList = null;
          List<Post> listNewPost = null;
          Post postSingle = null;

          int idblog = Integer.parseInt(request.getParameter("id"));


          categoryList = categoryService.showAll();
          listNewPost  = blogService.showAll();
          postSingle = blogService.findByID(idblog);


          request.setAttribute("categoryList",categoryList);
          request.setAttribute("listNewPost",listNewPost);
          request.setAttribute("blogSingle", postSingle);
          dispatcher.forward(request,response);
      }catch (Exception e){
          response.sendRedirect("/error404Blog");
      }
    }
}
