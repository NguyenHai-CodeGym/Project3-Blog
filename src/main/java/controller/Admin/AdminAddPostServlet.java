package controller.Admin;

import model.Category;
import model.Post;
import service.admin.CategoryService;
import service.admin.PostService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminAddPostServlet", urlPatterns = "/addPost")
public class AdminAddPostServlet extends HttpServlet {
    CategoryService categoryService = new CategoryService();
    PostService postService = new PostService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();

        String userName = (String) session.getAttribute("username");
        String fullName = (String) session.getAttribute("fullname");

        String title = request.getParameter("title");
        String fullContent = request.getParameter("fullContent");
        String shortContent = request.getParameter("shortContent");
        String image = request.getParameter("image");
        int categoryId = Integer.parseInt(request.getParameter("category"));

        Category category = new Category(categoryId);
        Post post = new Post(title,fullContent,shortContent,image,category);
        try {
            postService.insert(post);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-assets/addPost.jsp");
        request.setAttribute("mess","Done....!!!");
        request.setAttribute("userName",userName);
        request.setAttribute("fullName",fullName);
        dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");


        HttpSession session = request.getSession();

        String userName = (String) session.getAttribute("username");
        String fullName = (String) session.getAttribute("fullname");
        if (userName == null || userName.isEmpty()){
            RequestDispatcher dispatcher = request.getRequestDispatcher("admin-assets/login.jsp");
            dispatcher.forward(request,response);
            return;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-assets/addPost.jsp");
        List<Category> categoryList = null;

        try {
            categoryList = categoryService.showAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("categorylist",categoryList);
        request.setAttribute("userName",userName);
        request.setAttribute("fullName",fullName);
        dispatcher.forward(request,response);
    }
}
