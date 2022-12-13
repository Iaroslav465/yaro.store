<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Statistics</title>
    <%@ include file="/WEB-INF/jsp/head.jsp" %>
</head>
<body>
<header>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
</header>
<article>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col">
                <p>
                <h1>Top 10 products</h1>
                <core:if test="${productsStatisticsDto.size() == 0}">
                    <h2><b>No product has been sold yet!</b></h2>
                </core:if>
                <core:if test="${productsStatisticsDto.size() != 0}">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">UPC</th>
                            <th scope="col">Name</th>
                            <th scope="col">Color</th>
                            <th scope="col">Brand</th>
                            <th scope="col">Category</th>
                            <th scope="col">Price</th>
                            <th scope="col">Quantity sold</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%! int i = 1; %>
                        <core:forEach items="${productsStatisticsDto}" var="productStatistics">
                            <tr>
                                <th scope="row"><%=i++%>
                                </th>
                                <td>${productStatistics.upc}</td>
                                <td>${productStatistics.name}</td>
                                <td>${productStatistics.color}</td>
                                <td>${productStatistics.brand}</td>
                                <td>${productStatistics.category}</td>
                                <td>$${productStatistics.price}</td>
                                <td><b>${productStatistics.quantitySold}</b></td>
                            </tr>
                        </core:forEach>
                        <% i = 1; %>
                        </tbody>
                    </table>
                </core:if>

                <p>
                <h1>Top 10 customers</h1>
                <core:if test="${customersStatisticsDto.size() == 0}">
                    <h2><b>No customer has made a purchase yet!</b></h2>
                </core:if>
                <core:if test="${customersStatisticsDto.size() != 0}">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">First name</th>
                            <th scope="col">Last name</th>
                            <th scope="col">Email</th>
                            <th scope="col">Purchases total</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%! int j = 1; %>
                        <core:forEach items="${customersStatisticsDto}" var="customerStatistics">
                            <tr>
                                <th scope="row"><%=j++%>
                                </th>
                                <td>${customerStatistics.firstName}</td>
                                <td>${customerStatistics.lastName}</td>
                                <td>${customerStatistics.email}</td>
                                <td><b>$${customerStatistics.purchasesTotal}</b></td>
                            </tr>
                        </core:forEach>
                        <% j = 1; %>
                        </tbody>
                    </table>
                </core:if>

                <p>
                <h1>Income for the last week:</h1>
                <h2><b>$${lastWeekIncome}</b></h2>

                <p>
                <h1>Income for the last month:</h1>
                <h2><b>$${lastMonthIncome}</b></h2>

            </div>
        </div>
    </div>
</article>
</body>
</html>
