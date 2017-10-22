<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <title>Login</title>
</head>
<body>
<div class="container">
    <div class="text-center"><h3>Welcome To Cafe Management Application</h3></div>

<div class="col-sm-4 col-sm-offset-1">
    <div class="login-form"><!--login form-->
        <h2>Login to your account</h2>
        <form name='loginForm' action="<c:url value="/login"/> " method="post">
            <input type="text" id="username" placeholder="Username" name="username"/>
            <input type="password" id="password" placeholder="Password" name="password"/>

            <button type="submit" class="btn btn-succes">Login</button>
        </form>
    </div><!--/login form-->
</div>
</div>
</body>
</html>
