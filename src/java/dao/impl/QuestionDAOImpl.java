/*
 * Copyright(C) 2021, FPT University.
 * J3.L.P0001
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-07-15      1.0                 DuyNKHE140102    First Implement
 */
package dao.impl;

import context.DBContext;
import dao.AnswerDAO;
import dao.QuestionDAO;
import entity.Answer;
import entity.Question;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is an implementation of the QuestionDAO interface and extends
 * DBContext class. This class has methods to query the necessary data from
 * Question table in the database. The method will throw an object of
 * <code>java.lang.Exception</code> class if there is any error while querying
 * the data.
 * <p>
 * Bugs:none
 *
 * @author Nguyen Khanh Duy
 */
public class QuestionDAOImpl extends DBContext implements QuestionDAO {

    /**
     * This method counts the total number of Question from the database. The
     * result is the total number of Question from the database.
     *
     * @return the total number of Question. It is an int number.
     * @throws Exception if querying informations from database is error
     */
    @Override
    public int countQuestion() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int totalQuestion = 0;
        String sql = "select count(*) from Question";
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                totalQuestion = rs.getInt(1);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConntection(con);
        }
        return totalQuestion;
    }

    /**
     * This method gets paged list of all Questions matching the pageIndex and
     * pageSize condition. The result contain a list of <code>Question</code>
     * objects with id, question and createdAt attributes.
     *
     * @param pageIndex the index of page that currently display. It is an int
     * number.
     * @param pageSize the total number of Questions that will be displayed on a
     * page. It is an int number.
     * @return a list of <code>Question</code> objects. It is a
     * <code>java.util.List</code> object.
     * @throws Exception if querying informations from database is error
     */
    @Override
    public List<Question> getListQuestionPaging(int pageIndex, int pageSize) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Question> listQuestions = new ArrayList<>();
        String sql = "select * from Question order by id "
                + "offset ? rows fetch next ? rows only";
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pageSize * (pageIndex - 1));
            ps.setInt(2, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String question = rs.getString("question");
                Date createdAt = rs.getDate("createdAt");
                listQuestions.add(new Question(id, question, createdAt));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConntection(con);
        }
        return listQuestions;
    }

    /**
     * This method inserts Question into the Question table in the database.
     *
     * @param question is the <code>Question</code> object.
     * @throws Exception if querying informations from database is error
     */
    @Override
    public void insertQuestion(Question question) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "insert into [Question] values (?,?)";
        try {
            con = getConnection();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, question.getQuestionContent());
            ps.setDate(2, question.getCreatedAt());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            int questionId = 0;
            if (rs.next()) {
                questionId = rs.getInt(1);
            }
            for (Answer answer : question.getListAnswers()) {
                sql = "insert into [Answer] values (?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1, questionId);
                ps.setString(2, answer.getAnswerContent());
                ps.setInt(3, answer.getCorrectAnswer());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConntection(con);
        }
    }

    /**
     * This method gets a list of Questions from database with a specific number
     * of questions. The result contain a list of <code>Question</code> objects
     * with id, question and createdAt attributes.
     *
     * @param top number of questions will be return. It is an int number.
     * @return a list of <code>Question</code> objects. It is a
     * <code>java.util.List</code> object.
     * @throws Exception if querying informations from database is error.
     */
    @Override
    public List<Question> getListQuestionsByNumber(int top) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Question> listQuestions = new ArrayList<>();
        String sql = "select TOP (?) * from [Question]";
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, top);
            rs = ps.executeQuery();
            AnswerDAO answerDAO = new AnswerDAOImpl();
            while (rs.next()) {
                int id = rs.getInt("id");
                String question = rs.getString("question");
                Date createAt = rs.getDate("createdAt");
                listQuestions.add(new Question(id, question, createAt, answerDAO.getListAnswersById(id)));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConntection(con);
        }
        return listQuestions;
    }

}
