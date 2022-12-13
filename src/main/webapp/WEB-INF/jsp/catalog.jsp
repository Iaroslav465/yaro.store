<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Catalog</title>
    <%@ include file="/WEB-INF/jsp/head.jsp" %>
</head>
<body>
<header>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
</header>
<article>
    <div class="container mt-3">
        <form:form method="get" action="/catalog" modelAttribute="categories">
            <div class="row">
                <div class="col">
                    <select id="categoryDto" name="categoryDto" class="form-control">
                        <option value="">Category</option>
                        <core:forEach var="category" items="${categories}">
                            <option value="${category.name}">${category.name}</option>
                        </core:forEach>
                    </select>
                </div>
                <div class="col">
                    <input class="form-control" id="name" name="name" type="text" placeholder="Name"/>
                </div>
                <div class="col">
                    <input class="form-control" id="minPrice" name="minPrice" value="" min="1" max="1000000"
                           pattern="^[0-9]+$" placeholder="Min price"/>
                </div>
                <div class="col">
                    <input class="form-control" id="maxPrice" name="maxPrice" value="" min="1" max="1000000"
                           pattern="^[0-9]+$" placeholder="Max price"/>
                </div>
                <div class="col">
                    <input class="form-control" id="brand" name="brand" type="text" placeholder="Brand"/>
                </div>
                <div class="col">
                    <input class="form-control" id="color" name="color" type="text" placeholder="Color"/>
                </div>
                <div class="col">
                    <input type="submit" value="Filter" class="btn btn-secondary">
                </div>
            </div>
        </form:form>
    </div>
    <div class="container">
        <div class="row row-cols-3">
            <core:forEach items="${products}" var="product">
                <div class="col mt-3">
                    <div class="card text-center" style="width: 20rem;">
                        <img src="${pageContext.request.contextPath}/images/${product.imagePath}"
                             class="card-img-top" alt="">
                        <div class="card-body">
                            <h5 class="card-title">${product.name}</h5>
                            <h6 class="card-subtitle mb-2 text-muted">${product.categoryDto}</h6>
                            <div class="card-text text-left">Brand: ${product.brand}</div>
                            <div class="card-text text-left">Color: ${product.color}</div>
                            <div class="card-text text-left">Weight: ${product.weight} g</div>
                            <div class="card-text text-left">HxWxD:
                                    ${product.height}x${product.width}x${product.depth} mm
                            </div>
                            <div class="card-text text-left">UPC: ${product.upc}</div>
                            <div class="card-text text-left">Quantity: ${product.inStock}</div>
                            <h5 class="card-title">$${product.price}</h5>
                            <core:if test="${product.inStock > 0}">
                                <a href="${pageContext.request.contextPath}/cart/buy?upc=${product.upc}"
                                   class="btn btn-primary btn-lg btn-block">Buy</a>
                            </core:if>
                            <core:if test="${product.inStock == 0}">
                                <button type="button" class="btn btn-outline-primary btn-lg btn-block" disabled>
                                    Out of stock
                                </button>
                            </core:if>
                            <sec:authorize access="hasRole('ADMIN')">
                                <a href="${pageContext.request.contextPath}/admin/edit_product?upc=${product.upc}"
                                   class="btn btn-warning btn-lg btn-block">Edit</a>
                            </sec:authorize>
                            <sec:authorize access="hasRole('ADMIN')">
                                <a href="${pageContext.request.contextPath}/admin/delete_product?upc=${product.upc}"
                                   class="btn btn-danger btn-lg btn-block">Delete</a>
                            </sec:authorize>
                        </div>
                    </div>
                </div>
            </core:forEach>
        </div>
    </div>
</article>
</body>
</html>
