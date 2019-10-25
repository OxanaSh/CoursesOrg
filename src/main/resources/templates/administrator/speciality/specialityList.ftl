<#import "../administrationPanel.ftl" as c/>
<@c.page title="sbjects">

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
                <td><a href="/admin/speciality/delete/${speciality.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Delete</a></td>
                <td><a href="/admin/speciality/update/${speciality.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Update</a></td>

            </tr>
        </#list>
    </table>
    <a href="/admin/speciality/create" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Add new speciality</a>
</@c.page>