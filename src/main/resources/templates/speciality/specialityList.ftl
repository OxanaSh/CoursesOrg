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
            <th>code</th>
            <th>payment</th>
            <th>Subjects</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <#list specialities as speciality>
            <tr>
                <td>${speciality.id}</td>
                <td>${speciality.getName()}</td>
                <td>${speciality.getCode()}</td>
                <td>${speciality.getPayment()}</td>
                <#if speciality.getSubjects()?has_content>
                    <td><#list speciality.getSubjects() as specialitySubjects>
                     ${specialitySubjects.getName()}<br>
                        </#list></td>
                <#else >
                    <td>object does not exist</td>
                </#if>
                <td><a href="/speciality/delete/${speciality.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Delete</a></td>
                <td><a href="/speciality/update/${speciality.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Update</a></td>

            </tr>
        </#list>
    </table>
    <a href="/speciality/create" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Add new speciality</a>

</div>
</body>
</html>