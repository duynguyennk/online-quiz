<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Quiz Result Page</title>
    </head>
    <body>
        <div id="main-panel">
            <jsp:include page="Header.jsp"/>
            <div id="main-content">
                <p>Your score: 
                    <span class="bold ${score >= 4 ? "success" : "failed"}">
                        <fmt:formatNumber maxFractionDigits="1" value="${score}"/> (<fmt:formatNumber maxFractionDigits="0" value="${score * 10}"/> %) - ${score >= 4 ? "PASSED" : "FAILED"}
                    </span>
                </p>
                <br>
                <span>Take another quiz</span> 
                <a href="takequiz"><button>Start</button></a>
            </div>
        </div>
    </body>
</html>