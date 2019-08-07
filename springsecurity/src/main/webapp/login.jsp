<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <body>
        ${SPRING_SECURITY_LAST_EXCEPTION.message}
        <div class="log-form">
            <h2>Login to your account</h2>
            <form action="login" method="POST">
                <div><input type="text" name="username" title="username" placeholder="username" /></div>
                <div><input type="password" name="password" title="username" placeholder="password" /></div>
                <button type="submit" value="submit" class="btn">Login</button>
            </form>
        </div>
    </body>
</html>
