/*
 * Copyright(C) 2021, FPT University.
 * J3.L.P0001
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-07-15      1.0                 DuyNKHE140102    First Implement
 */
package controller;

import dao.QuestionDAO;
import dao.impl.QuestionDAOImpl;
import entity.Question;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Through the data access layer, this class gets the total number of questions
 * and list of questions from the database by calling methods from QuestionDAO's
 * object. After that, this class will push all the data to "TakeQuiz.jsp". This
 * class will push to error page if any error occurs.
 * <p>
 * Bugs:none
 *
 * @author Nguyen Khanh Duy
 */
@WebServlet(name = "TakeQuizController", urlPatterns = {"/takequiz"})
public class TakeQuizController extends HttpServlet {

    /**
     * This method gets the total number of questions in the database by calling
     * methods from QuestionDAO's object. After that, this class will push all
     * the data to "TakeQuiz.jsp" This method will push to error page if any
     * error occurs. Processes requests for both HTTP <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request stores attributes error, errorDetail, maxQuiz, status and
     * send to a web page. It is a
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
            QuestionDAO questionDAO = new QuestionDAOImpl();
            request.setAttribute("maxQuiz", questionDAO.countQuestion());
            request.setAttribute("status", "start");
            request.getRequestDispatcher("TakeQuiz.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "The page you’re looking for can’t be found.");
            request.setAttribute("errorDetail", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    /**
     * This method gets list of questions in the database by calling methods
     * from QuestionDAO's object. After that, this class will push all the data
     * to "TakeQuiz.jsp" This method will push to error page if any error
     * occurs. Processes requests for both HTTP <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request stores attributes error, errorDetail, numberOfQuestion,
     * questions, status and send to a web page. It is a
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
            QuestionDAO questionDAO = new QuestionDAOImpl();
            int numberOfQuestion = Integer.parseInt(request.getParameter("numOfQuiz"));
            if (numberOfQuestion > questionDAO.countQuestion()) {
                request.setAttribute("message", "There are only "
                        + questionDAO.countQuestion()
                        + " questions. Please choose another number.");
                request.setAttribute("status", "start");
                request.getRequestDispatcher("TakeQuiz.jsp").forward(request, response);
                return;
            }

            List<Question> listQuestions = questionDAO.getListQuestionsByNumber(numberOfQuestion);

            request.setAttribute("numberOfQuestion", numberOfQuestion);
            request.setAttribute("questions", listQuestions);
            request.setAttribute("status", "process");
            request.getRequestDispatcher("TakeQuiz.jsp").forward(request, response);
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
