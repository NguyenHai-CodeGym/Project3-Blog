package controller.Admin;

import model.Post;
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

@WebServlet(name = "DashBoardServlet", urlPatterns = "/dashboard")
public class DashBoardServlet extends HttpServlet {
    PostService postService = new PostService();
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-assets/dashboard.jsp");
        List<Post> postList = null;
        try {
            postList = postService.showAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("userName",userName);
        request.setAttribute("fullName",fullName);
        request.setAttribute("list",postList);
        dispatcher.forward(request,response);
    }
}
