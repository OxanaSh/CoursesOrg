<#macro page title>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>${title}</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
   <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="icon" href="/images/catIcon.png" type="image/png" >
    <link rel="stylesheet" type="text/css" href="/static/css/scheduleStyle.css">
   </head>
<style>
    body {
        font-family: Helvetica;/*"Lato", sans-serif;*/
    }

    .sidenav {
        height: 100%;
        width: 130px;
        position: fixed;
        z-index: 1;
        top: 70px;
        left: 0;
        background-color: #111;
        overflow-x: hidden;
        padding-top: 8px;
        padding-bottom: 8px;
    }

    .sidenav a, .dropdown-btn {
        padding: 6px 8px 6px 16px;
        text-decoration: none;
        font-size: 20px;
        color: #818181;
        display: block;
        border: none;
        background: none;
        width: 100%;
        text-align: center;
        cursor: pointer;
        outline: none;
    }

    .sidenav a:hover, .dropdown-btn:hover  {
        color: #f1f1f1;
    }

    .main {
         margin-left: 130px; /*Same as the width of the sidenav */
        font-size: 18px; /* Increased text to enable scrolling */
        padding-top:10px;
        padding-left:10px;
        padding-right:10px;
    }


    /* Add an active class to the active dropdown button */
    .active {
        background-color: rosybrown;
        color: black;
    }

    /* Dropdown container (hidden by default). Optional: add a lighter background color and some left padding to change the design of the dropdown content */
    .dropdown-container {
        display: none;
        background-color: #262626;
        padding-left: 8px;
    }

    /* Optional: Style the caret down icon */
    .fa-caret-down {
        float: right;
        padding-right: 8px;
    }

    @media screen and (max-height: 450px) {
        .sidenav {padding-top: 15px;}
        .sidenav a {font-size: 13px;}
    }
</style>
<style>
    hr.style5 {
        border-top: 2px dashed #8c8b8b;
    }
</style>


<body>

<nav class="navbar navbar-light sticky-top" style="background-color: #f2f2f2; border-bottom: 2px solid black;" >

        <a class="navbar-brand" href="/">
            <img src="https://img.icons8.com/pastel-glyph/64/000000/cat--v3.png" height="45" width="45" class="d-inline-block align-top" alt="">
            <span class="navbar-text">
            Welcome to our community!
          </span>
        </a>

        <form action="/logout" method="POST">
            <input type="submit" class="btn btn-dark" value="Sign out">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

    <!--
    <a class="navbar-brand" href="/login" >
        <img src="https://image.flaticon.com/icons/svg/149/149951.svg" height="45" width="45" class="d-inline-block align-top" alt="">
    </a>
    -->
</nav>



<div class="sidenav">
    <a href="/admin/studentGroup/list" class="w3-bar-item w3-button w3-hover-white">Groups</a>
    <a href="/admin/speciality/list" class="w3-bar-item w3-button w3-hover-white">Specialities</a>
    <a href="/admin/subject/list" class="w3-bar-item w3-button w3-hover-white">Subjects</a>
   <!-- <a href="/admin/person/list" class="w3-bar-item w3-button w3-hover-white">Person</a> -->
    <a href="/admin/student/list" class="w3-bar-item w3-button w3-hover-white">Student</a>
    <a href="/admin/teacher/list" class="w3-bar-item w3-button w3-hover-white">Teacher</a>
    <hr class="style5"/>
    <a href="/admin/user/list" class="w3-bar-item w3-button w3-hover-white">User</a>

    <button class="dropdown-btn">Application
        <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-container">
        <a href="/admin/teacher/application">Teachers</a>
        <a href="/admin/student/application">Students</a>
    </div>


</div>

<div class="main">
    <#nested/>
</div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script>
    /* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
    var dropdown = document.getElementsByClassName("dropdown-btn");
    var i;

    for (i = 0; i < dropdown.length; i++) {
        dropdown[i].addEventListener("click", function() {
            this.classList.toggle("active");
            var dropdownContent = this.nextElementSibling;
            if (dropdownContent.style.display === "block") {
                dropdownContent.style.display = "none";
            } else {
                dropdownContent.style.display = "block";
            }
        });
    }
</script>
</body>
</html>
</#macro>