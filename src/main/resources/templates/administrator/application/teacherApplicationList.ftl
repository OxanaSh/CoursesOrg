<#import "../administrationPanel.ftl" as c/>
<@c.page title="student group">

<table class="table table-hover table-active table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>Date</th>
            <th>Full name</th>
            <th>Date of birth</th>
            <th>Email</th>
            <th>Phone number</th>
            <th>Degree</th>
            <th>Is approved</th>
            <th>Is Enabled</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <#list teachers as teacher>
            <tr>
                <td>${teacher.dateOfFilling}</td>
                <td>${teacher.getPerson().getFullName()}</td>
                <td>${teacher.person.getDateOfBirth()}</td>
                <td>${teacher.email}</td>
                <td>${teacher.person.getPhoneNumber()}</td>
                <td>${teacher.degree}</td>
                <#if teacher.approval == false && teacher.enabled == false>
                    <td>Rejected</td>
                    <#else>
                    <td>
                        <a class="btn" href="/admin/changeApproved/${teacher.id}/true" role="button">
                            <img src="https://img.icons8.com/carbon-copy/64/000000/ok.png" width="50" height="50">
                        </a>
                        <a class="btn" href="/admin/changeApproved/${teacher.id}/false" role="button">
                            <img src="https://img.icons8.com/carbon-copy/100/000000/cancel.png" width="50" height="50">
                        </a>
                    </td>
                </#if>

                <#if teacher.isEnabled()>
                    <td>yes</td>
                    <td><a href="/admin/teacher/delete/${teacher.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">disable</a></td>
                <#else>
                    <td>no</td>
                    <td><a href="/admin/teacher/delete/${teacher.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true"> enable </a></td>
                </#if>


            </tr>
        </div>
        </#list>
    </table>
    <!--<a href="/admin/studentGroup/create" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Add new student group</a>

</@c.page>