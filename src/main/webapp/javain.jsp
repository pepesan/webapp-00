<%@ page import="com.cursosdedesarrollo.app.MyService" %>
<%@ include file="/header.jsp" %>
<%@ include file="/menu.jsp" %>
<h2>Bienvenid@as al ejemplo de Java en JSP</h2>

<%
   MyService myService = new MyService("Hola");
   pageContext.setAttribute("myService", myService);
%>
<h2>MyService data: ${myService.data}</h2>
<%@ include file="/footer.jsp" %>
