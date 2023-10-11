<div class = "container">
    <div class="row">
        <div class="card shadow-sm">
            <img src="/${user.avatarPath}" class="img-fluid d-placeholder-img card-img-top" alt="...">
            <div class="card-body">
                <h3 class="card-title">${user.firstName}</h3>
                <h3 class="card-title">${user.lastName}</h3>
            </div>
        </div>
        <#list pets as  pet>
            <div class="col">
                <div class="card shadow-sm">
                    <img src="/${pet.avatarPath}" class="img-fluid d-placeholder-img card-img-top" alt="...">
                    <div class="card-body">
                        <a href="http://localhost:8080/personal-pet/${pet.id}"><h3 class="card-title">${pet.nickname}</h3></a>
                    </div>
                </div>
            </div>
        </#list>
        <a href="/new-pet"><h3>Add new pet</h3></a>
    </div>
</div>