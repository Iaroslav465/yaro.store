<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete category</title>
    <%@ include file="/WEB-INF/jsp/head.jsp" %>
</head>
<body>
<header>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
</header>
<article>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-5 text-center">
                <h1>Are you sure you want to remove this category?</h1>
                <form:form method="post" action="/admin/delete_category" modelAttribute="categoryDto">
                    <form>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <button type="submit" class="btn btn-danger btn-lg">Delete</button>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <form:input path="name" type="hidden" name="name"
                                            value="${categoryDto.name}" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <form:input path="id" type="hidden" name="id" min="1" max="999999999999"
                                            value="${categoryDto.id}" pattern="^[0-9]+$" cssClass="form-control"/>
                            </div>
                        </div>
                    </form>
                </form:form>
            </div>
        </div>
    </div>
</article>
</body>
</html>
