(function ()  {
    const button = document.querySelector('.like-button');
    let csrfToken = document.querySelector('[name="_csrf"]').content;
    let csrfHeader = document.querySelector('[name="_csrf_header"]').content;
    button.addEventListener('click', (e) => {
        let like=button.dataset.like;
        let petFromId=button.dataset.petFrom;
        let petToId=button.dataset.petTo;
        e.preventDefault();
        //TODO look vanilla js string concatination
        fetch("http://localhost:8080//like-dislike/"+like+"/"+petFromId+"/"+petToId, {
            method: "POST",
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
                'x-csrf-token': csrfToken
            },
        })
            .then(res => res.json())
            .then(res => console.log(res));
    })


})();
