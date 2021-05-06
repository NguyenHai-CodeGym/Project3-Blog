<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="header-desktop3 d-none d-lg-block">
    <div class="section__content section__content--p35">
        <div class="header3-wrap">
            <div class="header__logo">
                <a href="#">
                    <img src="admin-assets/images/icon/logo-white.png" alt="CoolAdmin"/>
                </a>
            </div>
            <div class="header__navbar">
                <ul class="list-unstyled">
                    <li class="has-sub">
                        <a href="/dashboard">
                            <i class="fas fa-tachometer-alt"></i>Quản Lý Blog
                            <span class="bot-line"></span>
                        </a>
                    </li>
                    <li>
                        <a href="/listCategory">
                            <i class="fas fa-shopping-basket"></i>
                            <span class="bot-line"></span>Quản Lý Category</a>
                    </li>
                    <li>
                        <a href="/indexBlog">
                            <i class="fas fa-trophy"></i>
                            <span class="bot-line"></span>Blog Page</a>
                    </li>
                </ul>
            </div>
            <div class="header__tool">
                <div class="account-wrap">
                    <div class="account-item account-item--style2 clearfix js-item-menu">
                        <div class="image">
                            <img src="admin-assets/images/icon/avatar-01.jpg" alt="John Doe"/>
                        </div>
                        <div class="content">
                            <a class="js-acc-btn" href="#">${fullName}</a>
                        </div>
                        <div class="account-dropdown js-dropdown">
                            <div class="info clearfix">
                                <div class="image">
                                    <a href="#">
                                        <img src="admin-assets/images/icon/avatar-01.jpg" alt="John Doe"/>
                                    </a>
                                </div>
                                <div class="content">
                                    <h5 class="name">
                                        <a href="#">john doe</a>
                                    </h5>
                                    <span class="email">${userName}</span>
                                </div>
                            </div>
                            <div class="account-dropdown__footer">
                                <a href="authentication?action=logout">
                                    <i class="zmdi zmdi-power"></i>Logout</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>