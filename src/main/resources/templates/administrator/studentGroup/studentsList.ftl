<#import "../administrationPanel.ftl" as c/>
<#import "/spring.ftl" as spring/>
<@c.page title="student group">
    <div class="container" style="border: 2px solid black; padding: 20px 20px">
        <table class="table table-hover table-active table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>Students of group ${studentGroup.getGroupNumber()}</th>
                <th></th>
            </tr>
            </thead>
            <#list students as student>
            <tr>

                <td>${student.getFullName()}</td>
                <td>
                    <a href="/admin/studentGroup/deleteStudent/${student.id}/fromGroup/${studentGroup.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true"> evict </a>
                </td>

            </tr>
            </#list>
        </table>
         </div>

</@c.page>