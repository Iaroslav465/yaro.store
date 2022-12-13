<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit address</title>
    <%@ include file="/WEB-INF/jsp/head.jsp" %>
</head>
<body>
<header>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
</header>
<article>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-6">
                <h1>Editing the address</h1>
                <form:form method="post" action="/account/edit_address" modelAttribute="addressDto">
                    <form>
                        <div class="form-group row">
                            <label for="country" class="col-sm-2 col-form-label">Country</label>
                            <div class="col-sm-10">
                                <form:input path="country" type="text" name="country"
                                            value="${addressDto.country}" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="city" class="col-sm-2 col-form-label">City</label>
                            <div class="col-sm-10">
                                <form:input path="city" type="text" name="city"
                                            value="${addressDto.city}" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="zipCode" class="col-sm-2 col-form-label">Zip code</label>
                            <div class="col-sm-10">
                                <form:input path="zipCode" type="text" name="zipCode"
                                            value="${addressDto.zipCode}" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="street" class="col-sm-2 col-form-label">Street</label>
                            <div class="col-sm-10">
                                <form:input path="street" type="text" name="street"
                                            value="${addressDto.street}" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="building" class="col-sm-2 col-form-label">Building</label>
                            <div class="col-sm-10">
                                <form:input path="building" name="building" value="${addressDto.building}"
                                            min="1" max="99999" pattern="^[0-9]+$" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="apartment" class="col-sm-2 col-form-label">Apartment</label>
                            <div class="col-sm-10">
                                <form:input path="apartment" name="apartment" value="${addressDto.apartment}"
                                            min="1" max="99999" pattern="^[0-9]+$" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <button type="submit" class="btn btn-warning btn-lg">Edit</button>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <form:input path="id" type="hidden" name="id"
                                            value="${addressDto.id}" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <form:input path="customerDto" type="hidden" name="customerDto"
                                            value="${addressDto.customerDto}" cssClass="form-control"/>
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
