<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>About</title>
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
                <h1 class="text-center">About the Yaro Store</h1>
                <h3 class="text-center">
                    Welcome, dear customer! It´s a pleasure to see you here, and we´re happy to show you all the brand new devises and technologies. Let's buy something!
                </h3>
                <img src="${pageContext.request.contextPath}/images/aboutthestore.JPG" class="img-fluid" alt="">
            </div>
        </div>
    </div>
</article>
</body>
</html>
