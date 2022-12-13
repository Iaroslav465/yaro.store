<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Categories</title>
    <%@ include file="/WEB-INF/jsp/head.jsp" %>
</head>
<body>
<header>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
</header>
<article>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-4">
                <h1>Categories</h1>
                <a href="${pageContext.request.contextPath}/admin/create_category" class="btn btn-primary">Create</a>
                <p><h5>Other Equipment</h5>
                <core:forEach items="${categoriesDto}" var="category">
                    <core:if test="${category.name != 'Other Equipment'}">
                        <p><h5>${category.name}</h5>
                        <a href="${pageContext.request.contextPath}/admin/edit_category?id=${category.id}"
                           class="btn btn-warning btn-sm">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/delete_category?id=${category.id}"
                           class="btn btn-danger btn-sm">Delete</a>
                    </core:if>
                </core:forEach>
            </div>
        </div>
    </div>
</article>
</body>
</html>
