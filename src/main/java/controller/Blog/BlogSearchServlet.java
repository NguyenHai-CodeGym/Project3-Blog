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

@WebServlet(name = "BlogSearchServlet", urlPatterns = "/searchBlog")
public class BlogSearchServlet extends HttpServlet {
    BlogService blogService = new BlogService();
    PostService postService = new PostService();
    CategoryService categoryService = new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String title = request.getParameter("search");

        List<Post> postListSearch = null;
        List<Category> categoryList = null;
        List<Post> postList = null;

        try {
            postListSearch = blogService.selectSearch(title);
            categoryList = categoryService.showAll();
            postList = blogService.showAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (postListSearch.size() < 1){
            RequestDispatcher dispatcher = request.getRequestDispatcher("search-blog.jsp");
            request.setAttribute("mess","Không Tìm Thấy Bài Đăng Nào");
            request.setAttribute("categoryList",categoryList);
            request.setAttribute("list",postList);
            dispatcher.forward(request,response);
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("search-blog.jsp");
            request.setAttribute("listSearch",postListSearch);
            request.setAttribute("categoryList",categoryList);
            request.setAttribute("list",postList);

            dispatcher.forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("search-blog.jsp");
        dispatcher.forward(request,response);


    }
}
