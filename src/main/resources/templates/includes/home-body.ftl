<section class="py-5 text-center container">
    <div class="row py-lg-5">
        <div class="col-lg-6 col-md-8 mx-auto">
            <h1 class="fw-light">List of pets</h1>
            <p class="lead text-body-secondary">The ideal place to find a partner for your pet</p>
        </div>
    </div>
</section>
<div class="album py-5 bg-body-tertiary">
    <div class="container">
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
            <#list pets as pet>
                <div class="col">
                    <div class="card shadow-sm">
                        <img src="/${pet.avatarPath}" class="img-fluid d-placeholder-img card-img-top" alt="...">
                        <div class="card-body">
                            <h3 class="card-title">${pet.nickname}</h3>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</div>