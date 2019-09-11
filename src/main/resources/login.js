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
        Cookies.set('user',username)
        window.location.href="employees.html"
    }
}