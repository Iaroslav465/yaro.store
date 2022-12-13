<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cart</title>
    <%@ include file="/WEB-INF/jsp/head.jsp" %>
</head>
<body>
<header>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
</header>
<article>
    <core:if test="${sessionScope.cartSize < 1}">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-5 text-center">
                    <h1>
                        Your cart is empty.<br>
                        Let's buy something!
                    </h1>
                    <a href="${pageContext.request.contextPath}/catalog" class="btn btn-primary btn-lg">Go to
                        the catalog</a>
                </div>
            </div>
        </div>
    </core:if>
    <core:if test="${sessionScope.cartSize > 0}">
        <div class="container">
            <div class="row">
                <div class="col">
                    <h1>Shopping cart</h1>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Color</th>
                            <th scope="col">Price</th>
                            <th scope="col">Quantity</th>
                            <th scope="col"></th>
                        </tr>
                        </thead>
                        <tbody>
                        <%! int i = 1; %>
                        <core:set var="total" value="${0}"/>
                        <core:forEach items="${productsDtoMap}" var="entry">
                            <tr>
                                <th scope="row"><%=i++%>
                                </th>
                                <td>${entry.key.name}</td>
                                <td>${entry.key.color}</td>
                                <td>$${entry.key.price}</td>
                                <td>${entry.value}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/cart/delete_from_card?upc=${entry.key.upc}"
                                       class="btn btn-danger btn-sm">Delete</a></td>
                            </tr>
                            <core:set var="total" value="${total + entry.key.price * entry.value}"/>
                        </core:forEach>
                        <% i = 1; %>
                        </tbody>
                    </table>
                    <h3>Total: <core:out value="$${total}"/></h3><br>
                    <sec:authorize access="isAnonymous()">
                        <h1>Please sign in or sign up to continue shopping!</h1>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <form:form method="post" action="/cart/cart" modelAttribute="orderDto">
                            <form>
                                <div class="form-group row">
                                    <label for="paymentMethod" class="col-sm-2 col-form-label">Payment method</label>
                                    <div class="col-sm-10">
                                        <form:select path="paymentMethod" cssClass="form-control">
                                            <form:option value="CASH"/>
                                            <form:option value="CARD"/>
                                        </form:select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="deliveryMethod" class="col-sm-2 col-form-label">Delivery method</label>
                                    <div class="col-sm-10">
                                        <form:select path="deliveryMethod" cssClass="form-control">
                                            <form:option value="Correos Spain"/>
                                            <form:option value="DHL"/>
                                        </form:select>
                                    </div>
                                </div>
                                <core:if test="${empty addresses}">
                                    <div class="form-group row">
                                        <label for="address" class="col-sm-2 col-form-label">Address</label>
                                        <div class="col-sm-10">
                                            <a href="${pageContext.request.contextPath}/account/create_address"
                                               class="btn btn-primary btn-sm">Create address</a>
                                        </div>
                                    </div>
                                </core:if>
                                <core:if test="${not empty addresses}">
                                    <div class="form-group row">
                                        <label for="address" class="col-sm-2 col-form-label">Address</label>
                                        <div class="col-sm-10">
                                            <form:select path="address" cssClass="form-control">
                                                <form:options items="${addresses}"/>
                                            </form:select>
                                        </div>
                                    </div>
                                </core:if>
                                <div class="form-group row">
                                    <div class="col-sm-10">
                                        <button type="submit" class="btn btn-primary btn-lg">Checkout</button>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-10">
                                        <form:input path="customerDto" type="hidden" name="customerDto"
                                                    value="${customerDto}" cssClass="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-10">
                                        <form:input path="paymentStatus" type="hidden" name="paymentStatus"
                                                    value="AWAITING_PAYMENT" cssClass="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-10">
                                        <form:input path="orderStatus" type="hidden" name="orderStatus"
                                                    value="AWAITING_PAYMENT" cssClass="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-10">
                                        <form:input path="total" type="hidden" name="total"
                                                    value="${total}" cssClass="form-control"/>
                                    </div>
                                </div>
                            </form>
                        </form:form>
                    </sec:authorize>
                </div>
            </div>
        </div>
    </core:if>
</article>
</body>
</html>
