<div>
    <div class="container mt-5">
        <h3 class="text-center">My account</h3>
        <hr>
        <div class="row justify-content-around">
            <div class="col-12 col-lg-6">
                <div class="card" style="width: 100%; border: 2px solid #eee; padding: 10px;">
                    <div class="container text-center">
                        <#if user.avatarPath?has_content>
                        <img src="${user.avatarPath}" alt="${user.firstName} ${user.lastName}" class="img-fluid" style="max-width: 100%;">
                        <#else>
                            <img src="/img/default_image.png" alt="${user.firstName} ${user.lastName}" class="img-fluid" style="max-width: 100%;">
                        </#if>
                        <p class="p"><h4>${user.firstName} ${user.lastName}</h4></p>
                        <#if user.bio?has_content>
                        <p class="about-text italic-text">"${user.bio}"</p>
                        <#else>
                            <p class="about-text italic-text">No bio</p>
                        </#if>
                    </div>
                </div>
            </div>
            <div class="col-12 col-lg-6">
                <div class="card" style="width: 100%; border: 2px solid #eee; padding: 22px;">
                    <div class="container">
                        <h2 class="text-center">About me</h2>
                        <p><span class="label">Name:</span> ${user.firstName} ${user.lastName}</p>
                        <p><span class="label">Location:</span> ${user.region}, Republica Moldova</p>
                        <p><span class="label">Date of birth:</span> ${user.birthDate}</p>
                        <#if user.bio?has_content>
                            <p class="text-center">${user.bio} </p>
                        <#else>
                            <p class="text-center">No bio</p>
                        </#if>

                        <a href="/profile/edit" type="button" class="btn btn-primary btn-lg float-right">Edit Profile info</a>
                    </div>
                </div>
            </div>
        </div>

        <h2> My pets </h2>
        <hr>
    </div>


    <#list pets as pet>
        <div class="row justify-content-around">
            <div class="card" style="width: 18rem;">
                <img src="${pet.avatarPath}" class="card-img-top" alt="...">
                <div class="card-body">
                    <center>
                        <p class="card-text">${pet.nickname}</p>
                        <button>
                            <a href="/personal-pet/${pet.id}"> Check profile </a>
                        </button>
                    </center>
                </div>
            </div>
        </div>
    </#list >
</div>


