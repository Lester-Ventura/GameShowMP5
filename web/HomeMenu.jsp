    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%  
  if(session.getAttribute("currentUser")!=null){
    if(session.getAttribute("currentUser")=="!@#$%$#@!"){
        request.getRequestDispatcher("adminLeaderBoard.jsp").forward(request,response);
        }
    else
       request.getRequestDispatcher("questionQuiz.jsp").forward(request,response);
    }
    %>
<html>
            <div class="background">
            <div class="content">

    <head>
         <link href="${pageContext.request.contextPath}/loginPageCSS.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz Home Menu</title>
    </head>
    <body>
        <h1 class="title">A Normal Chess Quiz</h1 class="title">
        <form action="loginPage" method="POST">
        <input type="textbox" placeholder="Enter Username" name="username" required>
        <input type="submit" value="Enter!">
        </form>
        <div class="leaderBoard">
        <!-- Prints the LeaderBoard when starting the page (Will print Empty and no score if there are no entered users)-->
           <ol>
                <p></p>
                    
                    <h2 class="title">Hall of Fame Leaderboard</h2>
                    Username:                   Score: 
                   <% 
                    for(int i=1;i-1<20;i++){
                    if(session.getAttribute("leader"+i)!=null)
                    out.println("<li>"+session.getAttribute("leader"+i)+session.getAttribute("score"+i)+"</li>");
                    else
                    out.println("<li> Empty </li>");
                        }
                    %>
   
            </ol>
        </div>
            </div>
        </div>
    </body>
    
</html>
