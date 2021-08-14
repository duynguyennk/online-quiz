<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Manage Quiz Page</title>
    </head>
    <body>
        <div id="main-panel">
            <jsp:include page="Header.jsp"/>
            <div id="main-content">
                <h3>Number of question: <span class="blue">${totalQuestion}</span></h3>
                <table>
                    <colgroup>
                        <col class="labelCol">
                        <col class="fieldCol">
                    </colgroup>
                    <thead>
                        <tr>
                            <th>Question</th>
                            <th>Date Created</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listQuestionPaging}" var="item">
                            <tr>
                                <td>${item.questionContent}</td>
                                <td><fmt:formatDate type="date" value="${item.createdAt}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="paging">
                    <c:if test="${lastPage > 1}">
                        <c:forEach begin="1" end="${lastPage}" var="i">
                            <a class="${i==index?"active":""}" href="managequiz?index=${i}">${i}</a>
                        </c:forEach>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>