<#import "../addForm.ftl" as c/>
<#import "/spring.ftl" as spring/>
<@c.page title="subject">

    <fieldset>
        <legend>Add subject</legend>
        <form name="subject" action="" method="POST">

            <br>Name:<@spring.formInput "subjectForm.name" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <br>Hours:<@spring.formInput "subjectForm.hours" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <input type="submit" class="btn btn-secondary btn-lg active" value="Create"/>
        </form>
    </fieldset>

</@c.page>
