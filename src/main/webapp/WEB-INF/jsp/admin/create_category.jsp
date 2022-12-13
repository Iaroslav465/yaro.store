<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create category</title>
    <%@ include file="/WEB-INF/jsp/head.jsp" %>
</head>
<body>
<header>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
</header>
<article>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-5">
                <h1>Creating new category</h1>
                <form:form method="post" action="/admin/create_category" modelAttribute="categoryDto">
                    <form>
                        <div class="form-group row">
                            <label for="name" class="col-sm-2 col-form-label">Name</label>
                            <div class="col-sm-10">
                                <form:input path="name" type="text" name="name" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <button type="submit" class="btn btn-primary btn-lg">Create</button>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <form:input path="id" type="hidden" name="id" min="1" max="999999999999"
                                            pattern="^[0-9]+$" cssClass="form-control"/>
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
