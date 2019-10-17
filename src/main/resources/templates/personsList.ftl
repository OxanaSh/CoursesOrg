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
            <th>surname</th>
            <th>patronymic</th>
            <th>date of birth</th>
            <th>phone number</th>

        </tr>
        </thead>
        <#list persons as person>
            <tr>
                <td>${person.id}</td>
                <td>${person.getName()}</td>
                <td>${person.getSurname()}</td>
                <td>${person.getPatronymic()}</td>
                <td>${person.getDateOfBirth()}</td>
                <td>${person.getPhoneNumber()}</td>
                   </tr>
        </#list>
    </table>
    <a href="/person/create" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Add new person</a>

</div>
</body>
</html>