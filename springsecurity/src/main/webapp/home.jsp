<%-- 
    Document   : home
    Created on : 24 Jul, 2019, 5:34:17 PM
    Author     : subhash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib  prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Home Page</title>
    </head>
    <body>
        <h1>Welcome to Home Page!</h1>
        <hr>
        <h3>User: <security:authentication property="principal.username"/></h3>
        <h3>Role(s): <security:authentication property="principal.authorities"/></h3>
        <hr>
        
        <p>
            <a href="/admin/leaders">Leadership Meeting</a>(Only for Manager peeps)
        </p>
        
        <hr>
        <a href="/logout">Logout</a>
    </body>
</html>
