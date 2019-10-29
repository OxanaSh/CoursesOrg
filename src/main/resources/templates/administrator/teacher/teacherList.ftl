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
            <th>Degree</th>
            <th>Experience</th>
            <th>Subject(s)</th>
            <th>Enabled</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <#list teachers as teacher>
            <tr>
                <td>${teacher.id}</td>
                 <#if teacher.getPerson()?has_content>
                     <td>${teacher.person.getName()}</td>
                     <td>${teacher.person.getSurname()}</td>
                     <td>${teacher.person.getPatronymic()}</td>
                     <td>${teacher.person.getDateOfBirth()}</td>
                     <td>${teacher.person.getPhoneNumber()}</td>
                 <#else >
                    <td>object does not exist</td>
                </#if>
                <td>${teacher.getUser().getUsername()}</td>
                <td>${teacher.getDegree()}</td>
                <td>${teacher.getExperience()}</td>

                <#if teacher.getSubjects()?has_content>
                    <td><#list teacher.getSubjects() as specialitySubjects>
                            ${specialitySubjects.getName()}<br>
                        </#list></td>
                <#else >
                    <td>object does not exist</td>
                </#if>


                <#if teacher.isEnabled()>
                    <td>yes</td>
                    <td><a href="/admin/teacher/delete/${teacher.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">un enable</a></td>
                <#else>
                    <td>no</td>
                    <td><a href="/admin/teacher/delete/${teacher.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true"> enable </a></td>
                </#if>


                <td><a href="/admin/teacher/update/${teacher.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Update</a></td>

            </tr>
        </#list>
    </table>
    <a href="/admin/teacher/create" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Add new student</a>

</@c.page>