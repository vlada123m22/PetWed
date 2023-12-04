<style>
    .btn {
        background-color: #ea8de7;
    }
</style>

<div>
<div class="container mt-5">
    <div class="display-5 text-center"  style="font-family: cursive; color: rgb(234, 141, 231)">Edit your Pet's information</div>
    <hr>
    <div class="row">
        <div class="col-md-3 border-right">
            <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                <img class="rounded-circle mt-5" width="150px" src="${pet.avatarPath}" alt="Pet image">
            </div>
        </div>
        <div class="col-md-5 border-right">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h4 class="text-right">Pet Profile Settings</h4>
                </div>
                <input id="upetProfileImagePath" type="hidden" name="imgPath" class="pet-profile-input" value="${pet.avatarPath}" />
                <div class="row mt-2">
                    <div class="col-md-6">
                        <label class="labels">Name</label>
                        <input type="text" name="firstName" class="form-control pet-profile-input" placeholder="Enter Pet's name" value="${pet.nickname}" />
                    </div>
                    <div class="col-md-6">
                        <label class="labels">Species</label>
                        <input type="text" name="lastName" class="form-control pet-profile-input" placeholder="Your pet is a..." value="${pet.breed.species}" />
                    </div>
                    <div class="col-md-6">
                        <label class="labels">Breed</label>
                        <input type="text" name="lastName" class="form-control pet-profile-input" placeholder="Your pet is a..." value="${pet.breed.breed}" />
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="row mt-2 text-center">
                        <div class="col-md"> <label class="labels">Profile Image</label></div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-md-6">
                            <input id="fileImageElemInput" type="file" name="fileImageElem" />
                        </div>
                        <div class="col-md-6">
                            <button id="submitImageProfile" class="btn btn-custom" type="button">Save Image</button>
                        </div>
                    </div>
                    <small id="status"></small>
                    <div id="imagePreview"></div>
                </div>
                <div class="row mt-3">
                    <div class="col-md-12">
                        <label class="labels">Gender</label>
                        <input type="text" class="form-control pet-profile-input" placeholder="Enter gender" value="${pet.gender}">
                    </div>

                    <div class="col-md-12">
                        <label class="labels">Date of birth</label>
                        <input type="text" class="form-control pet-profile-input" placeholder="Enter address age" value="${pet.birthDate}">
                    </div>
                </div>
            </div>
            <div class="mt-5 text-center">
                <button id="saveProfile" class="btn profile-button custom-button btn-custom" type="button">Save Profile</button>
            </div>
        </div>
    </div>
</div>
<div class="display-6 text-center"  style="font-family: cursive; color: rgb(234, 141, 231)">Add a new photo of your pet!</div>
<hr>
<div class="image-upload-container">
    <label class="image-upload-label" for="imageInput">Upload a new photo</label>
    <input type="file" id="imageInput" accept="image/*">
</div>

<img id="uploadedImage" class="uploaded-image" src="" alt="Uploaded Image">
</div>