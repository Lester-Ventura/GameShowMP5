<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% if(session.getAttribute("currentUser").equals("!@#$%$#@!")){
    request.getRequestDispatcher("adminLeaderBoard.jsp").forward(request,response);
    }%>
<!DOCTYPE html>
<html>
    <head>
        <link href="${pageContext.request.contextPath}/questionQuizCSS.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz Start!</title>
     </head>
    <body>
        
           <% //Random Distinct Numbers to arrange the questions
           List randnum=new ArrayList();
           randnum.add("W3");
           randnum.add("W2");
            randnum.add("W1");
            randnum.add("correct");
            Collections.shuffle(randnum);%>
        <%= session.getAttribute("currentUser")%>
        <%= session.getAttribute("date")%>
        <h2>Round <%= session.getAttribute("roundNumber")%></h2> <h4>Score: <%= session.getAttribute("currentScore") %></h4>
        <img class="questionPicture" src="${pageContext.request.contextPath}/questionPictures/<%= session.getAttribute("question"+session.getAttribute("roundNumber")+"picture")%>.jpg"/> 
        <p>   <%= session.getAttribute("question"+session.getAttribute("roundNumber")+"desc")%></p>
        
        <form action ="QuestionsBanker" method="POST">
            <div class="flex-boxcenter">
                        <fieldset>
                    <label for="radio1"><input type="radio" id="radio1" name="radioAns" value=<%= randnum.get(0)%>><%= session.getAttribute("question"+session.getAttribute("roundNumber")+randnum.get(0))%></label>
                    <label for="radio2"><input type="radio" id="radio2" name="radioAns" value=<%= randnum.get(1)%>><%= session.getAttribute("question"+session.getAttribute("roundNumber")+randnum.get(1))%> </label>
                    <label for="radio3"><input type="radio" id="radio3" name="radioAns" value=<%= randnum.get(2)%>><%= session.getAttribute("question"+session.getAttribute("roundNumber")+randnum.get(2))%> </label>
                    <label for="radio4"><input type="radio" id="radio4" name="radioAns" value=<%= randnum.get(3)%>><%= session.getAttribute("question"+session.getAttribute("roundNumber")+randnum.get(3))%> </label>
              
                        </fieldset>   
                      </div>
                    <input type="submit" value="Answer!">
        </form>
        </body>
</html>
