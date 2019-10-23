<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <fieldset>
        <legend>Add speciality</legend>
        <form name="student" action="" method="POST">
            <br>Name:<@spring.formInput "personForm.name" "class='form-control'" "text"/>
            <br>Surname:<@spring.formInput "personForm.surname" "class='form-control'" "text"/>
            <br>Patronymic:<@spring.formInput "personForm.patronymic" "class='form-control'" "text"/>
             <br>Date:<@spring.formInput "personForm.dateOfBirth", "class='from-control' readonly"/>
            <script>
                $('#dateOfBirth').datepicker({
                    uiLibrary: 'bootstrap4'
                });
            </script>
            <br>phone number:<@spring.formInput "personForm.phoneNumber" "class='form-control'" "text"/>
            <br>password:<@spring.formInput "studentForm.email" "class='form-control'" "text"/>
            <br>email:<@spring.formInput "studentForm.password" "class='form-control'" "text"/>


            <input type="submit" class="btn btn-secondary btn-lg active" value="Create"/>
        </form>
    </fieldset>
</div>







</body>
</html>