<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
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
            <th>Hours</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <#list subjects as subject>
            <tr>
                <td>${subject.id}</td>
                <td>${subject.getName()}</td>
                <td>${subject.getHours()}</td>
                <td><a href="/subject/delete/${subject.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Delete</a></td>
                <td><a href="/subject/update/${subject.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Update</a></td>

            </tr>
        </#list>
    </table>
    <a href="/subject/create" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Add new subject</a>

</div>
</body>
</html>