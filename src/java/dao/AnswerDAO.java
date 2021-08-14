/*
 * Copyright(C) 2021, FPT University.
 * J3.L.P0001
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-07-15      1.0                 DuyNKHE140102    First Implement
 */
package dao;

import entity.Answer;
import java.util.List;

/**
 * This interface provides methods to query the necessary data from Answer table
 * in the database. <code>java.lang.Exception</code> throws when error occurs
 * <p>
 * Bugs: none
 *
 * @author Nguyen Khanh Duy
 */
public interface AnswerDAO {

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
    public List<Answer> getListAnswersById(int questionId) throws Exception;

    /**
     * This method gets a list id of correct answers from the database with a
     * specify id of question. The result contain a list id of correct answers.
     *
     * @param questionId the id of question. It is an int number.
     * @return a list id of correct answers. It is a <code>java.util.List</code>
     * object.
     * @throws Exception if querying informations from database is error.
     */
    public List<Integer> getListCorrectAnswersById(int questionId) throws Exception;
}
