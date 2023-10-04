(function () {
    const form = document.querySelector('#registrationForm');
    form.addEventListener('submit', (e) => {
        e.preventDefault();
        fetch("http://localhost:8080/add-new-user", {
            method: "POST",
            headers: {
                'Content-type': 'application/json; charset=UTF-8'
            },
            body: JSON.stringify(serializeForm(e.target))
        })
            .then(res => res.json())
            .then(res => console.log(res)
            if(res.status=== 200){
                document.location.href="http://localhost:8080/";
            }
            );
    })
    function serializeForm(form) {
        let obj = {};
        let formData = new FormData(form);
        formData.forEach((value, key) => {
            obj[key] = value;
        })
        return obj;
    }

    const button = document.querySelector('#submitButton');
    button.addEventListener("click", (e)=> {
        // document.getElementById("demo").innerHTML = "Account Created";
        fetch("http://localhost:8080", {
            method:"POST",
            body:button
        })
    });
})();



