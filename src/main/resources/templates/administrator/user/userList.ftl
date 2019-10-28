<#import "../administrationPanel.ftl" as c/>
<@c.page title="users">

<table class="table table-hover table-active table-bordered">
        <thead class="thead-dark">
        <tr>

            <th>Id</th>
            <th>Username</th>
            <th>Authorities</th>
            <th>Enabled</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <#list users as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.getUsername()}</td>
                <#if user.getAuthorities()?has_content>
                    <td><#list user.getAuthorities() as authorities>
                     ${authorities}<br>
                    </#list></td>
                <#else >
                <td>does not exist</td>
                </#if>

                <#if user.isEnabled()>
                    <td>yes</td>
                    <td><a href="/admin/user/delete/${user.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">un enable</a></td>
                <#else>
                        <td>no</td>
                        <td><a href="/admin/user/delete/${user.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true"> enable </a></td>
                </#if>
                 <td><a href="/admin/user/update/${user.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Update</a></td>

            </tr>
        </#list>
    </table>
    <a href="/admin/user/create" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Add new user</a>

</@c.page>