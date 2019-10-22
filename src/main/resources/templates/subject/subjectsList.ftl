<#import "../administrationPanel.ftl" as c/>
<@c.page title="subjects">



    <table class="table table-hover table-active table-bordered">
        <thead class="thead-dark">
        <tr>

            <th>Id</th>
            <th>Name</th>
            <th>Hours</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <#list subjects as subject>
            <tr>
                <td>${subject.id}</td>
                <td>${subject.getName()}</td>
                <td>${subject.getHours()}</td>
                <td><a href="/subject/delete/${subject.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Delete</a></td>
                <td><a href="/subject/update/${subject.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Update</a></td>

            </tr>
        </#list>
    </table>
    <a href="/subject/create" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Add new subject</a>

</@c.page>