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
 * Through the data access layer, this class gets list of questions from the
 * database by calling methods from QuesstionDAO's object and handles the paging
 * process. After that, this class will push all the data to "ManageQuiz.jsp".
 * This class will push to error page if any error occurs.
 * <p>
 * Bugs:none
 *
 * @author Nguyen Khanh Duy
 */
@WebServlet(name = "ManageQuizController", urlPatterns = {"/managequiz"})
public class ManageQuizController extends HttpServlet {

    /**
     * This method gets list of questions from the database by calling methods
     * from QuestionDAO's object and handles the paging process then push all
     * the data to "ManageQuiz.jsp". This method will push to error page if any
     * error occurs. Processes requests for both HTTP <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request stores attributes error, errorDetail, listQuestionPaging,
     * lastPage, totalQuestion, index and send to a web page. It is a
     * <code>javax.servlet.http.HttpServletRequest</code>
     * @param response is used to response the request of HTTP request. It is a
     * <code>javax.servlet.http.HttpServletResponse</code>
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            QuestionDAO questionDAO = new QuestionDAOImpl();
            String pageIndex = request.getParameter("index");
            int index = (pageIndex != null) ? Integer.parseInt(pageIndex) : 1;
            int totalQuestion = questionDAO.countQuestion();
            int pageSize = 3;
            int lastPage = totalQuestion / pageSize;
            //Maximum number of page that website can display
            if (totalQuestion % pageSize != 0) {
                lastPage++;
            }

            if (index > lastPage || index < 1) {
                request.setAttribute("error", "The page you’re looking for can’t be found.");
                request.getRequestDispatcher("Error.jsp").forward(request, response);
            }

            List<Question> listQuestionPaging = questionDAO.getListQuestionPaging(index, pageSize);

            request.setAttribute("listQuestionPaging", listQuestionPaging);
            request.setAttribute("lastPage", lastPage);
            request.setAttribute("index", index);
            request.setAttribute("totalQuestion", totalQuestion);

            request.getRequestDispatcher("ManageQuiz.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "The page you’re looking for can’t be found.");
            request.setAttribute("errorDetail", e.getMessage());
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * This method gets list of questions from the database by calling methods
     * from QuestionDAO's object and handles the paging process then push all
     * the data to "ManageQuiz.jsp". This method will push to error page if any
     * error occurs. Processes requests for both HTTP <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request stores attributes error, errorDetail, listQuestionPaging,
     * lastPage, totalQuestion, index and send to a web page. It is a
     * <code>javax.servlet.http.HttpServletRequest</code>
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
     * This method gets list of questions from the database by calling methods
     * from QuestionDAO's object and handles the paging process then push all
     * the data to "ManageQuiz.jsp". This method will push to error page if any
     * error occurs. Processes requests for both HTTP <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request stores attributes error, errorDetail, listQuestionPaging,
     * lastPage, totalQuestion, index and send to a web page. It is a
     * <code>javax.servlet.http.HttpServletRequest</code>
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
