

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <link href="${pageContext.request.contextPath}/adminLeaderBoardCSS.css" rel="stylesheet" type="text/css">
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Admin Editor LeaderBoardMenu</title>
    </head>
    <body>
        <h1>Welcome to the LeaderBoard Editor!</h1>
        <p class="description">Select the users you want to delete.</p>
        <!-- Display the LeaderBoard list -->
        <form action="leaderBoardManager" method="POST">
            <%  for(int i=1;i-1<20;i++){
                    if(session.getAttribute("leader"+i)!=null)
                    out.println("<input type=checkbox name=checkrows value="+i+"/>"+session.getAttribute("leader"+i)+" "+session.getAttribute("score"+i)+"<br>");
                    else
                    out.println("<input type=checkbox name=checkrows value="+i+"/>Empty"+"<br>");
                        }%>
          <input type="submit" value="Remove">
        </form>
    </body>
</html>
