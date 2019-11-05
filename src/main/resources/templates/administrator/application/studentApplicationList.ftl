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
            <th>Speciality</th>
            <th>Is approved</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <#list students as student>
            <tr>
                <td>${student.dateOfFilling}</td>
                <td>${student.getPerson().getFullName()}</td>
                <td>${student.person.getDateOfBirth()}</td>
                <td>${student.email}</td>
                <td>${student.person.getPhoneNumber()}</td>
                <td>${student.speciality.getName()}</td>
                <#if student.approval == false && student.enabled == false>
                    <td><p class="text-danger">Rejected</p></td>
                    <#elseif student.approval == true && student.enabled == false>
                        <td><p class="text-success">Approved</p></td>
                    <#else>
                    <td>
                        <a class="btn" href="/admin/changeApproved/${student.id}/true" role="button">
                            <img src="https://img.icons8.com/carbon-copy/64/000000/ok.png" width="50" height="50">
                        </a>
                        <a class="btn" href="/admin/changeApproved/${student.id}/false" role="button">
                            <img src="https://img.icons8.com/carbon-copy/100/000000/cancel.png" width="50" height="50">
                        </a>
                    </td>
                </#if>



            </tr>
        </div>
        </#list>
    </table>
    <!--<a href="/admin/studentGroup/create" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Add new student group</a>

</@c.page>