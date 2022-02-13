<%--
  Created by IntelliJ IDEA.
  User: pepesan
  Date: 13/2/22
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>

<nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}/hello">QuickServlet</a></li>
        <li><a href="${pageContext.request.contextPath}/jsp">JspServlet</a></li>
        <li><a href="${pageContext.request.contextPath}/jdbc">JdbcServlet</a></li>
        <li><a href="${pageContext.request.contextPath}/params?myparam=value">ParamsServlet</a></li>
        <li><a href="${pageContext.request.contextPath}/jstl">Ejemplo JSTL</a></li>
        <li><a href="${pageContext.request.contextPath}/javain.jsp">Ejemplo Java en JSP</a></li>
    </ul>
</nav>
