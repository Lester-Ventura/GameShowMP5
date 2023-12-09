
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/styles.css" rel="stylesheet" type="text/css">
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game End</title>
    </head>
    <body>
        
        
        <h1> The Game has Ended. Thank you for Playing. Your name has been saved to the leaderboard</h1>
        <button><a href="HomeMenu.jsp">Click Here to return to Home</a></button>
          <% 
                    for(int i=1;i-1<20;i++){
                    if(session.getAttribute("leader"+i)!=null)
                    out.println("<li> Username:  "+session.getAttribute("leader"+i)+"||  Score: "+session.getAttribute("score"+i)+"</li>");
                        }
                    %>
        <% //Remove the session attributes
           session.removeAttribute("currentUser");
           session.removeAttribute("roundNumber");
           session.removeAttribute("currentScore");
           session.removeAttribute("victoryFlag");
           session.removeAttribute("question1W3");
           %>
    </body>
</html>
