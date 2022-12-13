<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete product</title>
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
                <h1>Are you sure you want to remove this product?</h1>
                <form:form method="post" action="/admin/delete_product" modelAttribute="productDto">
                    <div class="form-group row">
                        <div class="col-sm-10">
                            <button type="submit" class="btn btn-danger btn-lg">Delete</button>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10">
                            <form:input path="name" type="hidden" name="name"
                                        value="${productDto.name}" cssClass="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10">
                            <form:input path="categoryDto" type="hidden" name="categoryDto"
                                        value="${productDto.categoryDto}" cssClass="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10">
                            <form:input path="brand" type="hidden" name="brand"
                                        value="${productDto.brand}" cssClass="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10">
                            <form:input path="color" type="hidden" name="color"
                                        value="${productDto.color}" cssClass="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10">
                            <form:input path="weight" type="hidden" name="weight"
                                        value="${productDto.weight}" cssClass="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10">
                            <form:input path="height" type="hidden" name="height"
                                        value="${productDto.height}" cssClass="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10">
                            <form:input path="width" type="hidden" name="width"
                                        value="${productDto.width}" cssClass="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10">
                            <form:input path="depth" type="hidden" name="depth"
                                        value="${productDto.depth}" cssClass="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10">
                            <form:input path="upc" type="hidden" name="upc"
                                        value="${productDto.upc}" cssClass="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10">
                            <form:input path="inStock" type="hidden" name="inStock"
                                        value="${productDto.inStock}" cssClass="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10">
                            <form:input path="price" type="hidden" name="price"
                                        value="${productDto.price}" cssClass="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10">
                            <form:input path="imagePath" type="hidden" name="imagePath"
                                        value="${productDto.imagePath}" cssClass="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10">
                            <form:input path="deleted" type="hidden" name="deleted"
                                        value="${productDto.deleted}" cssClass="form-control"/>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</article>
</body>
</html>
