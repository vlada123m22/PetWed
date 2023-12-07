<div class = "container">
    <div class="row">
        <div class="card shadow-sm">
            <img src="${pet.avatarPath}" class="img-fluid d-placeholder-img card-img-top" alt="...">
            <div class="card-body">
                <h3 class="card-title">${pet.nickname}</h3>
            </div>
        </div>
        <div class="col">
            <div class="card shadow-sm">
                <img src="/${user.avatarPath}" class="img-fluid d-placeholder-img card-img-top" alt="...">
                <div class="card-body">
                    <a href="/profile">
                        <h3 class="card-title">${user.firstName}</h3>
                        <h3 class="card-title">${user.lastName}</h3>
                    </a>

                </div>
            </div>
        </div>
        <a class="h3" href="/personal-pet/edit/${pet.id}">Edit info</a>
    </div>
</div>