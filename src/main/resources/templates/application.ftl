<#import "topPanel.ftl" as c>
<#import "/spring.ftl" as spring/>
<@c.page title="application">
    <br/>
    <div class="container" style="border: 2px solid black; padding: 20px 20px">


    <legend>Enter your data</legend>
        <form name="student" action="" method="POST">
            <br>Name<@spring.formInput "applicationForm.name" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>Surname<@spring.formInput "applicationForm.surname" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>Patronymic<@spring.formInput "applicationForm.patronymic" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>Date of birth<@spring.formInput "applicationForm.dateOfBirth", "class='from-control' readonly" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <script>
                $('#dateOfBirth').datepicker({
                    uiLibrary: 'bootstrap4'
                });
            </script>
            <br>Phone number<@spring.formInput "applicationForm.phoneNumber" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
             <br>email<@spring.formInput "applicationForm.username" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>Speciality<@spring.formSingleSelect "applicationForm.speciality", specialities, "class='form-control'"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>Form of studying<@spring.formSingleSelect "applicationForm.formOfStudying", lessonForms, "class='form-control'"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>Degree<@spring.formSingleSelect "applicationForm.degree", degrees, "class='form-control'"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br/>Occupation<br><@spring.formRadioButtons "applicationForm.whomWantToBe", occupations, "<br>"/>

            <input type="submit" class="btn btn-secondary btn-lg active" value="Create"/>
        </form>

    </div>

</@c.page>