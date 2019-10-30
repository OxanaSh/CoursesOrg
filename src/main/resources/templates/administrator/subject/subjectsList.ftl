<#import "../administrationPanel.ftl" as c/>
<@c.page title="subjects">



    <table class="table table-hover table-active table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>Name</th>
            <th>Hours</th>
            <th>Enabled</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <#list subjects as subject>
            <tr>
                <td>${subject.getName()}</td>
                <td>${subject.getHours()}</td>
                <#if subject.isEnabled()>
                    <td>yes</td>
                    <td><a href="/admin/subject/delete/${subject.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">disable</a></td>
                <#else>
                    <td>no</td>
                    <td><a href="/admin/subject/delete/${subject.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true"> enable </a></td>
                </#if>
                 <td><a href="/admin/subject/update/${subject.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Update</a></td>

            </tr>
        </#list>
    </table>
    <a href="/admin/subject/create" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Add new subject</a>

</@c.page>