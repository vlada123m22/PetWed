(function () {
    const form = document.querySelector('#dislike');
    let csrfToken = document.querySelector('[name="_csrf"]').content;
    let csrfHeader = document.querySelector('[name="_csrf_header"]').content;
    form.addEventListener('submit', (e) => {
        e.preventDefault();
        fetch("http://localhost:8080//like-dislike/false/{petFromId}/{petToId}", {
            method: "PUT",
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
                'x-csrf-token': csrfToken
            },
            body: JSON.stringify({like: false})
        })
            .then(res => res.json())
            .then(res => console.log(res));
    })
})
