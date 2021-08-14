/*
 * Copyright(C) 2021, FPT University.
 * J3.L.P0001
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-07-15      1.0                 DuyNKHE140102    First Implement
 */
package entity;

import java.sql.Date;
import java.util.List;

/**
 * The <code>Question</code> class represents character of
 * <code>Question</code>. The class contains constructor, getter, setter,
 * toString of <code>Question</code> object.
 * <p>
 * Bugs: none
 *
 * @author Nguyen Khanh Duy
 */
public class Question {

    private int id;
    private String questionContent;
    private Date createdAt;
    private List<Answer> listAnswers;

    /**
     * Initializes a newly created <code>Question</code> object from a
     * parameterless constructor
     */
    public Question() {
    }

    /**
     * Constructs an <code>Question</code> object with the given id,
     * questionContent, createdAt attributes.
     *
     * @param id is the id of the <code>Question</code>. It is an int number.
     * @param question is the questionContent of the <code>Question</code>. It
     * is a <code>java.lang.String</code>.
     * @param createdAt is the date of the <code>Question</code>. It is a
     * <code>java.sql.Date</code>
     */
    public Question(int id, String question, Date createdAt) {
        this.id = id;
        this.questionContent = question;
        this.createdAt = createdAt;
    }

    /**
     * Constructs an <code>Question</code> object with the given id,
     * questionContent, createdAt, listAnswers attributes.
     *
     * @param id is the id of the <code>Question</code>. It is an int number.
     * @param question is the questionContent of the <code>Question</code>. It
     * is a <code>java.lang.String</code>.
     * @param createdAt is the date of the <code>Question</code>. It is a
     * <code>java.sql.Date</code>
     * @param answers is a list of listAnswers of the <code>Question</code>. It
     * is a <code>java.util.List</code>
     */
    public Question(int id, String question, Date createdAt, List<Answer> answers) {
        this.id = id;
        this.questionContent = question;
        this.createdAt = createdAt;
        this.listAnswers = answers;
    }

    /**
     * Constructs an <code>Question</code> object with the given
     * questionContent, createdAt, listAnswers attributes.
     *
     * @param question is the questionContent of the <code>Question</code>. It
     * is a <code>java.lang.String</code>.
     * @param createdAt is the date of the <code>Question</code>. It is a
     * <code>java.sql.Date</code>
     * @param answers is a list of listAnswers of the <code>Question</code>. It
     * is a <code>java.util.List</code>
     */
    public Question(String question, Date createdAt, List<Answer> answers) {
        this.questionContent = question;
        this.createdAt = createdAt;
        this.listAnswers = answers;
    }

    /**
     * Gets the value of id attribute in this <code>Question</code> object.
     *
     * @return the value of id attribute of this <code>Question</code> object.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of id attribute in this <code>Question</code> object to
     * the specified id.
     *
     * @param id is the value of id attribute for the <code>Question</code>
     * object. It is an int number.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the value of questionContent attribute in this <code>Question</code>
     * object.
     *
     * @return the value of questionContent attribute of this
     * <code>Question</code> object.
     */
    public String getQuestionContent() {
        return questionContent;
    }

    /**
     * Sets the value of questionContent attribute in this <code>Question</code>
     * object to the specified questionContent.
     *
     * @param question is the value of questionContent attribute for the
     * <code>Question</code> object. It is a <code>java.lang.String</code>.
     */
    public void setQuestionContent(String question) {
        this.questionContent = question;
    }

    /**
     * Gets the value of createdAt attribute in this <code>Question</code>
     * object.
     *
     * @return the value of createdAt attribute of this <code>Question</code>
     * object.
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the value of createdAt attribute in this <code>Question</code>
     * object to the specified createdAt.
     *
     * @param createdAt is the value of createdAt attribute for the
     * <code>Question</code> object. It is a <code>java.sql.Date</code>.
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the value of answer attribute in this <code>Question</code> object.
     *
     * @return the value of answer attribute of this <code>Question</code>
     * object.
     */
    public List<Answer> getListAnswers() {
        return listAnswers;
    }

    /**
     * Sets the value of listAnswers attribute in this <code>Question</code>
     * object to the specified listAnswers.
     *
     * @param listAnswers is the value of answer attribute for the
     * <code>Question</code> object. It is a <code>java.util.List</code>.
     */
    public void setListAnswers(List<Answer> listAnswers) {
        this.listAnswers = listAnswers;
    }

    /**
     * Returns a String representing the specified <code>Question</code> object.
     *
     * @return a string representation of the specified <code>Question</code>.
     */
    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", question=" + questionContent + ", createdAt=" + createdAt + ", answers=" + listAnswers + '}';
    }

}
