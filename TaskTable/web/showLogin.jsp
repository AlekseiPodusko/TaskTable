
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h2 class="my-2 w-100 d-flex justify-content-center">Enter username and password </h2>
<div class="w-100 d-flex justify-content-center">
    <form action="login" method="POST" >
      <div class="card border-0 px-3" style="width: 20em;">
        <div class="form-group">
            <label for="login" class="form-label mt-2">Username</label>
            <input type="text" class="form-control" name="login" value="${name}">
        </div>
        <div class="form-group">
            <label for="password" class="form-label mt-2">Password</label>
            <input type="password" class="form-control" name="password" value="${name}">
        </div>
        <input class="btn btn-primary mt-2" type="submit" value="Log In">
        <h4 class="w-100 text-center mt-3"><a href="showRegistration">Registration</a></h4>
      </div>
    </form>
</div>