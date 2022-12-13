<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Your Account</title>
    <%@ include file="/WEB-INF/jsp/head.jsp" %>
</head>
<body>
<header>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
</header>
<article>
    <div class="container">
        <div class="row">
            <div class="col">
                <p>
                <h1>Account info</h1>
                <p><h5>First name: ${customerDto.firstName}</h5>
                <p><h5>Last name: ${customerDto.lastName}</h5>
                <p><h5>Date of birth: ${customerDto.dateOfBirth.format(dateFormatter)}</h5>
                <p><h5>Email: ${customerDto.email}</h5>
                <a href="${pageContext.request.contextPath}/account/edit_account"
                   class="btn btn-warning">Edit</a>
            </div>
            <div class="col">
                <p>
                <h1>Addresses</h1>
                <a href="${pageContext.request.contextPath}/account/create_address"
                   class="btn btn-primary">Create</a>
                <core:forEach items="${addressesDto}" var="address">
                    <p><h5>${address.toString()}</h5>
                    <a href="${pageContext.request.contextPath}/account/edit_address?id=${address.id}"
                       class="btn btn-warning btn-sm">Edit</a>
                    <a href="${pageContext.request.contextPath}/account/delete_address?id=${address.id}"
                       class="btn btn-danger btn-sm">Delete</a>
                </core:forEach>
            </div>
        </div>
        <div class="row">
            <div class="col-10">
                <p>
                <h1>Orders history</h1>
                <ul>
                    <core:forEach items="${ordersDto}" var="order">
                        <li>
                            <p><h6>Purchase date: ${order.dateOfSale.format(dateTimeFormatter)},
                            address: ${order.address},
                            total: $${order.total}, payment method: ${order.paymentMethod},
                            delivery method: ${order.deliveryMethod}, payment status: ${order.paymentStatus},
                            order status: ${order.orderStatus}</h6>
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">UPC</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Quantity</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%! int i = 1; %>
                                <core:forEach items="${order.productsInOrdersDto}" var="productInOrder">
                                    <tr>
                                        <th scope="row"><%=i++%></th>
                                        <td>${productInOrder.productDto.upc}</td>
                                        <td>${productInOrder.productDto.name}</td>
                                        <td>${productInOrder.numberOfProducts}</td>
                                    </tr>
                                </core:forEach>
                                <% i = 1; %>
                                </tbody>
                            </table>
                        </li>
                    </core:forEach>
                </ul>
            </div>
        </div>
    </div>
</article>
</body>
</html>
