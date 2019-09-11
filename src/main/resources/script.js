var apiUrl = "http://localhost:8080"

$(document).ready(function(){
    getEmployees();
    $( "input[name=search]" ).on('keypress', function(e) {
    if(e.which == 13) {
      var term = $(this).val()
      searchEmployees(term)
    }
    });

});

function getEmployees(){
    $.ajax({
        url: apiUrl + '/employees',
        method: "GET"
    }).done(function (response) {
        reloadEmployees(response)
    }).fail(function (response) {
        console.log(response)
    })
}

function reloadEmployees(employees){
    $('#employees tbody').empty();
    employees.forEach(function(employee) {
                var row = `<tr>
                             <td>` + employee.firstName + `</td>
                             <td>` + employee.lastName + `</td>
                             <td>` + employee.age + `</td>
                             <td>` + employee.phoneNumber + `</td>
                             <td>` + employee.emailAddress + `</td></tr>`;
                       $('#employees').append(row);
                     });
}

function searchEmployees(term){
    $.ajax({
        url: apiUrl + '/employees/search/' + term,
        method: "GET"
    }).done(function (response) {
        reloadEmployees(response)
    }).fail(function (response) {
        console.log(response)
    })
}