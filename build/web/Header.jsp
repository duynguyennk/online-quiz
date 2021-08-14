<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css"/>

<div id="nav-bar">
    <ul>
        <li><a href='home'>Home</a></li>
        <li><a href='takequiz'>Take Quiz</a></li>
        <li><a href='makequiz'>Make Quiz</a></li>
        <li><a href='managequiz'>Manage Quiz</a></li>
            <c:if test="${sessionScope.user != null}">
            <li><a href='logout'>Logout</a></li>
            </c:if>
    </ul>
</div>

