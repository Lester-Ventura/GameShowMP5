
   
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
           <link href="${pageContext.request.contextPath}/loginPageCSS.css" rel="stylesheet" type="text/css">
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Admin Editor LeaderBoardMenu</title>
      
   <% //Check the Sessions
       boolean yes;
       if(session.getAttribute("admin")==null){
        request.getRequestDispatcher("HomeMenu.jsp").forward(request,response);
       }
       else if(session.getAttribute("currentUser").equals(null)){
       request.getRequestDispatcher("HomeMenu.jsp").forward(request,response);
       }
       else if(!session.getAttribute("currentUser").equals("!@#$%$#@!")){
       request.getRequestDispatcher("HomeMenu.jsp").forward(request,response);
       }
            %>
    </head>
    <body>
        <h1>Welcome to the LeaderBoard Editor!</h1>
        <p class="description">Select the users you want to delete.</p>
        <!-- Display the LeaderBoard list -->
        <form action="leaderBoardManager" method="POST">
            <%  for(int i=1;i-1<20;i++){
                    if(session.getAttribute("leader"+i)!=null)
                    out.println("<input type=checkbox name=\"checkrows\" value="+i+">Username:"+session.getAttribute("leader"+i)+" || Score:"+session.getAttribute("score"+i)+"<br>");
                    else
                    out.println("<input type=checkbox name=\"checkrows\" value="+i+">Empty"+"<br>");
                        }%>
          <input type="submit" value="remove">
        </form>
    </body>
</html>
