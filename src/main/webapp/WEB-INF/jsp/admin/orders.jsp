<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Orders</title>
    <%@ include file="/WEB-INF/jsp/head.jsp" %>
</head>
<body>
<header>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
</header>
<article>
    <div class="container">
        <div class="row">
            <div class="col-10">
                <p>
                <h1>Orders</h1>
                <ul>
                    <core:forEach items="${ordersDto}" var="order">
                        <li>
                            <p><h6>Purchase date: ${order.dateOfSale.format(formatter)}, customer: ${order.customerDto},
                            address: ${order.address}, total: $${order.total}, payment method: ${order.paymentMethod},
                            delivery method: ${order.deliveryMethod}, payment status: ${order.paymentStatus},
                            order status: ${order.orderStatus}</h6>
                            <div><a href="${pageContext.request.contextPath}/admin/change_order_status?id=${order.id}"
                                    class="btn btn-warning btn-sm">Change status</a></div>
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
