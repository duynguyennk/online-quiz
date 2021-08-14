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
 * The <code>User</code> class represents character of <code>User</code>. The
 * class contains constructor, getter, setter, toString of <code>User</code>
 * object.
 * <p>
 * Bugs: none
 *
 * @author Nguyen Khanh Duy
 */
public class User {

    private int id;
    private String userName;
    private String password;
    private String email;
    private int type;

    /**
     * Initializes a newly created <code>User</code> object from a parameterless
     * constructor
     */
    public User() {
    }

    /**
     * Constructs an <code>User</code> object with the given userName, password,
     * email, type attributes.
     *
     * @param userName is the username of the <code>User</code>. It is a
     * <code>java.lang.String</code>.
     * @param password is the password of the <code>User</code>. It is a
     * <code>java.lang.String</code>.
     * @param email is the email of the <code>User</code>. It is a
     * <code>java.lang.String</code>
     * @param type is the type of the <code>User</code>. It is an int number
     */
    public User(String userName, String password, String email, int type) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.type = type;
    }

    /**
     * Constructs an <code>User</code> object with the given id, userName,
     * password, email, type attributes.
     *
     * @param id is the id of the <code>User</code>. It is an int number
     * @param userName is the username of the <code>User</code>. It is a
     * <code>java.lang.String</code>.
     * @param password is the password of the <code>User</code>. It is a
     * <code>java.lang.String</code>.
     * @param email is the email of the <code>User</code>. It is a
     * <code>java.lang.String</code>
     * @param type is the type of the <code>User</code>. It is an int number
     */
    public User(int id, String userName, String password, String email, int type) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.type = type;
    }

    /**
     * Gets the value of id attribute in this <code>User</code> object.
     *
     * @return the value of id attribute of this <code>User</code> object.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of id attribute in this <code>User</code> object to the
     * specified id.
     *
     * @param id is the value of id attribute for the <code>User</code> object.
     * It is an int number.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the value of userName attribute in this <code>User</code> object.
     *
     * @return the value of userName attribute of this <code>User</code> object.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of userName attribute in this <code>User</code> object to
     * the specified userName.
     *
     * @param userName is the value of userName attribute for the
     * <code>User</code> object. It is a <code>java.lang.String</code>.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the value of password attribute in this <code>User</code> object.
     *
     * @return the value of password attribute of this <code>User</code> object.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of password attribute in this <code>User</code> object to
     * the specified password.
     *
     * @param password is the value of password attribute for the
     * <code>User</code> object. It is a <code>java.lang.String</code>.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the value of email attribute in this <code>User</code> object.
     *
     * @return the value of email attribute of this <code>User</code> object.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of email attribute in this <code>User</code> object to the
     * specified email.
     *
     * @param email is the value of email attribute for the <code>User</code>
     * object. It is a <code>java.lang.String</code>.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the value of type attribute in this <code>User</code> object.
     *
     * @return the value of type attribute of this <code>User</code> object.
     */
    public int getType() {
        return type;
    }

    /**
     * Sets the value of type attribute in this <code>User</code> object to the
     * specified type.
     *
     * @param type is the value of type attribute for the <code>User</code>
     * object. It is an int number
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Returns a String representing the specified <code>User</code> object.
     *
     * @return a string representation of the specified <code>User</code>.
     */
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email + ", type=" + type + '}';
    }

}
