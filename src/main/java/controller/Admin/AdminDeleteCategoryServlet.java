package controller.Admin;

import model.Category;
import service.admin.CategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminDeleteCategoryServlet", urlPatterns = "/deleteCategory")
public class AdminDeleteCategoryServlet extends HttpServlet {
    CategoryService categoryService = new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Category> categoryList = null;


        categoryService.delete(id);
        categoryList = categoryService.showAll();


        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-assets/list-Category.jsp");
        request.setAttribute("category",categoryList);
        dispatcher.forward(request,response);
    }catch (Exception e){
        response.sendRedirect("/error404");
    }
    }
}
