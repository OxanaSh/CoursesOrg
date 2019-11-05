<#import "../administrationPanel.ftl" as c/>
<#import "/spring.ftl" as spring/>
<@c.page title="student">
    <div class="container" style="border: 2px solid black; padding: 20px 20px">


    <legend>Add student</legend>
        <form name="student" action="" method="POST">
            <br>Enter password:<@spring.formInput "studentForm.password" "class='form-control'" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>Choose Group:<@spring.formMultiSelect "groupForm.groupNumber", groups, "class='form-control'" />

            <br/>

            <input type="submit" class="btn btn-secondary btn-lg active" value="Create"/>
        </form>

    </div>

</@c.page>