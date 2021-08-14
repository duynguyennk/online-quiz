<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Register Page</title>
    </head>
    <body>
        <div id="main-panel">
            <jsp:include page="Header.jsp"/>

            <div id="main-content">                
                <h4 class="loginFornTitle">Registration form</h4>
                <c:if test="${message != null}">
                    <span class="failed">${message}</span>
                </c:if>

                <form action="register" method="post">
                    <input type="hidden" name="request" value="register">
                    <table>
                        <tbody>
                            <tr>
                                <td>User Name: </td>
                                <td><input type="text" value="${savedUserName}" name="username" required></td>
                            </tr> 
                            <tr>
                                <td>Password: </td>
                                <td><input type="password" name="password" required></td>
                            </tr>
                            <tr>
                                <td>User Type:</td>
                                <td>
                                    <select name='type'>
                                        <option value='0' ${savedType == 0 ? "selected" : ""} >Student</option>
                                        <option value='1' ${savedType == 1 ? "selected" : ""}>Teacher</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Email: </td>
                                <td><input type="email" value="${savedEmail}" name='email' required></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Register"></td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
