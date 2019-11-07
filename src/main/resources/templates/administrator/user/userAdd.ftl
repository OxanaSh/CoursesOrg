<#import "../administrationPanel.ftl" as c/>
<#import "/spring.ftl" as spring/>
<@c.page title="user">
    <div class="container" style="border: 2px solid black; padding: 20px 20px">
        <legend>Add user</legend>
        <form name="subject" action="" method="POST">

            <br>username:<@spring.formInput "userForm.username" "class='form-control' required" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <br>password:<@spring.formInput "userForm.password" "class='form-control' required" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br/>
            <@spring.formCheckboxes "userForm.authorities", roles "<br>"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br/>



            <input type="submit" class="btn btn-secondary btn-lg active" value="Create"/>
        </form>
    </div>
</@c.page>
