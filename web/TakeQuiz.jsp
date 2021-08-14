<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div id="main-panel">
            <jsp:include page="Header.jsp"/>
            <c:choose>
                <c:when test="${status == 'start'}">
                    <div id="main-content">                
                        <h3>Welcome <span class="userName">${sessionScope.user.userName}</span></h3>

                        <c:if test="${message != null}">
                            <span class="failed">${message}</span>
                        </c:if>

                        <form action="takequiz" method="post">
                            <br>Enter number of question: <br>
                            <input type="number" name="numOfQuiz" value="1" min="1" max="${maxQuiz}" required="">
                            <input type="submit" value="Start">
                        </form>
                    </div>
                </c:when>
                <c:when test="${status == 'process'}">
                    <div id="main-content">                
                        <div id="quizContainer">
                            <c:if test="${questions == null || questions.isEmpty()}">
                                <h3>No quiz found</h3>
                            </c:if>

                            <c:if test="${questions != null && !questions.isEmpty()}">
                                <h3>Welcome <span class="userName">${sessionScope.user.userName}</span></h3>
                                <h4 id="TimeSpan">Time remaining: <span id="timer" style="color: red;">${numberOfQuestion}</span></h4>
                                <form id="quizForm" action="result" method="post" onsubmit="askForSubmit()">
                                    <input type="hidden" name="numOfQuiz" value="${questions.size()}">
                                    <c:forEach items="${questions}" var="item">
                                        <div class="quiz">
                                            <input type="hidden" name="questionId" value="${item.id}" />
                                            <div class="register-label">${item.questionContent}</div>
                                            <c:forEach items="${item.listAnswers}" var="answer">
                                                <input type="checkbox" name="answers_${item.id}" value="${answer.id}">
                                                <span class="register-label">${answer.answerContent}</span>
                                                </input><br/>
                                            </c:forEach>
                                        </div>
                                    </c:forEach>
                                    <input id="submitQuiz" class="display-none" type="submit" value="Finish" style="float: right;">    
                                </form>
                                <div>
                                    <button id="back" class="display-none" onclick="move(-1)">Back</button>
                                    <button id="next" class="display-none" onclick="move(1)">Next</button>
                                </div>
                            </c:if>

                        </div>
                    </div>
                </c:when>
            </c:choose>
        </div>
    </body>
</html>
<script type="text/javascript">
    var display = document.getElementById("timer");
    startTimer(display);
    function startTimer(display) {
        if (display === null)
            return;
        // convert minute to seconds
        var duration = parseInt(display.textContent, 10) * 60;

        var timer = duration;
        var minutes, seconds;
        // convert value default
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        display.textContent = minutes + ":" + seconds;

        var interval = null;
        interval = setInterval(function () {
            // count minutes and seconds
            minutes = parseInt(timer / 60, 10);
            seconds = parseInt(timer % 60, 10);
            minutes = minutes < 10 ? "0" + minutes : minutes;
            seconds = seconds < 10 ? "0" + seconds : seconds;

            display.textContent = minutes + ":" + seconds;

            if (--timer < 0) {
                clearInterval(interval);
                document.getElementById("submitQuiz").click();
            }

        }, 1000);
    }

    var currentIndex = 0;
    // load default
    move(0);
    // back|next question
    function move(n) {
        let quiz = document.getElementsByClassName("quiz");

        if (quiz.length < 1)
            return;

        // control quiz just has one question
        if (quiz.length > 1) {
            document.getElementById("next").style.display = "block";
            document.getElementById("back").style.display = "inline-block";
        }

        currentIndex += n;

        // control first question
        if (currentIndex === 0) {
            document.getElementById("back").style.display = "none";
            document.getElementById("submitQuiz").style.display = "none";
        }
        if (currentIndex < quiz.length - 1) {
            document.getElementById("submitQuiz").style.display = "none";
        }
        // control last question
        if (currentIndex === quiz.length - 1) {
            document.getElementById("next").style.display = "none";
            document.getElementById("submitQuiz").style.display = "block";
        }

        for (var i = 0; i < quiz.length; i++) {
            quiz[i].style.display = "none";
        }

        quiz[currentIndex].style.display = "block";
    }
</script>