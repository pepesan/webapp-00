<%--
  Created by IntelliJ IDEA.
  User: pepesan
  Date: 13/2/22
  Time: 0:16
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/about.jsp">About</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Dropdown
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}/hello">QuickServlet</a></li>
        <li><a href="${pageContext.request.contextPath}/html">HtmlServlet</a></li>
        <li><a href="${pageContext.request.contextPath}/jsp">JspServlet</a></li>
        <li><a href="${pageContext.request.contextPath}/jdbc">JdbcServlet</a></li>
        <li><a href="${pageContext.request.contextPath}/mysql">JdbcMysqlServlet</a></li>
        <li><a href="${pageContext.request.contextPath}/params?myparam=value">ParamsServlet</a></li>
        <li><a href="${pageContext.request.contextPath}/jstl">Ejemplo JSTL</a></li>
        <li><a href="${pageContext.request.contextPath}/javain.jsp">Ejemplo Java en JSP</a></li>
        <li><a href="${pageContext.request.contextPath}/form">Ejemplo formulario</a></li>
        <li><a href="${pageContext.request.contextPath}/json.html">Ejemplo JSON</a></li>

    </ul>
</nav>
