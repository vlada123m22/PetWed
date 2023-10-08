<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">

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

<div id="carouselExample" class="carousel slide">
    <div class="carousel-inner">
        <#list pets>
            <div class="carousel-item active">
                <img src="img/picture_animals.jpeg" class="d-block mx-auto" alt="Slide 1">
                <div class="carousel-caption d-none d-md-block text-left">
                    <h5>Click right</h5>
                    <p>Click right to see suitable matches for your pet</p>
                </div>
            </div>
            <#items as pet>
            <div class="carousel-item">
                <img src="${pet.avatarPath}" class="d-block mx-auto" alt="Slide 2">
                <div class="carousel-caption d-none d-md-block text-left">
                    <a href="http://localhost:8080/pet/${pet.id}"><h5> ${pet.nickname} 3yo</h5></a>
                    <p>${pet.bio}</p>
                </div>
            </div>
            </#items>
        </#list>
    </div>
    <a class="carousel-control-prev" href="#carouselExample" role="button" data-slide="next" style="left: 150px;">
        <span class="carousel-control-prev-icon" ></span>
    </a>
    <a class="carousel-control-next" href="#carouselExample" role="button" data-slide="next" style="right: 150px;">
        <span class="carousel-control-next-icon"></span>
    </a>
</div>




<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>