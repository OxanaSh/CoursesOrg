<#import "../administrationPanel.ftl" as c/>
<@c.page title="student group">

<table class="table table-hover table-active table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>Group number</th>
            <th>Speciality</th>
            <th>Form of studying</th>
            <th>Students</th>
            <th></th>
            <th></th>
            <th>Is enabled</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <#list groups as group>
            <tr>
                <td>${group.groupNumber}</td>

                <#if group.getSpeciality()?has_content>
                     <td>${group.getSpeciality().name}</td>
                 <#else >
                    <td>object does not exist</td>
                </#if>

                <td>${group.formOfStudying}</td>

                <#if group.getStudents()?has_content>
                <td> ${group.getCurrentStudentsNumber()}/${group.getMaxStudentsNumber()} </td>
                 <td>
                    <a class="btn" href="/admin/studentGroup/${group.id}/studentsList" role="button">
                        <img src="https://img.icons8.com/metro/104/000000/user-male.png" width="20" height="20">
                    </a>
                 </td>
                      <#else >
                <td>there are no students</td>
                          <td>
                              <a class="btn disabled" href="/admin/studentGroup/${group.id}/studentsList" role="button" tabindex="-1" aria-disabled="true">
                                  <img src="https://img.icons8.com/metro/104/000000/user-male.png" width="20" height="20">
                              </a>
                          </td>
                </#if>


                <td>
                   <a class="btn" href="/admin/studentGroup/students/${group.id}" role="button">
                        <img src="https://img.icons8.com/pastel-glyph/64/000000/create-new--v1.png" width="20" height="20">
                    </a>
                </td>



                <#if group.isEnabled()>
                    <td>yes</td>
                    <td><a href="/admin/studentGroup/delete/${group.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">disable</a></td>
                <#else>
                    <td>no</td>
                    <td><a href="/admin/studentGroup/delete/${group.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true"> enable </a></td>
                </#if>


                <td><a href="/admin/studentGroup/update/${group.id}" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Update</a></td>


            </tr>
        </div>
        </#list>
    </table>
    <a href="/admin/studentGroup/create" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">Add new student group</a>

</@c.page>