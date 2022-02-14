<%--
  Created by IntelliJ IDEA.
  User: pepesan
  Date: 13/2/22
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Inicio</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/hello">QuickServlet</a></li>
            <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/about.jsp">About</a></li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Dropdown link
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
        </ul>
    </div>
</nav>
<nav>
    <ul>

        <li><a href="${pageContext.request.contextPath}/jsp">JspServlet</a></li>
        <li><a href="${pageContext.request.contextPath}/jdbc">JdbcServlet</a></li>
        <li><a href="${pageContext.request.contextPath}/params?myparam=value">ParamsServlet</a></li>
        <li><a href="${pageContext.request.contextPath}/jstl">Ejemplo JSTL</a></li>
        <li><a href="${pageContext.request.contextPath}/javain.jsp">Ejemplo Java en JSP</a></li>
    </ul>
</nav>
