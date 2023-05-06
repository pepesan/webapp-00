<%--
  Created by IntelliJ IDEA.
  User: pepesan
  Date: 6/5/23
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/header.jsp" %>
<%@ include file="/menu.jsp" %>
<h2>Bienvenid@as al ejemplo de formulario</h2>
<form method="post" action="${pageContext.request.contextPath}/form">
    <label for="texto"></label>
    <input id="texto" name="texto" type="text" value="${texto}"/>
    <input id="form-submit" type="submit" value="Enviar"/>
</form>
<div>${texto}</div>
<%@ include file="/footer.jsp" %>
