/*
 * Copyright(C) 2021, FPT University.
 * J3.L.P0001
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-07-15      1.0                 DuyNKHE140102    First Implement
 */
package controller;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import entity.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Through the data access layer, this class gets user by username from the
 * database by calling methods from UserDAO's object and handles the login
 * process. After that, this class will forward to "Home.jsp". This class will
 * push to error page if any error occurs.
 * <p>
 * Bugs:none
 *
 * @author Nguyen Khanh Duy
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    /**
     * This method will forward to "Login.jsp". This method will push to error
     * page if any error occurs. Processes requests for both HTTP
     * <code>GET</code> and <code>POST</code> methods.
     *
     * @param request stores attributes error, errorDetail and forward to
     * "Login.jsp". It is a <code>javax.servlet.http.HttpServletRequest</code>
     * @param response is used to response the request of HTTP request. It is a
     * <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            request.setAttribute("error", "The page you’re looking for can’t be found.");
            request.setAttribute("errorDetail", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    /**
     * This method gets user by username from the database by calling methods
     * from UserDAO's object and handles the login process. If user is null or
     * input fields are empty then this method will forward to "Login.jsp".
     * Otherwise, this method creates a session and bind user's object to this
     * session then forward to "Home.jsp". This method will push to error page
     * if any error occurs. Processes requests for both HTTP <code>GET</code>
     * and <code>POST</code> methods.
     *
     * @param request stores attributes message, error, errorDetail,
     * savedUserName and send to a web page. It is a
     * <code>javax.servlet.http.HttpServletRequest</code>
     * @param response is used to response the request of HTTP request. It is a
     * <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UserDAO userDAO = new UserDAOImpl();
            String userName = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();

            if (userName.isEmpty() || password.isEmpty()) {
                request.setAttribute("message", "Username or password can not empty.");
            } else if (userName.length() > 20) {
                request.setAttribute("message", "Username must be less than 20 characters.");
            } else if (password.length() > 100) {
                request.setAttribute("message", "Password must be less than 100 characters.");
            } else {
                User user = userDAO.getUserByUserName(userName);
                if (user == null) {
                    request.setAttribute("message", "Sorry, your username does not exist.");
                } else if (!user.getPassword().equals(password)) {
                    request.setAttribute("message", "Wrong password. Please try again");
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("Home.jsp").include(request, response);
                    return;
                }
            }
            request.setAttribute("savedUserName", userName);
            request.getRequestDispatcher("Login.jsp").include(request, response);

        } catch (Exception e) {
            request.setAttribute("error", "The page you’re looking for can’t be found.");
            request.setAttribute("errorDetail", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
