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
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body >

<nav class="navbar navbar-light sticky-top" style="background-color: #f2f2f2; border-bottom: 2px solid black;" >

    <a class="navbar-brand" href="/">
        <img src="https://img.icons8.com/pastel-glyph/64/000000/cat--v3.png" height="45" width="45" class="d-inline-block align-top" alt="">
        <span class="navbar-text">
            Welcome to our community!
          </span>
            </a>
    <a class="navbar-brand" href="/login" >
        <img src="https://image.flaticon.com/icons/svg/149/149951.svg" height="45" width="45" class="d-inline-block align-top" alt="">
    </a>

</nav>



<div class="container">
    <#nested>
</div>
</body>
</html>
</#macro>