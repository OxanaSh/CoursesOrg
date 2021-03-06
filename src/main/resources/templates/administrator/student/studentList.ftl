<#import "../administrationPanel.ftl" as c/>
<@c.page title="subjects">

<table class="table table-hover table-active table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Patronymic</th>
            <th>Date of birth</th>
            <th>phoneNumber</th>
            <th>Email</th>
            <th>Enabled</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <#list students as student>
            <tr>
                 <#if student.getPerson()?has_content>
                     <td>${student.person.getName()}</td>
                     <td>${student.person.getSurname()}</td>
                     <td>${student.person.getPatronymic()}</td>
                     <td>${student.person.getDateOfBirth()}</td>
                     <td>${student.person.getPhoneNumber()}</td>
                 <#else >
                    <td>object does not exist</td>
                </#if>
                <td>${student.getUser().getUsername()}</td>

                <#if student.isEnabled()>
                    <td>yes</td>
                    <td><a href="/admin/student/delete/${student.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">disable</a></td>
                <#else>
                    <td>no</td>
                    <td><a href="/admin/student/delete/${student.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true"> enable </a></td>
                </#if>


                <td><a href="/admin/student/update/${student.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Update</a></td>

            </tr>
        </#list>
    </table>
    <a href="/admin/student/create" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Add new student</a>

</@c.page>