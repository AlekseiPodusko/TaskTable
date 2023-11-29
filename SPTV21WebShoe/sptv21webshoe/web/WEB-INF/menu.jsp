
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/listProducts">TaskTable</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarColor02">
            <ul class="navbar-nav me-auto">
                <c:choose>
                    <c:when test="${topRole eq 'ADMINISTRATOR'}">
                        <li class="btn-sm btn-success my-1 mx-1 mb-1 mt-1"><a class="nav-link" href="showChangeRole">Assign role</a></li>
                        <li class="btn-sm btn-success my-1 mx-1 mb-1 mt-1"><a class="nav-link" href="showAddProduct">Add Task</a></li>
                        <li class="btn-sm btn-success my-1 mx-1 mb-1 mt-1"><a class="nav-link" href="listProducts">Task List</a></li>
                        <li class="btn-sm btn-success my-1 mx-1 mb-1 mt-1"><a class="nav-link" href="showEditUser">Edit Users</a></li>
                        <li class="btn-sm btn-success my-1 mx-1 mb-1 mt-1"><a class="nav-link" href="showUsersList">User List</a></li>
                    </c:when>
                    <c:when test="${topRole eq 'MANAGER'}">
                        <li class="btn-sm btn-success my-1 mx-1 mb-1 mt-1"><a class="nav-link" href="showAddProduct">Add Task</a></li>
                        <li class="btn-sm btn-success my-1 mx-1 mb-1 mt-1"><a class="nav-link" href="listProducts">Task List</a></li>
                        <li class="btn-sm btn-success my-1 mx-1 mb-1 mt-1"><a class="nav-link" href="showEditUser">Edit User</a></li>
                    </c:when>
                    <c:when test="${topRole eq 'CUSTOMER'}">
                        <li class="btn-sm btn-success my-1 mx-1 mb-1 mt-1"><a class="nav-link" href="listProducts">Task List</a></li>
                        <li class="btn-sm btn-success my-1 mx-1 mb-1 mt-1"><a class="nav-link" href="showEditUser">Edit User</a></li>
                    </c:when>
                    <c:when test="${topRole eq NULL}">
                        <li class="btn-sm btn-success my-1 mx-1 mb-1 mt-1"><a class="nav-link" href="listProducts">Task List</a></li>
                    </c:when>
                </c:choose>
            </ul>
            <ul class="navbar-nav  mb-2 mb-lg-0">
                <c:if test="${authUser eq null}">
                    <li class="btn-sm btn-success my-1 mx-1 mb-1 mt-1">
                        <a class="nav-link" href="showLogin">Log In</a>
                    </li>
                </c:if>
                <c:if test="${authUser ne null}">
                    <li class="btn-sm btn-success my-1 mx-1 mb-1 mt-1">
                        <a class="nav-link" href="logout">Log Out</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>