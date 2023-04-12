<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/header.jsp" %>
<%@ include file="/menu.jsp" %>
<div>
    <jsp:useBean id="listado" scope="request" type="java.util.List"/>
    <h3>Listado de Elementos: ${fn:length(listado)}</h3>
    <ul>

        <c:forEach items="${listado}" var="element">

            <li>${element}</li>

        </c:forEach>
    </ul>
</div>


<%@ include file="/footer.jsp" %>