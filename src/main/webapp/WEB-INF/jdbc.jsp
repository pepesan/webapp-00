<jsp:useBean id="data" scope="request" type="com.cursosdedesarrollo.app.Registration"/>
<%--
  Created by IntelliJ IDEA.
  User: pepesan
  Date: 31/1/22
  Time: 5:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><a href="${pageContext.request.contextPath}/index.jsp">Inicio</a> </p>
<p>The data from servlet: ${data.getLast()}</p>
<jsp:useBean id="listado" scope="request" type="java.util.List"/>
<h3>Listado de Elementos: ${fn:length(listado)}</h3>
<ul>

    <c:forEach items="${listado}" var="element">

        <li>${element.first}</li>

    </c:forEach>
</ul>
</body>
</html>
