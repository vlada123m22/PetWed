(function ()  {
    const buttons = document.querySelectorAll(".carousel-control-prev, .carousel-control-next");
    let csrfToken = document.querySelector('[name="_csrf"]').content;
    let csrfHeader = document.querySelector('[name="_csrf_header"]').content;
    buttons.forEach(button =>{
        button.addEventListener('click', (e) => {
            e.preventDefault();
            let like=button.dataset.like;
            let petFromId=button.dataset.from;
            let petToId=button.dataset.to;
            if(petFromId<=1){
                return;
            }
            petToId=petToId-1;
            let url ="http://localhost:8080//like-dislike/"+like+"/"+petFromId+"/"+petToId;
            fetch(url, {
                method: "POST",
                headers: {
                    'x-csrf-token':csrfToken
                },
            }).then((response) => {
                console.log(response.statusText);
            });
        })
    })

})();
