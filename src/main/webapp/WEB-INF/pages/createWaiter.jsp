<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <title>Create User</title>
</head>
<body>

    <h2>Create New Waiter</h2>
    <form:form action="/manager/user/add">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Enter Name:"/>
            <label for="surname">Surname:</label>
            <input type="text" class="form-control" id="surname" name="surname" placeholder="Enter Surname:"/>
            <label for="username">Username:</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="Enter Username:"/>
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password:"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">Add Waiter</button>
        </div>
    </form:form>

</body>
</html>
