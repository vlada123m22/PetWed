(function () {
    let fileImageElemInput = document.querySelector('#fileImageElemInput');
    let saveProfile = document.querySelector('#saveProfile');
    let upload = document.querySelector('#submitImageProfile');
    let status = document.querySelector('#status');
    let csrfToken = document.querySelector('[name="_csrf"]').content;
    upload.addEventListener('click', () => {
        console.log('clicked the upload button!');
        status.innerHTML = 'uploading...';
        const file = fileImageElemInput.files[0];
        uploadFile(file)
    })

    saveProfile.addEventListener('click', () => {
        let url = 'http://localhost:8080/update-user-profile'
        let obj = {};
        document.querySelectorAll('.user-profile-input').forEach((el) => {
           obj[el.name] =  el.value;
        })
        console.log(obj)
        fetch(url, {
            method: 'POST',
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
                'x-csrf-token': csrfToken
            },
            body: JSON.stringify(obj)
        }).then((response) => {
            // do something with response here...
            console.log(response.statusText);
            if (response.status ===200){
                document.location.reload();
            }
        });
    })
    function uploadFile(file) {
        let url = 'http://localhost:8080/upload-file'
        let formData = new FormData()
        formData.append('file', file)
        fetch(url, {
            method: 'POST',
            headers: {
                'x-csrf-token': csrfToken
            },
            body: formData
        })
            .then((response) => {
                // do something with response here...
                console.log(response);
                status.innerHTML = `file uploaded!!!`;
                if (response.status ===200){
                    return response.json();
                }
            }).then(function (data) {

            console.log(data);
            previewFile(data.urlPath)
            status.innerHTML = `file ${data.fileName} with size: ${data.size} uploaded!!!`;
            document.querySelector('#userProfileImagePath').value = data.urlPath;
        })
            .catch(() => { /* Error. Inform the user */ })
    }

    function previewFile(fileSRC) {
        let img = document.createElement('img')
        img.classList.add('img-thumbnail');
        img.src = fileSRC
        document.querySelector('#imagePreview').appendChild(img)
    }

})();