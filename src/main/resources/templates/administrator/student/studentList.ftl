<#import "../administrationPanel.ftl" as c/>
<@c.page title="subjects">

<table class="table table-hover table-active table-bordered">
        <thead class="thead-dark">
        <tr>

            <th>Id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Patronymic</th>
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
                <td><a href="/admin/student/delete/${student.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Delete</a></td>
                <td><a href="/admin/student/update/${student.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Update</a></td>

            </tr>
        </#list>
    </table>
    <a href="/admin/student/create" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Add new student</a>

</@c.page>