<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create address</title>
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
                <h1>Creating new address</h1>
                <form:form method="post" action="/account/create_address" modelAttribute="addressDto">
                    <form>
                        <div class="form-group row">
                            <label for="country" class="col-sm-2 col-form-label">Country</label>
                            <div class="col-sm-10">
                                <form:input path="country" type="text" name="country" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="city" class="col-sm-2 col-form-label">City</label>
                            <div class="col-sm-10">
                                <form:input path="city" type="text" name="city" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="zipCode" class="col-sm-2 col-form-label">Zip code</label>
                            <div class="col-sm-10">
                                <form:input path="zipCode" type="text" name="zipCode" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="street" class="col-sm-2 col-form-label">Street</label>
                            <div class="col-sm-10">
                                <form:input path="street" type="text" name="street" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="building" class="col-sm-2 col-form-label">Building</label>
                            <div class="col-sm-10">
                                <form:input path="building" name="building" min="1" max="99999"
                                            pattern="^[0-9]+$" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="apartment" class="col-sm-2 col-form-label">Apartment</label>
                            <div class="col-sm-10">
                                <form:input path="apartment" name="apartment" min="1" max="99999"
                                            pattern="^[0-9]+$" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <button type="submit" class="btn btn-primary btn-lg">Create</button>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <form:input path="customerDto" type="hidden" name="customerDto"
                                            value="${customerDto.email}" cssClass="form-control"/>
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
