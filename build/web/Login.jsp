<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Login Page</title>
    </head>
    <body>
        <div id="main-panel">
            <jsp:include page="Header.jsp"/>
            <div id="main-content">                
                <h4 id="loginFornTitle">Login Form</h4>
                <c:if test="${(message != null)}">
                    <span class="failed">${message}</span>
                </c:if>

                <form action="login" method="post">
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
                                <td></td>
                                <td>
                                    <input type="submit" value="Sign In">
                                    <a href="register">Register</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>
