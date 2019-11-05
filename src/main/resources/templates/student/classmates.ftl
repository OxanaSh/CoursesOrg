<#import "studentPanel.ftl" as c/>
<@c.page title="administrator">

    <table class="table table-hover table-active table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>Subjects of youer speciality ${group.getGroupNumber()}</th>
            <th></th>
        </tr>
        </thead>
        <#list group.getStudents() as student>
            <tr>

                <td>${student.getFullName()}</td>
                <td>

                </td>

            </tr>
        </#list>
    </table>

</@c.page>