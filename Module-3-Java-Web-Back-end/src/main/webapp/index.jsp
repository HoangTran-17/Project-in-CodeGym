
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Huế Motorcycle Market | CHợ xe máy</title>

    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
  </head>
  <body>
  <header class="row">
    <div class="col-sm-3>
      <a href="index.jsp" class="logo">
        <figure>
          <img src="https://www.webike.vn/frontend/moto-v2/pc/img/logo-moto.png?159169869320200827"
               alt="Hue Motorcycle - Logo">
        </figure>
      </a>
    </div>
    <div class="col-sm-6>
      <form id="search" method="get" action="https://www.webike.vn/cho-xe-may/danh-sach-xe.html">
        <div class="button-area">
          <button type="button" id="btn_submit">
            <i class="icon-v2 icon-search-white"></i>
          </button>
        </div>
        <div class="search-input">
          <input class="txt-search" id="keyword" placeholder="Nhập từ khóa tìm kiếm" type="text" value=""
                 name="q">
          <label id="div_loading " class="loading"></label>
          <input id="m_code" type="hidden" value="" name="m_code" />
        </div>

      </form>
    </div>
    <div class="col-sm-3>
      <ul class="account dropdown">
        <li>
          <a href="@@@@@@@/dang-tin-ban-xe.html" class="btn-header">
            <i class="icon-v2 icon-post"></i>
            Đăng bán xe
          </a>
        </li>
        <li>
          <a title="Đăng nhập" href="@@@@@@@/sign-in.html" class="btn-sign-in">
            <i class="icon-v2 icon-user"></i> Đăng nhập
          </a>
        </li>
        <li>
          <a title="Đăng ký" href="@@@@@@@@/sign-up.html" class="btn-sign-up">
            Đăng ký
          </a>
        </li>
        <ul class="dropdown-menu">
          <li class="login">
            <a title="Đăng nhập" href="https://www.webike.vn/sign-in.html"
               class="btn btn-block btn-danger btn-sm btn-login">Đăng nhập</a>
            <a title="Đăng ký" href="https://www.webike.vn/sign-up.html"
               class="btn btn-block btn-link btn-sm btn-signup">Đăng ký</a>
          </li>
        </ul>
      </ul>
    </div>
  </header>

  <nav>
    <ul>
      <li>News</li>
      <li>Sports</li>
      <li>Weather</li>
    </ul>
  </nav>

  <section>
    <h2>News Section</h2>
    <article>
      <h2>News Article</h2>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque in porta lorem. Morbi
        condimentum est
        nibh, et consectetur tortor feugiat at.</p>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque in porta lorem. Morbi
        condimentum est
        nibh, et consectetur tortor feugiat at.</p>
    </article>
    <article>
      <h2>News Article</h2>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque in porta lorem. Morbi
        condimentum est
        nibh, et consectetur tortor feugiat at.</p>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque in porta lorem. Morbi
        condimentum est
        nibh, et consectetur tortor feugiat at.</p>
    </article>
  </section>

  <footer>
    <p>&copy; 2014 Monday Times. All rights reserved.</p>
  </footer>
  </body>
</html>
