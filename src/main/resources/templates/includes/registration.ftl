<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <a href="/"><h2 class="text-center text-dark mt-5">Login Form</h2></a>
            <div class="card my-5">

                <form id="loginForm" class="card-body cardbody-color p-lg-5" action="/login" method='POST'>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="text-center">
                        <img src="https://cdn.pixabay.com/photo/2016/03/31/19/56/avatar-1295397__340.png"
                             class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3" width="200px"
                             alt="profile">
                    </div>

                    <div class="mb-3">
                        <input name="userEmail" type="email" class="form-control" iid="userEmail"
                               aria-describedby="emailHelp" placeholder="User Name / Email">
                    </div>
                    <div class="mb-3">
                        <input name="password" type="password" class="form-control" id="password"
                               placeholder="password">
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-primary px-5 mb-5 w-100">Login</button>
                    </div>
                    <div id="emailHelp" class="form-text mb-3 text-dark">
                        <div class="mb-2">Not Registered? <a href="/registration.html" class="text-dark fw-bold"> Create
                                an Account</a></div>
                        <div class="mb-2">Forgot Password? <a href="/reset-password.html" class="text-dark fw-bold">
                                Reset Password</a></div>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>