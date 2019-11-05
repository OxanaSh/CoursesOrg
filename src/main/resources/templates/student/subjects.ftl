<#import "studentPanel.ftl" as c/>
<@c.page title="administrator">

    <table class="table table-hover table-active table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>Subjects of your speciality ${speciality.getName()}</th>
            <th></th>
        </tr>
        </thead>
        <#list speciality.getSubjects() as subject>
            <tr>

                <td>${subject.getName()}</td>
                <td>

                </td>

            </tr>
        </#list>
    </table>

</@c.page>