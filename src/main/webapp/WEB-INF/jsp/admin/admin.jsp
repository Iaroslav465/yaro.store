<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin</title>
    <%@ include file="/WEB-INF/jsp/head.jsp" %>
</head>
<body>
<header>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
</header>
<article>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-3 text-center">
                <h1>Admin panel</h1>
                <a class="btn btn-primary btn-lg btn-block" href="${pageContext.request.contextPath}/admin/orders"
                   role="button">Orders</a>
                <a class="btn btn-primary btn-lg btn-block"
                   href="${pageContext.request.contextPath}/admin/create_product"
                   role="button">Create new product</a>
                <a class="btn btn-primary btn-lg btn-block" href="${pageContext.request.contextPath}/admin/categories"
                   role="button">Categories</a>
                <a class="btn btn-primary btn-lg btn-block" href="${pageContext.request.contextPath}/admin/statistics"
                   role="button">Statistics</a>
            </div>
        </div>
    </div>
</article>
</body>
</html>
