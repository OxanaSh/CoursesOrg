<#import "../administrationPanel.ftl" as c/>
<@c.page title="subjects">

<table class="table table-hover table-active table-bordered">
        <thead class="thead-dark">
        <tr>

            <th>Id</th>
            <th>Name</th>
            <th>surname</th>
            <th>patronymic</th>
            <th>date of birth</th>
            <th>phone number</th>
            <th></th>
            <th></th>
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
                <td><a href="/person/delete/${person.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Delete</a></td>
                <td><a href="/person/update/${person.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Update</a></td>

            </tr>
        </#list>
    </table>
    <a href="/person/create" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Add new person</a>

</@c.page>