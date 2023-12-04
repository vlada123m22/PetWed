<div>
    <div class="container mt-5">
        <hr>
        <div class="row justify-content-around">
            <div class="col-12 col-lg-6">
                <div class="card" style="width: 100%; border: 2px solid #eee; padding: 10px;">
                    <div class="container text-center">
                        <img src="${user.avatarPath}" alt="${user.firstName} ${user.lastName}" class="img-fluid"
                             style="max-width: 100%;">
                        <p class="p"><h4>${user.firstName} ${user.lastName}</h4></p>
                        <p class="about-text italic-text">"${user.bio}"</p>
                    </div>
                </div>
            </div>
            <div class="col-12 col-lg-6">
                <div class="card" style="width: 100%; border: 2px solid #eee; padding: 22px;">
                    <div class="container">
                        <h2 class="text-center">About me</h2>
                        <p><span class="label">Name:</span> ${user.firstName} ${user.lastName}</p>
                        <p><span class="label">Location:</span> ${user.region}, Republica Moldova</p>
                        <p><span class="label">Date of birth:</span> ${user.birthDate} y/o</p>
                        <p class="text-center">${user.bio} </p>
                    </div>
                </div>
            </div>
        </div>

        <h2> My pets </h2>
        <hr>
    </div>


    <div class="container mt-5">
        <#list pets as pet>
            <div class="row justify-content-around">
                <div class="card" style="width: 18rem;">
                    <img src="${pet.avatarPath}" class="card-img-top" alt="...">
                    <div class="card-body">
                        <div>
                            <p class="card-text">${pet.nickname}</p>
                            <button>
                                <a href="/pet/${pet.id}"> Check profile </a>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </#list >
    </div>
</div>