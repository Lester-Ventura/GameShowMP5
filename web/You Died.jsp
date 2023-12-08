
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game End</title>
    </head>
    <body>
        <h1>The Game has Ended.</h1>
        <a href="HomeMenu.jsp">Here</a>
        <% //Remove the session attributes
           session.removeAttribute("currentUser");
           session.removeAttribute("roundNumber");
           session.removeAttribute("currentScore");
           session.removeAttribute("victoryFlag");
           session.removeAttribute("question1W3");
           %>
    </body>
</html>
