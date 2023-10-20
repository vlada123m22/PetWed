(function ()  {
    const buttons = document.querySelectorAll(".like-button");
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
            let url ="http://localhost:8080/like/"+petFromId+"/"+petToId;
            console.log(url);
            fetch(url, {
                method: "POST",
                headers: {
                    'x-csrf-token':csrfToken
                },
            })
                .then( response => response.json() )
                .then(function (data) {
                    console.log(data);
                    if(data.message==="Match"){
                        //TODO display the modal "matched"

                       let message = window.prompt("This is a match! Send a message to the owner");
                       let obj={messageText : message}
                       if (message!=null){
                           fetch("http://localhost:8080/record-first-message/"+petToId, {
                               method: 'POST',
                                   headers: {
                                   'Content-type': 'application/json; charset=UTF-8',
                                       'x-csrf-token': csrfToken
                               },
                               body: JSON.stringify(obj)
                           }).then((response) => {
                               // do something with response here...
                               console.log(response.statusText);
                           });
                       }


                    }
                }).catch(function (err) {
                // There was an error
                console.warn('Something went wrong.', err);
            })
        })
    })

})();
