<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <a href="/"><h2 class="text-center text-dark mt-5">Registration Form</h2></a>
            <div class="card my-5">

                <#--                action="/add-new-user" method="post"-->
                <form id="registrationForm" class="card-body cardbody-color p-lg-5">
                    <div class="mb-3">
                        <input name="nickname" type="text" class="form-control" id="Nickname" aria-describedby="User name" placeholder="Nickname">
                    </div>
                    <div class="mb-3">
                        <input name="species" type="text" class="form-control" id="Species" placeholder="Species">
                    </div>
                    <div class="mb-3">
                        <input name="breed" type="text" class="form-control" id="Breed" placeholder="Breed">
                    </div>
                    <div class="mb-3">
                        <input name="region" type="text" class="form-control" id="Region" placeholder="Region">
                    </div>
                    <div class="mb-3">
                        <input name="city" type="text" class="form-control" id="City" placeholder="City">
                    </div>
                    <div class="mb-3">
                        <input id="file" type="file">
                    </div>
                    <div id="submitButton" class="text-center"><button  type="submit" class="btn btn-primary px-5 mb-5 w-100"><a class="text-dark fw-bold">Add pet</a></button></div>
                    <div id="emailHelp" class="form-text mb-3 text-dark">
                        <div class="mb-2" >Go to login page ? <a href="/login" class="text-dark fw-bold">Login</a></div>
                        <div class="mb-2" >Forgot Password? <a href="/reset-password" class="text-dark fw-bold"> Reset Password</a></div>
                    </div>
                </form>
            </div>
            <p id="demo"></p>

        </div>
    </div>
</div>
<script src="js/registration.js"></script>