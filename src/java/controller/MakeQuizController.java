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
import entity.Answer;
import entity.Question;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Through the data access layer, this class inserts question into the database
 * by calling methods from QuestionDAO's object and handles the making quiz
 * process; gets values of parameter question, options, answers from the HTTP
 * request. After that, this class will forward to "MakeQuiz.jsp". This class
 * will push to error page if any error occurs.
 * <p>
 * Bugs:none
 *
 * @author Nguyen Khanh Duy
 */
@WebServlet(name = "MakeQuizController", urlPatterns = {"/makequiz"})
public class MakeQuizController extends HttpServlet {

    /**
     * This method will forward to "MakeQuiz.jsp". This method will push to
     * error page if any error occurs. Processes requests for both HTTP
     * <code>GET</code> and <code>POST</code> methods.
     *
     * @param request stores attributes error, errorDetai and forward to
     * "MakeQuiz.jsp". It is a
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
            request.getRequestDispatcher("MakeQuiz.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            request.setAttribute("error", "The page you’re looking for can’t be found.");
            request.setAttribute("errorDetail", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    /**
     * This method insert question to the database by calling methods from
     * QuestionDAO's object and handles the making quiz process. If input fields
     * are empty then this method will forward to "MakeQuiz.jsp". This method
     * will push to error page if any error occurs. Processes requests for both
     * HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request stores attributes message, error, errorDetail,
     * savedQuestions, savedOptions and send to a web page. It is a
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
            boolean isValid = true;
            List<Answer> listAnswers = new ArrayList<>();
            QuestionDAO questionDAO = new QuestionDAOImpl();

            String questionContent = request.getParameter("question").trim();
            String[] options = request.getParameterValues("options");
            String[] trimmedOptions = new String[options.length];
            for (int i = 0; i < options.length; i++) {
                trimmedOptions[i] = options[i].trim();
            }
            String[] correctOptions = request.getParameterValues("answers");
            Date currentDate = new Date(new java.util.Date().getTime());

            if (correctOptions == null) {
                request.setAttribute("message", "Answer must not be empty. Please choose your answer.");
                isValid = false;
            } else if (correctOptions.length == 4) {
                request.setAttribute("message", "Maximum answers can be choose is 3. Please try again.");
                isValid = false;
            }

            for (String option : trimmedOptions) {
                if (option.isEmpty()) {
                    request.setAttribute("message", "Option must not be empty. Please enter your option.");
                    isValid = false;
                } else if (option.length() > 100) {
                    request.setAttribute("message", "Option must be less than 100 characters.");
                    isValid = false;
                }
            }

            if (questionContent.isEmpty()) {
                request.setAttribute("message", "Question must not be empty. Please enter your question.");
                isValid = false;
            } else if (questionContent.length() > 100) {
                request.setAttribute("message", "Question must be less than 100 characters.");
                isValid = false;
            }

            if (!isValid) {
                request.setAttribute("savedQuestion", questionContent);
                request.setAttribute("savedOptions", trimmedOptions);
                request.setAttribute("savedAnswer", correctOptions);
                request.getRequestDispatcher("MakeQuiz.jsp").forward(request, response);
            } else {
                for (int i = 0; i < trimmedOptions.length; i++) {
                    int correct = 0;
                    for (String correctOption : correctOptions) {
                        if (Integer.parseInt(correctOption) == i + 1) {
                            correct = 1;
                            break;
                        } else {
                            correct = 0;
                        }
                    }
                    listAnswers.add(new Answer(trimmedOptions[i], correct));
                }

                questionDAO.insertQuestion(new Question(questionContent, currentDate, listAnswers));
                request.setAttribute("message", "Create question successfully.");
                request.getRequestDispatcher("MakeQuiz.jsp").forward(request, response);
            }

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
