<#import "../administrationPanel.ftl" as c/>
<#import "/spring.ftl" as spring/>
<@c.page title="user">

    <div class="container" style="border: 2px solid black; padding: 20px 20px">
        <legend>Update user</legend>
        <form name="subject" action="" method="POST">

            <br>Name:<@spring.formInput "subjectForm.name" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <br>Hours:<@spring.formInput "subjectForm.hours" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <input type="submit" class="btn btn-secondary btn-lg active" value="Update"/>
        </form>

</div>
</@c.page>