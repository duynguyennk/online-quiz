/*
 * Copyright(C) 2021, FPT University.
 * J3.L.P0001
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-07-15      1.0                 DuyNKHE140102    First Implement
 */
package dao;

import entity.Question;
import java.util.List;

/**
 * This interface provides methods to query the necessary data from Question
 * table in the database. <code>java.lang.Exception</code> throws when error
 * occurs
 * <p>
 * Bugs: none
 *
 * @author Nguyen Khanh Duy
 */
public interface QuestionDAO {

    /**
     * This method counts the total number of Question from the database. The
     * result is the total number of Question from the database.
     *
     * @return the total number of Question. It is an int number.
     * @throws Exception if querying informations from database is error
     */
    public int countQuestion() throws Exception;

    /**
     * This method inserts Question into the Question table in the database.
     *
     * @param question is the <code>Question</code> object.
     * @throws Exception if querying informations from database is error
     */
    public void insertQuestion(Question question) throws Exception;

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
    public List<Question> getListQuestionsByNumber(int top) throws Exception;

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
    public List<Question> getListQuestionPaging(int pageIndex, int pageSize) throws Exception;
}
