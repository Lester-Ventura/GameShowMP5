<%-- 
    Document   : error
    Created on : 12 2, 23, 1:20:54 PM
    Author     : justi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Something went wrong!</h1>
        ${exception.printStackTrace(pageContext.response.writer)}
        
    </body>
</html>
