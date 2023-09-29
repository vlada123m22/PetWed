(function () {
    const url = 'http://localhost:8080/logout'
    let btnLogout = document.querySelector('#logoutLink');
    let csrfToken = document.querySelector('[name="_csrf"]').content;
    btnLogout.addEventListener('click', function (event) {
         // Do some stuff...
        fetch(url, {
            method: 'POST',
            headers: {
                'x-csrf-token':csrfToken
            },
        }).then((response) => {
            // do something with response here...
            console.log(response.statusText);
            if(response.status === 200 && response.redirected) {
                document.location.href = response.url;
            }
        });
    });

})();