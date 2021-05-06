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

@WebServlet(name = "AdminAddCategoryServlet", urlPatterns = "/addCategory")
public class AdminAddCategoryServlet extends HttpServlet {
    CategoryService categoryService = new CategoryService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String categoryName = request.getParameter("category");
        HttpSession session = request.getSession();

        String userName = (String) session.getAttribute("username");
        String fullName = (String) session.getAttribute("fullname");

        Category category = new Category(categoryName);

        try {
            categoryService.insert(category);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("mess", "Done...!!!");
        request.setAttribute("userName",userName);
        request.setAttribute("fullName",fullName);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-assets/addCategory.jsp");
        dispatcher.forward(request, response);
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


        request.setAttribute("userName",userName);
        request.setAttribute("fullName",fullName);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-assets/addCategory.jsp");
        dispatcher.forward(request, response);
    }
}
