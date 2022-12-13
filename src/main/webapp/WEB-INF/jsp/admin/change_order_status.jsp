<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Change order status</title>
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
                <h1>Change order status</h1>
                <form:form method="post" action="/admin/change_order_status" modelAttribute="orderDto">
                    <form>
                        <div class="form-group row">
                            <label for="paymentStatus" class="col-sm-2 col-form-label">Payment status</label>
                            <div class="col-sm-10">
                                <form:select path="paymentStatus" cssClass="form-control">
                                    <form:option value="AWAITING_PAYMENT"/>
                                    <form:option value="PAID"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="orderStatus" class="col-sm-2 col-form-label">Order status</label>
                            <div class="col-sm-10">
                                <form:select path="orderStatus" cssClass="form-control">
                                    <form:option value="AWAITING_PAYMENT"/>
                                    <form:option value="AWAITING_SHIPMENT"/>
                                    <form:option value="SHIPPED"/>
                                    <form:option value="DELIVERED"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <button type="submit" class="btn btn-warning btn-lg">Change status</button>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <form:input path="id" type="hidden" name="id"
                                            value="${orderDto.id}" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <form:input path="customerDto" type="hidden" name="customerDto"
                                            value="${orderDto.customerDto}" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <form:input path="paymentMethod" type="hidden" name="paymentMethod"
                                            value="${orderDto.paymentMethod}" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <form:input path="deliveryMethod" type="hidden" name="deliveryMethod"
                                            value="${orderDto.deliveryMethod}" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <form:input path="address" type="hidden" name="address"
                                            value="${orderDto.address}" cssClass="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10">
                                <form:input path="total" type="hidden" name="total"
                                            value="${orderDto.total}" cssClass="form-control"/>
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
