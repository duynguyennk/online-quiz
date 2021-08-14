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
import entity.Answer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is an implementation of the AnswerDAO interface and extends
 * DBContext class. This class has methods to query the necessary data from
 * Answer table in the database. The method will throw an object of
 * <code>java.lang.Exception</code> class if there is any error while querying
 * the data.
 * <p>
 * Bugs:none
 *
 * @author Nguyen Khanh Duy
 */
public class AnswerDAOImpl extends DBContext implements AnswerDAO {

    /**
     * This method gets a list of answers from the database with a specify id of
     * question. The result contain a list of <code>Answer</code> objects with
     * id, answer attributes.
     *
     * @param questionId the id of question. It is an int number.
     * @return a list of <code>Answer</code> objects. It is a
     * <code>java.util.List</code> object.
     * @throws Exception if querying informations from database is error.
     */
    @Override
    public List<Answer> getListAnswersById(int questionId) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Answer> listAnswers = new ArrayList<>();
        String sql = "select * from [Answer] where questionId = ?";
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, questionId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String answer = rs.getString("answer");
                listAnswers.add(new Answer(id, answer));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConntection(con);
        }
        return listAnswers;
    }

    /**
     * This method gets a list id of correct answers from the database with a
     * specify id of question. The result contain a list id of correct answers.
     *
     * @param questionId the id of question. It is an int number.
     * @return a list id of correct answers. It is a <code>java.util.List</code>
     * object.
     * @throws Exception if querying informations from database is error.
     */
    @Override
    public List<Integer> getListCorrectAnswersById(int questionId) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Integer> listAnswers = new ArrayList<>();
        String sql = "select * from [Answer] where questionId = ? and correct_answer = 1";
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, questionId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                listAnswers.add(id);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(ps);
            closeConntection(con);
        }
        return listAnswers;
    }

}
