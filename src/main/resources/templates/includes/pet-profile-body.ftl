<#--<div class = "container">-->
<#--    <div class="row">-->
<#--        <div class="card shadow-sm">-->
<#--            <img src="/${pet.avatarPath}" class="img-fluid d-placeholder-img card-img-top" alt="...">-->
<#--            <div class="card-body">-->
<#--                <h3 class="card-title">${pet.nickname}</h3>-->
<#--            </div>-->
<#--        </div>-->
<#--            <div class="col">-->
<#--                <div class="card shadow-sm">-->
<#--                    <img src="/${user.avatarPath}" class="img-fluid d-placeholder-img card-img-top" alt="...">-->
<#--                    <div class="card-body">-->
<#--                        <a href="http://localhost:8080/profile/${user.id}">-->
<#--                            <h3 class="card-title">${user.firstName}</h3>-->
<#--                            <h3 class="card-title">${user.lastName}</h3>-->
<#--                        </a>-->

<#--                    </div>-->
<#--                </div>-->
<#--            </div>-->
<#--    </div>-->
<#--</div>-->

<link rel="stylesheet" href="/css/pet-profile.css">
<section id="intro">
    <div class="container-lg">
        <div class="row justify-content-center">
            <div class="co-md-5 text-center text-md-start">
                <div>
                    <div class="text-center">
                        <div class="display-3" style="font-family: cursive; color:fuchsia">Hello, my name is ${pet.nickname}!</div>

                        <div class="display-6"> ${pet.breed.breed}</div>
                    </div>
                </div>
            </div>
            <div class="container-lg">
                <div class="row justify-content-center">
                    <div class="co-md-5 text-center text-md-start">
                        <div>
                            <div class="col-md-2 text-center text-md-start"></div>
                            <div class="display-6">My pictures</div>
                            <hr>
                        </div>
                    </div>
                    <div class="text-center">
                        <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
                            <div class="carousel-indicators">
                                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                                <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
                            </div>
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img src="${pet.avatarPath}" class="img-fluid" alt="Nickname">
                                    <div class="carousel-caption d-none d-md-block">
                                        <h5>${pet.bio}</h5>
<#--                                        <p>I like walks</p>-->
                                    </div>
                                </div>
<#--                                <div class="carousel-item">-->
<#--                                    <img src="img/pet_1.1.jpg" class="img-fluid" alt="Willow">-->
<#--                                    <div class="carousel-caption d-none d-md-block">-->
<#--                                        <h5>This my brother</h5>-->
<#--                                        <p>I love my family</p>-->
<#--                                    </div>-->
<#--                                </div>-->
                            </div>
<#--                            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">-->
<#--                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>-->
<#--                                <span class="visually-hidden">Previous</span>-->
<#--                            </button>-->
<#--                            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">-->
<#--                                <span class="carousel-control-next-icon" aria-hidden="true"></span>-->
<#--                                <span class="visually-hidden">Next</span>-->
<#--                            </button>-->
                        </div>
                    </div>

                </div>


            </div>
        </div>


        <div class="container-lg">
            <div class="row justify-content-center">
                <div class="co-md-5 text-center text-md-start">
                    <div>
                        <div class="col-md-2 text-center text-md-start"></div>
                        <div class="display-6">About me</div>
                        <hr>
                    </div>
                </div>
                <div style="border: 2px solid #c900bf;   outline: #e8bbe6 solid 10px;  margin: auto;padding: 50px;
 text-align: center; width: 50%;">

                    <ul class="list-group">

                        <li class="list-group-item list-group-item-danger">Name</li>

                        <p> ${pet.nickname}</p>
                        <li class="list-group-item list-group-item-danger">Breed</li>

                        <p> ${pet.breed.breed}</p>
                        <li class="list-group-item list-group-item-danger">Gender</li>

                        <p>${pet.gender}</p>
                        <li class="list-group-item list-group-item-danger">Age</li>

                        <p> ${pet.age} y/o</p>
                        <li class="list-group-item list-group-item-danger">Personality</li>

                        <p> Energetic | Loyal | Feisty</p>
                        <li class="list-group-item list-group-item-danger">Hobbies</li>

                        <p> Exploring | Playing | Socializing | Training</p>
                        <li class="list-group-item list-group-item-danger">Favorite Treat</li>

                        <p>Anything with peanut butter! I'll do tricks for a taste of that creamy goodness.</p>
                    </ul>

                </div>



                <div class="container-lg">
                    <div class="row justify-content-center">
                        <div class="co-md-5 text-center text-md-start">
                            <div>
                                <div class="col-md-2 text-center text-md-start"></div>
                                <div class="display-6">My owner</div>
                                <hr>
                            </div>
                        </div>



                        <div class="polaroid-container">
                            <div class="polaroid">
                                <img src="${user.avatarPath}" alt="Samantha Jones">
                                <div class="container">
                                    <p class="p"><h5>${user.firstName} ${user.lastName}</h5></p>
                                    <p class="about-text italic-text">${user.bio}</p>
                                    <a href="http://localhost:8080/profile/${user.id}" target="_blank" class="profile-link">Check Profile</a>
                                    <button class="profile-link message-button">Message</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>