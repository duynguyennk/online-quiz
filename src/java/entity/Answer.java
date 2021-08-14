/*
 * Copyright(C) 2021, FPT University.
 * J3.L.P0001
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2021-07-15      1.0                 DuyNKHE140102    First Implement
 */
package entity;

/**
 * The <code>Answer</code> class represents character of <code>Answer</code>.
 * The class contains constructor, getter, setter, toString of
 * <code>Answer</code> object.
 * <p>
 * Bugs: none
 *
 * @author Nguyen Khanh Duy
 */
public class Answer {

    private int id;
    private String answerContent;
    private int correctAnswer;

    /**
     * Initializes a newly created <code>Answer</code> object from a
     * parameterless constructor
     */
    public Answer() {
    }

    /**
     * Constructs an <code>Answer</code> object with the given answerContent,
     * correctAnswer attributes.
     *
     * @param answerContent is the answerContent of the <code>Answer</code>. It
     * is an int number.
     * @param correctAnswer is the correct answerContent of the
     * <code>Answer</code>. It is an int number.
     */
    public Answer(String answerContent, int correctAnswer) {
        this.answerContent = answerContent;
        this.correctAnswer = correctAnswer;
    }

    /**
     * Constructs an <code>Answer</code> object with the given answerContent,
     * correctAnswer attributes.
     *
     * @param id is the id of the <code>Answer</code>. It is an int number.
     * @param answerContent is the answerContent of the <code>Answer</code>. It
     * is a <code>java.lang.String</code>.
     */
    public Answer(int id, String answerContent) {
        this.id = id;
        this.answerContent = answerContent;
    }

    /**
     * Gets the value of id attribute in this <code>Answer</code> object.
     *
     * @return the value of id attribute of this <code>Answer</code> object.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of id attribute in this <code>Answer</code> object to the
     * specified id.
     *
     * @param id is the value of id attribute for the <code>Answer</code>
     * object. It is an int number.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the value of answerContent attribute in this <code>Answer</code>
     * object.
     *
     * @return the value of answerContent attribute of this <code>Answer</code>
     * object.
     */
    public String getAnswerContent() {
        return answerContent;
    }

    /**
     * Sets the value of answerContent attribute in this <code>Answer</code>
     * object to the specified answerContent.
     *
     * @param answerContent is the value of answerContent attribute for the
     * <code>Answer</code> object. It is a <code>java.lang.String</code>.
     */
    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    /**
     * Gets the value of correctAnswer attribute in this <code>Answer</code>
     * object.
     *
     * @return the value of correctAnswer attribute of this <code>Answer</code>
     * object.
     */
    public int getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Sets the value of correctAnswer attribute in this <code>Answer</code>
     * object to the specified correctAnswer.
     *
     * @param correctAnswer is the value of correctAnswer attribute for the
     * <code>Answer</code> object. It is an int number.
     */
    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    /**
     * Returns a String representing the specified <code>Answer</code> object.
     *
     * @return a string representation of the specified <code>Answer</code>.
     */
    @Override
    public String toString() {
        return "Answer{" + "id=" + id + ", answer=" + answerContent + ", correctAnswer=" + correctAnswer + '}';
    }

}
