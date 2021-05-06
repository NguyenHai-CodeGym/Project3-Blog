
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<%@include file="layout-admin-page/header.jsp" %>


<body class="animsition">
<div class="page-wrapper">
    <!-- HEADER DESKTOP-->
    <%@include file="layout-admin-page/header-desktop.jsp" %>
    <!-- END HEADER DESKTOP-->

    <!-- HEADER MOBILE-->
    <%@include file="layout-admin-page/header-mobile.jsp" %>
    <!-- END HEADER MOBILE -->

    <!-- PAGE CONTENT-->
    <div class="page-content--bgf7">
        <!-- BREADCRUMB-->
        <section class="au-breadcrumb2">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="au-breadcrumb-content">
                            <div class="au-breadcrumb-left">
                                <span class="au-breadcrumb-span">You are here:</span>
                                <ul class="list-unstyled list-inline au-breadcrumb__list">
                                    <li class="list-inline-item active">
                                        <a href="#">Home</a>
                                    </li>
                                    <li class="list-inline-item seprate">
                                        <span>/</span>
                                    </li>
                                    <li class="list-inline-item">Dashboard</li>
                                </ul>
                            </div>
                            <form class="au-form-icon--sm" action="" method="post">
                                <input class="au-input--w300 au-input--style2" type="text" placeholder="Search for datas &amp; reports...">
                                <button class="au-btn--submit2" type="submit">
                                    <i class="zmdi zmdi-search"></i>
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- END BREADCRUMB-->

        <!-- WELCOME-->
        <section class="welcome p-t-10">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="title-4">Edit New Post
                        </h1>
                        <hr class="line-seprate">
                    </div>
                </div>
            </div>
        </section>
        <div class="alert alert-success">
            <strong><p style="color: green">${mess}</p></strong>
        </div>
        <!-- END WELCOME-->

        <!-- DATA TABLE-->
        <section class="p-t-20">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h3 class="title-5 m-b-35">data table</h3>
                        <div class="table-data__tool">
                            <div class="table-data__tool-right">
                                <button class="au-btn au-btn-icon au-btn--green au-btn--small">
                                    <a href="/dashboard" style="color: white">Back Menu</a>
                                </button>
                            </div>
                        </div>
                        <form action="/editPost", method="post">
                            <input type="hidden" name="postid" value="${post.id}">
                            <div class="form-group">
                                <label for="usr">Title:</label>
                                <input type="text" class="form-control" id="usr" name="title" value='${post.title}' required>
                            </div>
                            <div class="form-group">
                                <label for="full">Full Content:</label>
                                <textarea class="form-control" rows="5" id="full" name="fullContent" required>${post.fullContent}</textarea>
                            </div>
                            <div class="form-group">
                                <label for="short">Short Content:</label>
                                <textarea class="form-control" rows="5" id="short" name="shortContent" required>${post.shortContent}</textarea>
                            </div>
                            <div class="form-group">
                                <label for="img">Image Link:</label>
                                <input type="text" class="form-control" id="img" name="image" value='${post.image}' required>
                            </div>
                            <select name="category" id="categoryId" class="form-control">
                                <c:forEach var="category" items='${category}'>
                                    <c:if test='${post.category.id == category.id}'>
                                        <option value='${category.id}' selected>${category.nameCategory}</option>
                                    </c:if>
                                    <c:if test="${post.category.id != category.id}">
                                        <option value='${category.id}'>${category.nameCategory}</option>
                                    </c:if>
                                </c:forEach>
                            </select><br>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <!-- END DATA TABLE-->

        <!-- COPYRIGHT-->
        <section class="p-t-60 p-b-20">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="copyright">
                            <p>Copyright © 2018 Colorlib. All rights reserved. Template by <a href="https://colorlib.com">Colorlib</a>.</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- END COPYRIGHT-->
    </div>

</div>

<%@include file="layout-admin-page/script.jsp" %>

</body>

</html>
<!-- end document-->
