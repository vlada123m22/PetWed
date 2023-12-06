<#--<nav class="navbar navbar-expand-lg navbar-light bg-light">-->
<#--    <a class="navbar-brand" href="#">Pet Mate</a>-->
<#--    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">-->
<#--        <span class="navbar-toggler-icon"></span>-->
<#--    </button>-->
<#--    <div class="collapse navbar-collapse" id="navbarNav">-->
<#--        <ul class="navbar-nav">-->
<#--            <li class="nav-item active">-->
<#--                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>-->
<#--            </li>-->
<#--        </ul>-->
<#--    </div>-->
<#--</nav>-->

<div class="container-lg-5">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#myNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="/home" style="color: rgb(234, 141, 231); font-family: 'Lobster', cursive;">PetMate</a>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/home">Home</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Settings
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">FAQ</a></li>
                            <li><a class="dropdown-item" href="#">About us</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/profile">Your Account</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Liked</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/chats">Messages</a>
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Your Pets
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <#list personalPets as pet>
                                <li><a class="dropdown-item" href="/personal-pet/edit/${pet.id}">${pet.nickname}</a></li>
                            </#list>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="petmate.html"><span class="bi bi-person"></span>Log out</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>