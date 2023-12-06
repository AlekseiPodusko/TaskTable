
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h2 class="my-2 w-100 d-flex justify-content-center">Registration</h2>
<div class="w-100 d-flex justify-content-center">
    <form action="registration" method="POST">
        <div class="card border-0 px-3 mb-2" style="width: 70em;">
            <div class="row gx-5">
                <div class="form-group col">
                    <label class="form-label mt-3">Name</label>
                    <input type="text" class="form-control" name="firstName" placeholder="Enter your name">
                </div>
                <div class="form-group col">
                    <label class="form-label mt-3">Surname</label>
                    <input type="text" class="form-control" name="sureName" placeholder="Enter your surname">
                </div>
                <div class="form-group col">
                    <label class="form-label mt-3">Phone</label>
                    <input type="text" class="form-control" name="phone" placeholder="Enter your phone">
                </div>
            </div>
            <div class="row gx-5">
                <div class="form-group col">
                    <label class="form-label mt-2">Username</label>
                    <input type="text" class="form-control mb-3" name="login" placeholder="Enter Username">
                </div>
                <div class="form-group col">
                    <label class="form-label mt-2">Password</label>
                    <input type="password" class="form-control mb-3" name="password1" placeholder="Enter your password">
                </div>
                <div class="form-group col">
                    <label class="form-label mt-2">Password confirmation</label>
                    <input type="password" class="form-control mb-3" name="password2" placeholder="Repeat your password">
                </div>
            </div>
        </div>
        <div>
            <div class="w-100 d-flex justify-content-center">
                <button type="submit" class="btn btn-primary">Registration</button>
            </div>
        </div>
    </form>
</div>