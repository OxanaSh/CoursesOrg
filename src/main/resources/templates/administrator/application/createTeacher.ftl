<#import "../administrationPanel.ftl" as c/>
<#import "/spring.ftl" as spring/>
<@c.page title="student">
    <div class="container" style="border: 2px solid black; padding: 20px 20px">


    <legend>Add teacher</legend>
        <form name="student" action="" method="POST">
            <br>Enter password:<@spring.formInput "teacherForm.password" "class='form-control' required" "text"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br>Date of starting work as a teacher:<@spring.formInput "teacherForm.experience", "class='from-control' readonly"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <script>
                $('#experience').datepicker({
                    uiLibrary: 'bootstrap4'
                });
            </script>
            <br>Degree:<@spring.formSingleSelect "teacherForm.degree", degrees, "class='from-control' readonly"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br/>Subjects:<br/><@spring.formCheckboxes "teacherForm.subjects", subjects "<br>"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <br/>
            <input type="submit" class="btn btn-secondary btn-lg active" value="Create"/>
        </form>

    </div>

</@c.page>