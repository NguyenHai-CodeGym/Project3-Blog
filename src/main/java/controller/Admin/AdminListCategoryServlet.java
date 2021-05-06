package controller.Admin;

import model.Category;
import service.admin.CategoryService;

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

@WebServlet(name = "AdminListCategoryServlet", urlPatterns = "/listCategory")
public class AdminListCategoryServlet extends HttpServlet {
    CategoryService categoryService = new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String userName = (String) session.getAttribute("username");
        String fullName = (String) session.getAttribute("fullname");
        if (userName == null || userName.isEmpty()){
            RequestDispatcher dispatcher = request.getRequestDispatcher("admin-assets/login.jsp");
            dispatcher.forward(request,response);
            return;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-assets/list-Category.jsp");
        List<Category> categoryList = null;

        try {
            categoryList = categoryService.showAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("userName",userName);
        request.setAttribute("fullName",fullName);
        request.setAttribute("category",categoryList);
        dispatcher.forward(request,response);
    }
}
