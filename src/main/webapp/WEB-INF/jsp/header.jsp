<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/"><b>Yaro Store</b></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/catalog">Catalog</a>
            <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/about">About</a>
            <sec:authorize access="hasRole('ADMIN')">
                <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/admin/admin">Admin</a>
            </sec:authorize>
        </div>
    </div>
    <ul class="navbar-nav ml-md-auto">
        <li class="nav-item">
            <div style="margin-right: 20px">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/cart/cart" role="button">
                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-bag" fill="currentColor"
                         xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd"
                              d="M14 5H2v9a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V5zM1 4v10a2 2 0 0 0 2
                                  2h10a2 2 0 0 0 2-2V4H1z"></path>
                        <path d="M8 1.5A2.5 2.5 0 0 0 5.5 4h-1a3.5 3.5 0 1 1 7 0h-1A2.5 2.5 0 0 0 8 1.5z"></path>
                    </svg>
                    <span class="badge badge-light">
                            <core:out value="${sessionScope.cartSize}" default="0"/>
                        </span>
                </a>
            </div>
        </li>
        <li class="nav-item">
            <sec:authorize access="!isAuthenticated()">
                <div class="btn-group" role="group">
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/sign_up"
                       role="button">Sign up</a>
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/login"
                       role="button">Sign in</a>
                </div>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <div class="btn-group" role="group">
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/account/account"
                       role="button">Account</a>
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/logout"
                       role="button">Sign out</a>
                </div>
            </sec:authorize>
        </li>
    </ul>
</nav>
