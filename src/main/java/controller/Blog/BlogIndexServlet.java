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

@WebServlet(name = "BlogIndexServlet", urlPatterns = "/indexBlog")
public class BlogIndexServlet extends HttpServlet {
    BlogService blogService = new BlogService();
    PostService postService = new PostService();
    CategoryService categoryService = new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        List<Post> postList = null;
        List<Post> allList = null;
        List<Category> categoryList = null;
        List<Post> listPostRamdom = null;

        try {
            postList = blogService.showAll();
            allList = postService.showAll();
            categoryList = categoryService.showAll();
            listPostRamdom = blogService.selectRamDom();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("list",postList);
        request.setAttribute("allList",allList);
        request.setAttribute("categoryList",categoryList);
        request.setAttribute("listRamdoms",listPostRamdom);
        dispatcher.forward(request,response);


    }
}
