<%-- 
    Document   : MakeQuiz
    Created on : Jun 30, 2021, 5:30:43 PM
    Author     : drako
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Make Quiz Page</title>
    </head>
    <body>
        <div id="main-panel">
            <jsp:include page="Header.jsp"/>
            
            <div id="main-content">
                <c:if test="${message != null}">
                    <span class="failed">${message}</span>
                </c:if>
                
                <form action="makequiz" method="post">
                    <table>
                        <tbody>
                            <tr class="quizRow">
                                <td>Question: </td>
                                <td><textarea name="question" rows="4" class="quizinput" style="height: 100px;" required>${savedQuestion}</textarea></td>
                            </tr>
                            <tr class="quizRow">
                                <td>Option 1</td>
                                <td><textarea name="options" class="quizinput"  required>${savedOptions[0]}</textarea></td>
                            </tr>
                            <tr class="quizRow">
                                <td>Option 2</td>
                                <td><textarea name="options" class="quizinput" required>${savedOptions[1]}</textarea></td>
                            </tr >
                            <tr class="quizRow">
                                <td>Option 3</td>
                                <td><textarea name="options" class="quizinput" required>${savedOptions[2]}</textarea></td>
                            </tr>
                            <tr class="quizRow">
                                <td>Option 4</td>
                                <td><textarea name="options" class="quizinput" required>${savedOptions[3]}</textarea></td>
                            </tr>
                            <tr class="quizRow">
                                <td>Answer(s)</td>
                                <td>
                                    <input type="checkbox" name="answers" value="1"> Option 1
                                    <input type="checkbox" name="answers" value="2"> Option 2
                                    <input type="checkbox" name="answers" value="3"> Option 3
                                    <input type="checkbox" name="answers" value="4"> Option 4
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Save"></td>
                            </tr>
                        </tbody>
                    </table>
                </form>
                
            </div>
        </div>
    </body>
</html>
