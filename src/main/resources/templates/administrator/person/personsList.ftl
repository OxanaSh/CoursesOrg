<#import "../administrationPanel.ftl" as c/>
<@c.page title="subjects">

<table class="table table-hover table-active table-bordered">
        <thead class="thead-dark">
        <tr>

            <th>Name</th>
            <th>surname</th>
            <th>patronymic</th>
            <th>date of birth</th>
            <th>phone number</th>
            <th>Enabled</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <#list persons as person>
            <tr>
                <td>${person.getName()}</td>
                <td>${person.getSurname()}</td>
                <td>${person.getPatronymic()}</td>
                <td>${person.getDateOfBirth()}</td>
                <td>${person.getPhoneNumber()}</td>
                <#if person.isEnabled()>
                    <td>yes</td>
                    <td><a href="/admin/person/delete/${person.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">disable</a></td>
                <#else>
                    <td>no</td>
                    <td><a href="/admin/person/delete/${person.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true"> enable </a></td>
                </#if> <td><a href="/admin/person/update/${person.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Update</a></td>

            </tr>
        </#list>
    </table>
    <a href="/admin/person/create" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Add new person</a>

</@c.page>