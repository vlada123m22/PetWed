<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <a href="/"><h2 class="text-center text-dark mt-5">Login Form</h2></a>
            <div class="card my-5">
                <form id="loginForm" class="card-body cardbody-color p-lg-5" action="/login" method='POST'>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="mb-3">
                        <input name="userEmail" type="email" class="form-control" id="userEmail" aria-describedby="emailHelp" placeholder="User Name / Email">
                    </div>
                    <div class="mb-3">
                        <input name="password" type="password" class="form-control" id="password" placeholder="password">
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-primary px-5 mb-5 w-100" style="background-color: #E28E9E; border: 2px solid #E28E9E; text-decoration: underline; font-size: 18px;">Login</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
