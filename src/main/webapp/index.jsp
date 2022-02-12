<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home page</title>
</head>
<body>
<nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}/hello">QuickServlet</a></li>
        <li><a href="${pageContext.request.contextPath}/jsp">JspServlet</a></li>
        <li><a href="${pageContext.request.contextPath}/jdbc">JdbcServlet</a></li>
        <li><a href="${pageContext.request.contextPath}/params?myparam=value">ParamsServlet</a></li>
    </ul>
</nav>
</body>
</html>