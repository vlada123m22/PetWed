

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




<div id="carouselExampleCaptions" class="carousel slide">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="/img/picture_animals.jpeg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
                <h5>Select the pet for witch you're seeking a partner and then click right or left</h5>
            </div>
        </div>
        <#list petAge as pet, age>
            <div class="carousel-item">
                <img src="/${pet.avatarPath}" class="d-block mx-auto" alt="Slide 2">
                <div class="carousel-caption d-none d-md-block text-left" >
                    <a href="http://localhost:8080/pet/${pet.id}" ><h5> ${pet.nickname} ${age} y/o</h5></a>
                    <p>${pet.bio}</p>
                </div>

            </div>
            <div class="like-button">
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next" data-to="${pet.id}" data-from="2" data-like="false">

                    <#--                <span class="carousel-control-prev-icon" aria-hidden="true"></span>-->
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next" data-to="${pet.id}" data-from="2" data-like="true">
                    <#--                <span class="carousel-control-next-icon" aria-hidden="true"></span>-->
                    <span class="visually-hidden">Next</span>
                </button>
            </div>

        </#list>
    </div>

</div>




<#--<div id="carouselExample" class="carousel slide">-->
<#--    <div class="carousel-inner">-->
<#--        <div class="carousel-item active">-->
<#--            <img src="/img/picture_animals.jpeg" class="d-block mx-auto" alt="Slide 1">-->
<#--            <div class="carousel-caption d-none d-md-block text-left">-->
<#--                <h5>Select the pet for witch you're seeking a partner and then click right or left</h5>-->
<#--            </div>-->
<#--        </div>-->
<#--        <#list petAge as pet, age>-->
<#--            <div class="carousel-item">-->
<#--                <img src="/${pet.avatarPath}" class="d-block mx-auto" alt="Slide 2">-->
<#--                <div class="carousel-caption d-none d-md-block text-left" >-->
<#--                    <a href="http://localhost:8080/pet/${pet.id}" ><h5> ${pet.nickname} ${age} y/o</h5></a>-->
<#--                    <p>${pet.bio}</p>-->
<#--                </div>-->
<#--               //TODO need to clarify how to: in vanilla js read custom atribute value from element(tag) a- idLike, after click event-->
<#--            </div>-->
<#--            <a class="carousel-control-prev dislike-button" href="#carouselExample" role="button" data-slide="next" style="left: 150px;" data-petTo="${pet.id}" data-petFrom="2" data-like="false" >-->
<#--&lt;#&ndash;                //<img src="/img/cross.jpg">&ndash;&gt;-->
<#--            </a>-->
<#--            <a class="carousel-control-next like-button" href="#carouselExample" role="button" data-slide="next" style="right: 150px;" data-petTo="${pet.id}" data-petFrom="2" data-like="true">-->
<#--&lt;#&ndash;                <img src="/img/heart.png">&ndash;&gt;-->

<#--            </a>-->
<#--        </#list>-->
<#--    </div>-->

<#--</div>-->
<script src="/js/like.js"></script>
