<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User not found</title>
    <%@ include file="/WEB-INF/jsp/head.jsp" %>
</head>
<body>
<header>
    <%@ include file="/WEB-INF/jsp/header.jsp" %>
</header>
<article>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col text-center">
                <h1 class="text-danger text-center"><strong>Error: wrong password!</strong></h1>
                <h1 class="text-center"><strong>${errorMessage}</strong></h1>
            </div>
        </div>
    </div>
</article>
</body>
</html>
