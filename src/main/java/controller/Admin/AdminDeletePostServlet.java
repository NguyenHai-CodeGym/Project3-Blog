package controller.Admin;

import model.Post;
import service.admin.PostService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminDeletePostServlet", urlPatterns = "/deletePost")
public class AdminDeletePostServlet extends HttpServlet {
    PostService postService = new PostService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Post> postList = null;

        postService.delete(id);
        postList = postService.showAll();

        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-assets/dashboard.jsp");
        request.setAttribute("list",postList);
        dispatcher.forward(request,response);
    }catch (Exception e){
        response.sendRedirect("/error404");
    }
    }
}
