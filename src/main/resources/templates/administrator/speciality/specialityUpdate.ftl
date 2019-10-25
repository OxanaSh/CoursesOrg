<#import "../addForm.ftl" as c/>
<#import "/spring.ftl" as spring/>
<@c.page title="subject">

    <fieldset>
        <legend>Update speciality</legend>
        <form name="speciality" action="" method="POST">
            <br>Code:<@spring.formInput "specialityForm.code" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <br>Payment:<@spring.formInput "specialityForm.payment" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <br>Name:<@spring.formInput "specialityForm.name" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <br>

            <@spring.formCheckboxes "specialityForm.subjects", mavs "<br>"/>


            <input type="submit" class="btn btn-secondary btn-lg active" value="Update"/>
        </form>
    </fieldset>

</@c.page>