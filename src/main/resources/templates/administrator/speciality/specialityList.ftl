<#import "../administrationPanel.ftl" as c/>
<@c.page title="sbjects">

    <table class="table table-hover table-active table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>Name</th>
            <th>code</th>
            <th>payment</th>
            <th>Subjects</th>
            <th>Enabled</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <#list specialities as speciality>
            <tr>
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
                <#if speciality.isEnabled()>
                    <td>yes</td>
                    <td><a href="/admin/speciality/delete/${speciality.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">disable</a></td>
                <#else>
                    <td>no</td>
                    <td><a href="/admin/speciality/delete/${speciality.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true"> enable </a></td>
                </#if>
                <td><a href="/admin/speciality/update/${speciality.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Update</a></td>

            </tr>
        </#list>
    </table>
    <a href="/admin/speciality/create" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Add new speciality</a>
</@c.page>