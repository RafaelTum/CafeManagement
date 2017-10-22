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
    <title>Manager</title>
</head>
<body>
<div class="container">
<div class="col-sm-8">
    <div class="pull-right">
        <ul class="nav navbar-nav">
            <li><a href="/manager/create/waiter"><i class="fa fa-lock"></i> Create User</a></li>
            <li><a href="/manager/create/table"><i class="fa fa-lock"></i> Create Table</a></li>
            <li><a href="/logout"><i class="fa fa-lock"></i> Logout</a></li>

        </ul>
    </div>
</div>
<br>
<br>
<br>
<h2>Waiters</h2>
<table class="table">
    <thead>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${waiters}" var="waiter">
        <tr>
            <td>${waiter.name}</td>
            <td>${waiter.surname}</td>
            <td><a href="/manager/waiter/delete/${waiter.id}" type="button" class="btn btn-sm btn-danger">delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
    <br><br><br><br>

<h2>Tables</h2>

<table class="table">
    <thead>
    <tr>
        <th>Id</th>
        <th>Waiter</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${tables}" var="table">
        <tr>
            <td>${table.id}</td>
            <td>${table.waiter.name}</td>
            <td><a href="/manager/update/table/${table.id}" type="button" class="btn btn-sm btn-warning">update table</a></td>
            </a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br><br>
    <h2>Create New Product</h2>
<form:form action="/manager/create/product">
    <div class="form-group">
        <label for="name">Name:</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="Enter Name:"/>
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-sm btn-success">Add product</button>
    </div>
</form:form>

</div>
</body>
</html>
