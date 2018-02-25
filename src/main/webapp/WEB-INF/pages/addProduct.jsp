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
    <title>Create product</title>
</head>
<body>
<div class="container">

    <h2>Create New Product</h2>
    <form:form action="/manager/product/add">
        <div class="form-group">
            <label for="user">Please select an user:</label>
            <select class="form-control" id="user" name="user">
                <c:forEach items="${waiters}" var="user">
                    <option name="name">${user.name}</option>
                </c:forEach>
            </select>
            <button type="submit" class="btn btn-sm btn-success">Add Waiter to table</button>
        </div>
    </form:form>
</div>

</body>
</html>
