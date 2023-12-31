(function () {
    const form = document.querySelector('#registrationForm');
    let csrfToken = document.querySelector('[name="_csrf"]').content;
    let csrfHeader = document.querySelector('[name="_csrf_header"]').content;
    form.addEventListener('submit', (e) => {
        e.preventDefault();
        fetch("http://localhost:8080/add-new-pet", {
            method: "POST",
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
                'x-csrf-token': csrfToken
            },
            body: JSON.stringify(serializeForm(e.target))
        })
            .then(res => res.json())
            .then(res => console.log(res));
    })
    function serializeForm(form) {
        let obj = {};
        let formData = new FormData(form);
        formData.forEach((value, key) => {
            obj[key] = value;
        })
        return obj;
    }

})();