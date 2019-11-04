<#import "../administrationPanel.ftl" as c/>
<#import "/spring.ftl" as spring/>
<@c.page title="student group">
    <div class="container" style="border: 2px solid black; padding: 20px 20px">

        <legend>Add students to group</legend>
        <form name="students" action="" method="POST">

            <br>

            <@spring.formCheckboxes "groupForm.students", students "<br>"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>


            <br/>
            <input type="submit" class="btn btn-secondary btn-lg active" value="Add"/>
        </form>

    </div>
</@c.page>