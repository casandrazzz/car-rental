var apiUrl = "http://localhost:8080"

$(document).ready(function() {
    $("#login").submit(function (event) {
            event.preventDefault();
            login();
        });
});

function login() {
    var username = $("input[title='username']").val();
    var password = $("input[title='password']").val();
    if(username=="admin" && password=="password"){
        document.cookie = "user=admin";
        window.location.href="employees.html"
    }
}