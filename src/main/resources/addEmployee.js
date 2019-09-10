var apiUrl = "http://localhost:8080"

$(document).ready(function() {
    $("#create-employee").submit(function (event) {
        event.preventDefault();
        addEmployee();
    });
});

function addEmployee() {
    var firstname = $("input[title='firstname']").val();
    var lastname = $("input[title='lastname']").val();
    var age = $("input[title='age']").val();
    var phone = $("input[title='phone']").val();
    var email = $("input[title='email']").val();
    var username = $("input[title='username']").val();
    var password = $("input[title='password']").val();

    var data = {
        'firstName': firstname,
        'lastName': lastname,
        'age': age,
        'phoneNumber': phone,
        'emailAddress': email,
        'username': username,
        'password': password
    }

    $.ajax({
        url: apiUrl + "/employees",
        method: "POST",
        contentType: "application/json",
        dataType: 'json',
        data: JSON.stringify(data)
    }).done(function (response) {
         window.location = "employees.html";
    }).fail(function (jqXHR, textStatus, error) {
        console.log(error)
    });
}