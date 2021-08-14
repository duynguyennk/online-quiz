
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Home Page</title>
    </head>
    <body>
        <div id="main-panel">
            <jsp:include page="Header.jsp"/>
            <div id="main-content">
                <h2>User Information</h2>
                Username: ${sessionScope.user.userName}<br>
                Email: ${sessionScope.user.email}<br>
                Type: ${sessionScope.user.type == 1 ? "Teacher" : "Student"}
            </div>
        </div>
    </body>
</html>
