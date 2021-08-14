/*
 * Copyright(C) 2021, FPT University.
 * J3.L.P0001
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-07-15      1.0                 DuyNKHE140102    First Implement
 */
package controller;

import dao.AnswerDAO;
import dao.impl.AnswerDAOImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Through the data access layer, this class gets list of correct answers by id
 * from the database by calling methods from AnswerDAO's object and handles the
 * grading quiz process. After that, this class will push all the data to
 * "QuizResult.jsp". This class will push to error page if any error occurs.
 * <p>
 * Bugs:none
 *
 * @author Nguyen Khanh Duy
 */
@WebServlet(name = "ResultController", urlPatterns = {"/result"})
public class ResultController extends HttpServlet {

    /**
     * This method gets list of correct answers by id from the database by
     * calling methods from AnswerDAO's object. This method handles the grading
     * quiz process by checking if the answers user chooses is in the list of
     * correct answers or not. After that this method will calculate the score
     * and push all the data to "QuizResult.jsp". This method will push to error
     * page if any error occurs. Processes requests for both HTTP
     * <code>GET</code> and <code>POST</code> methods.
     *
     * @param request stores attributes error, errorDetail, score and send to a
     * web page. It is a <code>javax.servlet.http.HttpServletRequest</code>
     * @param response is used to response the request of HTTP request. It is a
     * <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            AnswerDAO answerDAO = new AnswerDAOImpl();
            String[] questionIds = request.getParameterValues("questionId");
            int totalCorrectAnswer = 0;

            for (String questionId : questionIds) {
                List<Integer> listCorrectAnswersId = answerDAO.getListCorrectAnswersById(Integer.parseInt(questionId));
                String[] answerIds = request.getParameterValues("answers_" + questionId);

                if (answerIds == null || listCorrectAnswersId.size() != answerIds.length) {
                    continue;
                }

                boolean isCorrect = false;
                for (String answerId : answerIds) {
                    if (!listCorrectAnswersId.contains(Integer.parseInt(answerId))) {
                        isCorrect = false;
                        break;
                    } else {
                        isCorrect = true;
                    }
                }
                if (isCorrect) {
                    totalCorrectAnswer += 1;
                }
            }

            float score = (float) totalCorrectAnswer / questionIds.length * 10;
            request.setAttribute("score", score);
            request.getRequestDispatcher("QuizResult.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "The page you’re looking for can’t be found.");
            request.setAttribute("errorDetail", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * This method gets list of correct answers by id from the database by
     * calling methods from AnswerDAO's object. This method handles the grading
     * quiz process by checking if the answers user chooses is in the list of
     * correct answers or not. After that this method will calculate the score
     * and push all the data to "QuizResult.jsp". This method will push to error
     * page if any error occurs. Processes requests for both HTTP
     * <code>GET</code> and <code>POST</code> methods.
     *
     * @param request stores attributes error, errorDetail, score and send to a
     * web page. It is a <code>javax.servlet.http.HttpServletRequest</code>
     * @param response is used to response the request of HTTP request. It is a
     * <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * This method gets list of correct answers by id from the database by
     * calling methods from AnswerDAO's object. This method handles the grading
     * quiz process by checking if the answers user chooses is in the list of
     * correct answers or not. After that this method will calculate the score
     * and push all the data to "QuizResult.jsp". This method will push to error
     * page if any error occurs. Processes requests for both HTTP
     * <code>GET</code> and <code>POST</code> methods.
     *
     * @param request stores attributes error, errorDetail, score and send to a
     * web page. It is a <code>javax.servlet.http.HttpServletRequest</code>
     * @param response is used to response the request of HTTP request. It is a
     * <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
