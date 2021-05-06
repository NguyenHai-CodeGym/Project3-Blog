
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<%@include file="layout-blog-page/header.jsp" %>


<body>



<%@include file="layout-blog-page/header-banner.jsp" %>
<!-- END header -->

<section class="site-section pt-5">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="owl-carousel owl-theme home-slider">
                    <c:forEach items="${list}" var="list">
                        <div>
                            <a href="/blogSingle?id=${list.id}" class="a-block d-flex align-items-center height-lg" style="background-image: url('${list.image}'); ">
                                <div class="text half-to-full">
                                    <div class="post-meta">
                                        <span class="category">${list.category.nameCategory}</span>
                                        <span class="mr-2">${list.publishDate}</span> &bullet;
                                        <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                                    </div>
                                    <h3>${list.title}</h3>
                                    <p>${list.shortContent}</p>
                                </div>
                            </a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="row">
            <c:forEach items="${list}" var="list">
                <div class="col-md-6 col-lg-4">
                    <a href="/blogSingle?id=${list.id}" class="a-block d-flex align-items-center height-md" style="background-image: url('${list.image}'); ">
                        <div class="text">
                            <div class="post-meta">
                                <span class="category">${list.category.nameCategory}</span>
                                <span class="mr-2">${list.publishDate}</span> &bullet;
                                <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                            </div>
                            <h3>${list.title}</h3>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<!-- END section -->

<section class="site-section py-sm">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h2 class="mb-4">Lifestyle Category</h2>
            </div>
        </div>
        <div class="row blog-entries">
            <div class="col-md-12 col-lg-8 main-content">
                <div class="row">
                    <c:forEach var="allLists" items="${allList}">
                        <div class="col-md-6">
                            <a href="/blogSingle?id=${allLists.id}" class="blog-entry element-animate" data-animate-effect="fadeIn">
                                <img src="${allLists.image}" alt="Image placeholder">
                                <div class="blog-content-body">
                                    <div class="post-meta">
                                        <span class="category">${allLists.category.nameCategory}</span>
                                        <span class="mr-2">${allLists.publishDate}</span> &bullet;
                                        <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                                    </div>
                                    <h2>${allLists.title}</h2>
                                </div>
                            </a>
                        </div>
                    </c:forEach>
                </div>
                <div class="row">
                    <div class="col-md-12 text-center">
                        <nav aria-label="Page navigation" class="text-center">
                            <ul class="pagination">
                                <li class="page-item  active"><a class="page-link" href="#">Prev</a></li>
                                <li class="page-item"><a class="page-link" href="#">1</a></li>
                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                <li class="page-item"><a class="page-link" href="#">Next</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
                <div class="row mb-5 mt-5">
                    <div class="col-md-12">
                        <h2 class="mb-4">More Blog Posts</h2>
                    </div>
                    <c:forEach items="${listRamdoms}" var="listRamdom">
                        <div class="col-md-12">
                            <div class="post-entry-horzontal">
                                <a href="/blogSingle?id=${listRamdom.id}">
                                    <div class="image element-animate"  data-animate-effect="fadeIn" style="background-image: url(${listRamdom.image});"></div>
                                    <span class="text">
                      <div class="post-meta">
                        <span class="category">${listRamdom.category.nameCategory}</span>
                        <span class="mr-2">${listRamdom.publishDate}</span> &bullet;
                        <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                      </div>
                      <h2>${listRamdom.title}</h2>
                    </span>
                                </a>
                            </div>
                            <!-- END post -->
                        </div>
                    </c:forEach>
                </div>
            </div>

            <!-- END main-content -->

            <div class="col-md-12 col-lg-4 sidebar">
                <div class="sidebar-box">
                    <h3 class="heading">Popular Posts</h3>
                    <div class="post-entry-sidebar">
                        <ul>
                            <c:forEach items="${list}" var="list">
                                <li>
                                    <a href="/blogSingle?id=${list.id}">
                                        <img src="${list.image}" alt="Image placeholder" class="mr-4">
                                        <div class="text">
                                            <h4>${list.title}</h4>
                                            <div class="post-meta">
                                                <span class="mr-2">${list.publishDate}</span> &bullet;
                                                <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <!-- END sidebar-box -->
                <div class="sidebar-box">
                    <h3 class="heading">Categories</h3>
                    <ul class="categories">
                        <c:forEach items="${categoryList}" var="categoryList">
                        <li><a href="/categoryBlog?id=${categoryList.id}">${categoryList.nameCategory}</a></li>
                        </c:forEach>
                    </ul>
                </div>
                <!-- END sidebar-box -->

                <div class="sidebar-box">
                    <h3 class="heading">Tags</h3>
                    <ul class="tags">
                        <c:forEach items="${categoryList}" var="categoryList">
                        <li><a href="#">${categoryList.nameCategory}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <!-- END sidebar -->

        </div>
    </div>
</section>

<footer class="site-footer">
    <div class="container">
        <div class="row mb-5">
            <div class="col-md-4">
                <h3>Paragraph</h3>
                <p>
                    <img src="images/img_1.jpg" alt="Image placeholder" class="img-fluid">
                </p>

                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nisi, accusantium optio unde perferendis eum illum voluptatibus dolore tempora, consequatur minus asperiores temporibus reprehenderit.</p>
            </div>
            <div class="col-md-6 ml-auto">
                <div class="row">
                    <div class="col-md-7">
                        <h3>Latest Post</h3>
                        <div class="post-entry-sidebar">
                            <ul>
                                <c:forEach items="${list}" var="listNewPost">
                                    <li>
                                        <a href="/blogSingle?id=${listNewPost.id}">
                                            <img src="${listNewPost.image}" alt="Image placeholder" class="mr-4">
                                            <div class="text">
                                                <h4>${listNewPost.title}</h4>
                                                <div class="post-meta">
                                                    <span class="mr-2">${listNewPost.publishDate}</span> &bullet;
                                                    <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-1"></div>
                    <div class="col-md-4">
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            </div>
        </div>
    </div>
</footer>
<!-- END footer -->

<!-- loader -->
<%@include file="layout-blog-page/script.jsp" %>
</body>
</html>
