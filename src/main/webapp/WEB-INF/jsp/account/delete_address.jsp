<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete address</title>
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
                <h1>Are you sure you want to remove this address?</h1>
                <form:form method="post" action="/account/delete_address" modelAttribute="addressDto">
                    <form>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <button type="submit" class="btn btn-danger btn-lg">Delete</button>
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
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <form:input path="country" type="hidden" name="country"
                                            value="${addressDto.country}" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <form:input path="city" type="hidden" name="city"
                                            value="${addressDto.city}" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <form:input path="zipCode" type="hidden" name="zipCode"
                                            value="${addressDto.zipCode}" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <form:input path="street" type="hidden" name="street"
                                            value="${addressDto.street}" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <form:input path="building" type="hidden" name="building" value="${addressDto.building}"
                                            min="1" max="99999" pattern="^[0-9]+$" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <form:input path="apartment" type="hidden" name="apartment"
                                            value="${addressDto.apartment}"
                                            min="1" max="99999" pattern="^[0-9]+$" cssClass="form-control"/>
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
