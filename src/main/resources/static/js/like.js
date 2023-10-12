(function () {
    const form = document.querySelector('.like-button');
    let csrfToken = document.querySelector('[name="_csrf"]').content;
    let csrfHeader = document.querySelector('[name="_csrf_header"]').content;
    form.addEventListener('click', (e) => {
        e.preventDefault();
        //TODO look vanilla js string concatination
        fetch("http://localhost:8080//like-dislike/true/{petFromId}/{petToId}", {
            method: "POST",
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
                'x-csrf-token': csrfToken
            },
            body: JSON.stringify({like: true})
        })
            .then(res => res.json())
            .then(res => console.log(res));
    })
})();

//vanilla js