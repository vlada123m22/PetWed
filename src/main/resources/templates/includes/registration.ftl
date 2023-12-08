<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <a href="/"><h2 class="text-center text-dark mt-5">Registration Form</h2></a>
            <div class="card my-5">

                <form id="registrationForm" class="card-body cardbody-color p-lg-5" action="/login.html" method="get">

                    <div class="mb-3">
                        <input name="firstName" type="text" class="form-control" id="FirstName" aria-describedby="User name" placeholder="First name">
                    </div>
                    <div class="mb-3">
                        <input name="lastName" type="text" class="form-control" id="LastName" aria-describedby="emailHelp" placeholder="Last name">
                    </div>
                    <div class="mb-3">
                        <input name="email" type="text" class="form-control" id="Username" aria-describedby="emailHelp" placeholder="Email">
                    </div>
                    <div class="mb-3">
                        <input name="region" type="text" class="form-control" id="Region" placeholder="Region">
                    </div>
                    <div class="mb-3">
                        <input name="city" type="text" class="form-control" id="City" placeholder="City">
                    </div>
                    <div class="mb-3">
                        <input name="gender" type="text" class="form-control" id="City" placeholder="Gender">
                    </div>
                    <div class="mb-3">
                        <input name="birthDate" type="date" class="form-control" id="City" placeholder="Date of birth">
                    </div>
                    <div class="mb-3">
                        <input name="password" type="password" class="form-control" id="password" placeholder="Password">
                    </div>
                    <div class="mb-3">
                        <input name="passwordForCheck" type="password" class="form-control" id="passwordCheck" placeholder="Confirm Password">
                    </div>
                    <div id="submitButton" class="text-center">
                            <input type="submit" value="Create Account" class="btn btn-primary px-5 mb-5 w-100" style="background-color: #E28E9E; border: 2px solid #E28E9E; text-decoration: underline; font-size: 18px;">

                    </div>
                    <div id="emailHelp" class="form-text mb-3 text-dark">
                        <div class="mb-2">Go to login page? <a href="/login" class="text-dark fw-bold">Login</a></div>
                        <div class="mb-2">Forgot Password? <a href="/reset-password" class="text-dark fw-bold">Reset Password</a></div>
                    </div>
                </form>
            </div>
            <p id="demo"></p>
        </div>
    </div>
</div>
<script src="/js/registration.js"></script>
