<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>

<nav class="navbar navbar-light sticky-top" style="background-color: #f2f2f2; border-bottom: 2px solid black;" >

    <a class="navbar-brand" href="/">
        <img src="https://img.icons8.com/pastel-glyph/64/000000/cat--v3.png" height="45" width="45" class="d-inline-block align-top" alt="">
        <span class="navbar-text">
            Welcome to our community!
          </span>
    </a>



    <#if isAuthenticated>
        <#list roles as role>
            <#if role == "ADMIN">
            <a href="/admin/" style="padding: 6px 8px 6px 16px;text-decoration: none;font-size: 20px;color: #818181; display: block;">Administrator menu</a>
            </#if>
        </#list>

        <form action="/logout" method="POST">
        <input type="submit" class="btn btn-dark" value="Sign out">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <#else>
        <a href="/login" class="btn btn-secondary btn-lg active" role="form" aria-pressed="true">Log in</a>

    </#if>


    <!--
     <a class="navbar-brand" href="/login" >
         <img src="https://image.flaticon.com/icons/svg/149/149951.svg" height="45" width="45" class="d-inline-block align-top" alt="">
     </a>
    -->

</nav>

<section class="main">

    <!-- section -->
    <section class="black">
        <header class="">
            <h1>Courses</h1>
        </header>
    </section><!-- end section -->

    <!-- section -->
    <section class="black">
        <div class="wrap">

            <div class="separator01"></div>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque gravida imperdiet magna in vehicula. Sed egestas orci non nunc rutrum, sit amet scelerisque ligula scelerisque. Curabitur mauris ipsum, cursus quis.</p>
        </div>
    </section><!-- end section -->

    <!-- section -->
    <section class="white">
        <div class="wrap">
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque gravida imperdiet magna in vehicula. Sed egestas orci non nunc rutrum, sit amet scelerisque ligula scelerisque. Curabitur mauris ipsum, cursus quis.</p>
            <div class="separator02"></div>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean eget erat volutpat, malesuada arcu vitae, iaculis diam. Pellentesque sagittis lacus tellus, quis faucibus dolor semper sit amet. Praesent placerat faucibus nibh. Nulla non mattis erat. Morbi ultrices, diam vitae ornare tincidunt, sapien libero sodales lorem, vitae commodo nisl mi at leo. Vestibulum posuere aliquet consequat. Vivamus mattis eget eros eget maximus. Ut vel neque iaculis, luctus metus ut, ultricies dolor.</p>
        </div>
    </section>



</section><!-- end main -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>


