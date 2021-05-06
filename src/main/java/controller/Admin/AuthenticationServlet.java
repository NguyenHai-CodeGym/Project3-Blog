package controller.Admin;

import model.User;
import service.admin.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AuthenticationServlet", urlPatterns = "/authentication")
public class AuthenticationServlet extends HttpServlet {
    UserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("name");
    String password = request.getParameter("password");

        User user = userService.findByUserAndPass(username,password);
        try {
            if (user != null){
                HttpSession session = request.getSession();
                session.setAttribute("username",user.getUsername());
                session.setAttribute("user",user);
                session.setAttribute("fullname", user.getFullname());
                response.sendRedirect("dashboard");
            }else {
                response.sendRedirect("/authentication");
                request.setAttribute("mess","Username , Password could wrong, please try again!!");
                showLogin(request,response);
            }
        }catch (Exception e){
            e.getMessage();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action == null){
        action = "login";
    }
    switch (action){
        case "login":
            showLogin(request,response);
            break;
        case "logout":
            showLogout(request,response);
            break;
    }
    }

    private void showLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-assets/login.jsp");
        dispatcher.forward(request,response);
    }

    private void showLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        session.invalidate();
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-assets/login.jsp");
        dispatcher.forward(request,response);
    }
}
