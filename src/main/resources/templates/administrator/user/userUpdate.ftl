<#import "../administrationPanel.ftl" as c/>
<#import "/spring.ftl" as spring/>
<@c.page title="user">

    <div class="container" style="border: 2px solid black; padding: 20px 20px">
        <legend>Update user</legend>
        <form name="user" action="" method="POST">

            <br>username:<@spring.formInput "userForm.username" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <@spring.formCheckboxes "userForm.authorities", roles "<br>"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <br/>
            <input type="submit" class="btn btn-secondary btn-lg active" value="Update"/>
        </form>

</div>
</@c.page>