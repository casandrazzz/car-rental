var apiUrl = "http://localhost:8080"

$(document).ready(function() {
    let link = window.location.href;
    let params = link.split('?')[1]
    let id = params.split('=')[1]
    getEmployee(id);
    $("#update-employee").submit(function (event) {
        event.preventDefault();
        updateEmployee(id);
    });
});


function getEmployee(id) {


    $.ajax({
        url: apiUrl + "/employees/" + id,
        method: "GET",
        contentType: "application/json"
    }).done(function (response) {
         $("input[title='firstname']").val(response.firstName);
         $("input[title='lastname']").val(response.lastName);
         $("input[title='age']").val(response.age);
         $("input[title='phone']").val(response.phoneNumber);
         $("input[title='email']").val(response.emailAddress);
         $("input[title='username']").val(response.username);
         $("input[title='password']").val(response.password);

    }).fail(function (jqXHR, textStatus, error) {
        console.log(error)
    });
}

function updateEmployee(id) {

    var firstname = $("input[title='firstname']").val();
    var lastname = $("input[title='lastname']").val();
    var age = $("input[title='age']").val();
    var phone = $("input[title='phone']").val();
    var email = $("input[title='email']").val();
     var username = $("input[title='username']").val();
     var password = $("input[title='password']").val();

    var data = {
        'id': id,
        'firstName': firstname,
        'lastName': lastname,
        'age': age,
        'phoneNumber': phone,
        'emailAddress': email,
        'username': username,
        'password': password
    }

    $.ajax({
        url: apiUrl + "/employees/" + id,
        method: "PUT",
        contentType: "application/json",
        dataType: 'json',
        data: JSON.stringify(data)
    }).done(function (response) {
         window.location = "employees.html";
    }).fail(function (jqXHR, textStatus, error) {
        console.log(error)
    });
}