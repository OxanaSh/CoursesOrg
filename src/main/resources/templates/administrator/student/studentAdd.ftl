<#import "../addForm.ftl" as c/>
<#import "/spring.ftl" as spring/>
<@c.page title="student">

    <fieldset>
        <legend>Add speciality</legend>
        <form name="student" action="" method="POST">
            <br>Name:<@spring.formInput "personForm.name" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>Surname:<@spring.formInput "personForm.surname" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>Patronymic:<@spring.formInput "personForm.patronymic" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>Date:<@spring.formInput "personForm.dateOfBirth", "class='from-control' readonly"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <script>
                $('#dateOfBirth').datepicker({
                    uiLibrary: 'bootstrap4'
                });
            </script>
            <br>phone number:<@spring.formInput "personForm.phoneNumber" "class='form-control'" "text"/>
            <br>password:<@spring.formInput "studentForm.email" "class='form-control'" "text"/>
            <br>email:<@spring.formInput "studentForm.password" "class='form-control'" "text"/>


            <input type="submit" class="btn btn-secondary btn-lg active" value="Create"/>
        </form>
    </fieldset>

</@c.page>