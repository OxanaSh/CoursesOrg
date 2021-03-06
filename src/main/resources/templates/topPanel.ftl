<#macro page title>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
    <link rel="icon" href="/images/catIcon.png" type="image/png" >
    <link rel="stylesheet" type="text/css" href="/static/css/scheduleStyle.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="icon" href="/images/catIcon.png" type="image/png" >
</head>
<body>

<nav class="navbar navbar-light sticky-top" style="background-color: #f2f2f2; border-bottom: 2px solid black;" >

    <a class="navbar-brand" href="/">
        <img src="https://img.icons8.com/pastel-glyph/64/000000/cat--v3.png" height="45" width="45" class="d-inline-block align-top" alt="">
        <span class="navbar-text">
            Welcome to our community!
          </span>
    </a>




   <!--
    <a class="navbar-brand" href="/login" >
        <img src="https://image.flaticon.com/icons/svg/149/149951.svg" height="45" width="45" class="d-inline-block align-top" alt="">
    </a>
   -->

</nav>



<div class="container">
    <#nested>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>
</#macro>