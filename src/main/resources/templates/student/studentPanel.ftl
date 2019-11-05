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
    <link rel="stylesheet" type="text/css" href="/css/studentStyle.css">
    <link rel="icon" href="/images/catIcon.png" type="image/png" >
</head>
<style>


</style>
<body>
<main>
    <h1>
        <div>
            <#nested>
        </div>
    </h1>
    <input type="checkbox" id="myInput">
    <label for="myInput">
        <span class="bar top"></span>
        <span class="bar middle"></span>
        <span class="bar bottom"></span>
    </label>
    <aside>
        <div class="aside-section aside-left">
            <div class="aside-content">
                <img src="https://img.icons8.com/pastel-glyph/64/000000/cat--v3.png" height="70" width="70" class="d-inline-block align-top" alt="">

                <p> Welcome to our community, student!</p>
                <form action="/logout" method="POST">
                    <input type="submit" class="btn btn-dark" value="Sign out">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </div>
        </div>
        <div class="aside-section aside-right">
            <ul class="aside-list">
                <li><a href="/student/user/" class="aside-anchor">Main</a></li>
                <li><a href="/student/user/classmates" class="aside-anchor">My group</a></li>
                <li><a href="/student/user/subjects" class="aside-anchor">My subjects</a></li>
                <li><a href="" class="aside-anchor">Teachers</a></li>
            </ul>
        </div>
    </aside>
</main>
</body>
</html>
</#macro>