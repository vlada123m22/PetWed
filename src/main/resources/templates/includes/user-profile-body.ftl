<div class = "container">
    <div class="row">
        <h>${firstName}</h>
        <h>${lastName}</h>
        <img src="/${avatarPath}">
        <#list pets as  pet>
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