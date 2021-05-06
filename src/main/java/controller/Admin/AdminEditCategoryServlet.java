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

@WebServlet(name = "AdminEditCategoruServlet", urlPatterns = "/editCategory")
public class AdminEditCategoryServlet extends HttpServlet {
    CategoryService categoryService = new CategoryService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
           response.setContentType("text/html;charset=UTF-8");
           request.setCharacterEncoding("utf-8");

           HttpSession session = request.getSession();

           String userName = (String) session.getAttribute("username");
           String fullName = (String) session.getAttribute("fullname");

           int id = Integer.parseInt(request.getParameter("cateId"));
           String categoryName = request.getParameter("categoryName");

           Category category = new Category(categoryName);

           categoryService.update(category,id);


           request.setAttribute("mess", "Done...!!!");
           request.setAttribute("userName",userName);
           request.setAttribute("fullName",fullName);
           request.setAttribute("category",category);

           RequestDispatcher dispatcher = request.getRequestDispatcher("admin-assets/editCategory.jsp");
           dispatcher.forward(request, response);
       }catch (Exception e){
           response.sendRedirect("/error404");
       }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try {
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

          int id = Integer.parseInt(request.getParameter("id"));
          Category category = null;


          category = categoryService.findByID(id);

          RequestDispatcher dispatcher = request.getRequestDispatcher("admin-assets/editCategory.jsp");
          request.setAttribute("category",category);
          request.setAttribute("userName",userName);
          request.setAttribute("fullName",fullName);
          dispatcher.forward(request, response);
      }catch (Exception e){
          response.sendRedirect("/error404");
      }
    }
}
