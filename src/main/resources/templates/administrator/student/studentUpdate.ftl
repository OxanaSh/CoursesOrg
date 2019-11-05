<#import "../administrationPanel.ftl" as c/>
<#import "/spring.ftl" as spring/>
<@c.page title="student">
    <div class="container" style="border: 2px solid black; padding: 20px 20px">
<legend>Update student information</legend>
        <form name="student" action="" method="POST">
            <br>Name:<@spring.formInput "studentForm.name" "class='form-control'  required" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>Surname:<@spring.formInput "studentForm.surname" "class='form-control'  required" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>Patronymic:<@spring.formInput "studentForm.patronymic" "class='form-control'  required" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>Date:<@spring.formInput "studentForm.dateOfBirth", "class='from-control' readonly"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <script>
                $('#dateOfBirth').datepicker({
                    uiLibrary: 'bootstrap4'
                });
            </script>
            <br>phone number:<@spring.formInput "studentForm.phoneNumber" "class='form-control'  required" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>email:<@spring.formInput "studentForm.username" "class='form-control'  required" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br/>
            <input type="submit" class="btn btn-secondary btn-lg active" value="Update"/>
        </form>
    </div>
</@c.page>