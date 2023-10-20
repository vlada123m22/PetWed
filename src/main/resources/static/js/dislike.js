(function ()  {
    const buttons = document.querySelectorAll(".dislike-button");
    let csrfToken = document.querySelector('[name="_csrf"]').content;
    let csrfHeader = document.querySelector('[name="_csrf_header"]').content;
    buttons.forEach(button =>{
        let like=button.dataset.like;
        let petFromId=button.dataset.from;
        let petToId=button.dataset.to;
        button.addEventListener('click', (e) => {
            e.preventDefault();

            if(petToId<=0){
                return;
            }
            let url ="http://localhost:8080/dislike/"+petFromId+"/"+petToId;
            console.log(url);
            fetch(url, {
                method: "POST",
                headers: {
                    'x-csrf-token':csrfToken
                },
            })
                .then( response => response.json() )
                .catch(function (err) {
                // There was an error
                console.warn('Something went wrong.', err);
            })
        })
    })

})();