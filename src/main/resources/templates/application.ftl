<#import "topPanel.ftl" as c/>
<@c.page title="login">



<div class="row h-100 justify-content-center align-items-center" style="margin:auto; padding: 50px">
    <form name="f" action="/login" method="POST" style="border: 2px solid black; padding: 20px 20px" class="rounded" >



        <div class="form-group" >
            <label for="exampleInputEmail1">Email address</label>
            <input  name="username" type="text" class="form-control" placeholder="Enter email">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
              <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>

        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input name="password" type="password" class="form-control"  placeholder="Password">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </div>

        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Check me out</label>
        </div>

        <input name="submit" type="submit" class="btn btn-dark" value="submit"/>

    </form>
    <a ></a>
</div>
</@c.page>