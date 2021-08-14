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

/**
 * Through the data access layer, this class gets user by username from the
 * database and inserts user to the database by calling methods from UserDAO's
 * object and handles the register process. After that, this class will forward
 * to "Register.jsp". This class will push to error page if any error occurs.
 * <p>
 * Bugs:none
 *
 * @author Nguyen Khanh Duy
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

    /**
     * This method will forward to "Register.jsp". This method will push to
     * error page if any error occurs. Processes requests for both HTTP
     * <code>GET</code> and <code>POST</code> methods.
     *
     * @param request stores attributes error, errorDetail and forward to
     * "Register.jsp". It is a
     * <code>javax.servlet.http.HttpServletRequest</code>
     * @param response is used to response the request of HTTP request. It is a
     * <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.getRequestDispatcher("Register.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            request.setAttribute("error", "The page you’re looking for can’t be found.");
            request.setAttribute("errorDetail", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    /**
     * This method gets user by username from the database and inserts user to
     * the database by calling methods from UserDAO's object and handles the
     * register process. If user is not null or input fields are empty then this
     * method will forward to "Register.jsp" with an error message. Otherwise,
     * this method inserts user into the database and then forward to
     * "Register.jsp". This method will push to error page if any error occurs.
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request stores attributes message, error, errorDetail,
     * savedUserName, savedType, savedEmail and send to a web page. It is a
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
            String email = request.getParameter("email").trim();
            int type = Integer.parseInt(request.getParameter("type").trim());

            if (userName.isEmpty() || password.isEmpty() || email.isEmpty()) {
                request.setAttribute("message", "Sorry, you must fill in all the field.");
            } else if (userName.length() > 20) {
                request.setAttribute("message", "Username must be less than 20 characters.");
            } else if (password.length() > 100) {
                request.setAttribute("message", "Password must be less than 100 characters.");
            } else if (email.length() > 30) {
                request.setAttribute("message", "Email must be less than 30 characters.");
            } else if (userDAO.getUserByUserName(userName) != null) {
                request.setAttribute("message", "Sorry, username is already taken. Please try again.");
            } else {
                userDAO.insertUser(new User(userName, password, email, type));
                request.setAttribute("message", "Register an account successfully.");
            }
            request.setAttribute("savedUserName", userName);
            request.setAttribute("savedType", type);
            request.setAttribute("savedEmail", email);
            request.getRequestDispatcher("Register.jsp").forward(request, response);
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
