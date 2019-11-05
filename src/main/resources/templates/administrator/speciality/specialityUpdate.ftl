<#import "../administrationPanel.ftl" as c/>
<#import "/spring.ftl" as spring/>
<@c.page title="speciality">
    <div class="container" style="border: 2px solid black; padding: 20px 20px">
<legend>Update speciality</legend>
        <form name="speciality" action="" method="POST">
            <br>Code:<@spring.formInput "specialityForm.code" "class='form-control' required" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <br>Payment:<@spring.formInput "specialityForm.payment" "class='form-control' required" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <br>Name:<@spring.formInput "specialityForm.name" "class='form-control' required" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>
            <@spring.formCheckboxes "specialityForm.subjects", mavs "<br>"/>
            <br/>
            <input type="submit" class="btn btn-secondary btn-lg active" value="Update"/>
        </form>
    </div>
</@c.page>