<#import "../administrationPanel.ftl" as c/>
<#import "/spring.ftl" as spring/>
<@c.page title="student">
    <div class="container" style="border: 2px solid black; padding: 20px 20px">
<legend>Update teacher information</legend>
        <form name="student" action="" method="POST">
            <br>Name:<@spring.formInput "teacherForm.name" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>Surname:<@spring.formInput "teacherForm.surname" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>Patronymic:<@spring.formInput "teacherForm.patronymic" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>Date:<@spring.formInput "teacherForm.dateOfBirth", "class='from-control' readonly"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <script>
                $('#dateOfBirth').datepicker({
                    uiLibrary: 'bootstrap4'
                });
            </script>
            <br>Degree:<@spring.formSingleSelect "teacherForm.degree", degrees, "class='from-control' readonly"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br/>
            <br>Date of starting work as a teacher:<@spring.formInput "teacherForm.experience", "class='from-control' readonly"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <script>
                $('#experience').datepicker({
                    uiLibrary: 'bootstrap4'
                });
            </script>
            <br>phone number:<@spring.formInput "teacherForm.phoneNumber" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br/>subjects:<br>
            <@spring.formCheckboxes "teacherForm.subjects", subjects "<br>"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <br>email:<@spring.formInput "teacherForm.username" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br/>

            <input type="submit" class="btn btn-secondary btn-lg active" value="Update"/>
        </form>
    </div>
</@c.page>