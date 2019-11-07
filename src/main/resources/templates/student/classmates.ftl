<#import "studentPanel.ftl" as c/>
<@c.page title="administrator">
<#if group?has_content>
    <table class="table table-hover table-active table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>Subjects of your speciality ${group.getGroupNumber()}</th>
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
    <#else >
    You have no group for current moment
</#if>
</@c.page>