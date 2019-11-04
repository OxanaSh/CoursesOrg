<#import "../administrationPanel.ftl" as c/>
<#import "/spring.ftl" as spring/>
<@c.page title="student group">
    <div class="container" style="border: 2px solid black; padding: 20px 20px">


    <legend>Add group</legend>
        <form name="group" action="" method="POST">
            <br>Name:<@spring.formInput "groupForm.groupNumber" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <br>Speciality:<@spring.formSingleSelect "groupForm.speciality", specialities, "class='form-control'"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <br>Form of studying:<@spring.formSingleSelect "groupForm.formOfStudying", lessonForms, "class='form-control'"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <br>Max number of students:<@spring.formInput "groupForm.maxStudentsNumber", "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <br/>

            <input type="submit" class="btn btn-secondary btn-lg active" value="Create"/>
        </form>

    </div>

</@c.page>