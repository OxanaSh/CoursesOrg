<#import "../administrationPanel.ftl" as c/>
<#import "/spring.ftl" as spring/>
<@c.page title="person">
    <div class="container" style="border: 2px solid black; padding: 20px 20px">
<legend>Update person information</legend>
        <form name="person" action="" method="POST">
            <br>Name:<@spring.formInput "personForm.name" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>Surname:<@spring.formInput "personForm.surname" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>Patronymic:<@spring.formInput "personForm.patronymic" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>Phone number:<@spring.formInput "personForm.phoneNumber" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>Date:<@spring.formInput "personForm.dateOfBirth", "class='from-control' readonly"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <script>
                $('#dateOfBirth').datepicker({
                    uiLibrary: 'bootstrap4'
                });
            </script>
            <br/>
            <input type="submit" class="btn btn-secondary btn-lg active" value="Update"/>
        </form>
    </div>
</@c.page>