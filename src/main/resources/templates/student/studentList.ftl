<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid" style="padding-top: 20px">

    <table class="table table-hover table-active table-bordered">
        <thead class="thead-dark">
        <tr>

            <th>Id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Date of birth</th>
            <th>phoneNumber</th>
            <th>Email</th>
            <th>password</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <#list students as student>
            <tr>
                <td>${student.id}</td>
                 <#if student.getPerson()?has_content>
                     <td>${student.person.getName()}</td>
                     <td>${student.person.getSurname()}</td>
                     <td>${student.person.getPatronymic()}</td>
                     <td>${student.person.getDateOfBirth()}</td>
                     <td>${student.person.getPhoneNumber()}</td>
                 <#else >
                    <td>object does not exist</td>
                </#if>
                <td>${student.getEmail()}</td>
                <td>${student.getPassword()}</td>
                <td><a href="/student/delete/${student.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Delete</a></td>
                <td><a href="/student/update/${student.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Update</a></td>

            </tr>
        </#list>
    </table>
    <a href="/speciality/create" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Add new student</a>

</div>
</body>
</html>