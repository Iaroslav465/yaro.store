<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit account</title>
    <%@ include file="/WEB-INF/jsp/head.jsp" %>
</head>
<body>
<header>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
</header>
<article>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-9">
                <h1>Editing account info</h1>
                <form:form method="post" action="/account/edit_account" modelAttribute="customerDto">
                    <form>
                        <div class="form-group row">
                            <label for="firstName" class="col-sm-2 col-form-label">First name</label>
                            <div class="col-sm-10">
                                <form:input path="firstName" type="text" name="firstName"
                                            value="${customerDto.firstName}" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="lastName" class="col-sm-2 col-form-label">Last name</label>
                            <div class="col-sm-10">
                                <form:input path="lastName" type="text" name="lastName"
                                            value="${customerDto.lastName}" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="dateOfBirth" class="col-sm-2 col-form-label">Date of Birth</label>
                            <div class="col-sm-10">
                                <form:input path="dateOfBirth" type="text" name="dateOfBirth"
                                            value="${customerDto.dateOfBirth.format(formatter)}"
                                            pattern="(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\d\d"
                                            cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="email" class="col-sm-2 col-form-label">Email</label>
                            <div class="col-sm-10">
                                <form:input path="email" type="email" name="email"
                                            value="${customerDto.email}" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="oldPassword" class="col-sm-2 col-form-label">Old password</label>
                            <div class="col-sm-10">
                                <form:password path="oldPassword" name="oldPassword" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="newPassword" class="col-sm-2 col-form-label">New password</label>
                            <div class="col-sm-10">
                                <form:password path="newPassword" name="newPassword" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <button type="submit" class="btn btn-warning btn-lg">Edit</button>
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
