    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%  //Check everythings
  if(session==null||session.getAttribute("existance")==null){
  Cookie sessionCookie = new Cookie("JSESSIONID",session.getId());
             sessionCookie.setMaxAge(Integer.MAX_VALUE);
             request.setAttribute("existance",true);
             response.addCookie(sessionCookie);}
             
  if(session.getAttribute("currentUser")!=null){
    if(session.getAttribute("currentUser")=="!@#$%$#@!"){
        request.getRequestDispatcher("adminLeaderBoard.jsp").forward(request,response);
        }
    else
       request.getRequestDispatcher("questionQuiz.jsp").forward(request,response);
    }
    %>
<html>
     <head>
         <link href="${pageContext.request.contextPath}/loginPageCSS.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz Home Menu</title>
    </head>
    <body>
        <h1 class="title">A Normal Chess Quiz</h1 class="title">
        <form action="loginPage" method="POST">
        <input type="textbox" placeholder="Enter Username" name="username" required max="20">
        <input type="submit" value="Enter!">
        </form>
        <div class="leaderBoard">
        <!-- Prints the LeaderBoard when starting the page (Will print Empty and no score if there are no entered users)-->
           <ol>
               <h2 class="title">Hall of Fame Leaderboard</h2>
               <div class="leaderboard">
                   <% 
                    for(int i=1;i-1<20;i++){
                    if(session.getAttribute("leader"+i)!=null)
                    out.println("<li> Username:  "+session.getAttribute("leader"+i)+"||  Score: "+session.getAttribute("score"+i)+"</li>");
                        }
                    %>
               </div>
            </ol>
        </div>
    </body>
    
</html>
