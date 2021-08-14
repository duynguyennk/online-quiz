<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Error Page</title>
    </head>
    <body>
        <div id="main-panel">
            <jsp:include page="Header.jsp"/>
            <div id="main-content">
                <h1>${error}</h1>
                <h2>${errorDetail}</h2>
            </div>
        </div>
    </body>
</html>