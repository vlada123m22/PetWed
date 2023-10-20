

<style>

    .carousel-control-next {
        width: 70px;
        height: 70px;
        border-radius: 50%;
        background-color: #7fcc6a;
        border: 2px solid #ffffff;
        color: #7fcc6a;
        top: 50%;
        content: '\U+2705'; /* Unicode character for a star, change as needed */
    }

    .carousel-control-prev {
        width: 70px;
        height: 70px;
        border-radius: 50%;
        background-color: #cc6a90;
        border: 2px solid #ffffff;
        color: #cc6a90;
        top: 50%;
        content: '\2713'; /* Unicode character for a checkmark, change as needed */
    }

    .carousel-inner img {
        object-fit: cover;
        height: 90vh;
        width: 85%;
    }

    .carousel-caption {
        position: absolute;
        background-color: rgba(255, 255, 255, 0.5);
        padding: 20px;
        font-size: 20px;
        color: #000;
    }

    h5 {
        font-size: 27px;
    }

</style>


<div>
<div class="btn-group">
    <a class="btn btn-secondary btn-lg dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
        Select the pet
    </a>
    <ul class="dropdown-menu">
        <#list personalPets as pp>
            <li>
                <a href="/home/${pp.id}">${pp.nickname}</a>
            </li>
        </#list>
    </ul>
</div>
<div id="carouselExampleCaptions" class="carousel slide" data-bs-touch="false" data-bs-interval="false">
    <div class="carousel-inner">
        <#list pets>
            <div class="carousel-item active">
                <img src="/img/picture_animals.jpeg" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Select the pet for witch you're seeking a partner and then click right or left</h5>
                </div>
<#--                <script>-->
<#--                    var petFromId="${petFromId}";-->
<#--                    var petToId="${petToId}";-->
<#--                </script>-->
                <button class="btn carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">

                    <#--                <span class="carousel-control-prev-icon" aria-hidden="true"></span>-->
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="btn carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                    <#--                <span class="carousel-control-next-icon" aria-hidden="true"></span>-->
                    <span class="visually-hidden">Next</span>
                </button>
            </div>

            <#items as pet>
                <div class="carousel-item">
                <img src="${pet.avatarPath}" class="d-block mx-auto" alt="Slide 2">
                <div class="carousel-caption d-none d-md-block text-left" >
                    <a href="http://localhost:8080/pet/${pet.id}" ><h5> ${pet.nickname} ${pet.age} y/o</h5></a>
<#--                    <#assign petToId= "${pet.id}" >-->
                    <p>${pet.bio}</p>
                </div>
                    <button class="btn dislike-button carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next" data-from="${petFrom}" data-to="${pet.id}">

                        <#--                <span class="carousel-control-prev-icon" aria-hidden="true"></span>-->
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="btn like-button carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next"  data-from="${petFrom}" data-to="${pet.id}">
                        <#--                <span class="carousel-control-next-icon" aria-hidden="true"></span>-->
                        <span class="visually-hidden">Next</span>
                    </button>

<#--                    <script>-->
<#--                        petFromId="${petFromId}";-->
<#--                        petToId="${petToId}";-->
<#--                    </script>-->
                </div>
<#--                    <input type="hidden" class="pet-to-id" value="2">-->
<#--                    <input type="hidden" class="pet-from-id" value="${pet.id}">-->


            </#items>

        <#else>
            <div class="carousel-item active">
                <img src="/img/picture_animals.jpeg" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5>Select the pet for witch you're seeking a partner and then click right or left</h5>
                </div>
            </div>

        </#list>
    </div>


</div>
</div>



<script src="/js/like.js"></script>
<script src="/js/dislike.js"></script>
