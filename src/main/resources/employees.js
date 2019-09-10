var apiUrl = "http://localhost:8080"

$(document).ready(function(){
    getEmployees();
    $(document).on("click",".delete", function () {
           var id = $(this).data('id');
           deleteEmployee(id,$(this));
        });
    $(document).on("click",".update", function () {
           var id = $(this).data('id');
           window.location.href = "updateEmployee.html?id=" + id;
        });
});

function getEmployees(){
    $.ajax({
        url: apiUrl + '/employees',
        method: "GET"
        }).done(function (response) {
            response.forEach(function(employee) {
            var row = `<tr>
                         <td>` + employee.firstName + `</td>
                         <td>` + employee.lastName + `</td>
                         <td>` + employee.age + `</td>
                         <td>` + employee.phoneNumber + `</td>
                         <td>` + employee.emailAddress + `</td>
                         <td>` + employee.username + `</td>
                         <td>` + employee.password + `</td>
                         <td>
                           <a class='fa fa-trash delete' data-id=` + employee.pk + `>
                           &nbsp;&nbsp;&nbsp;&nbsp;
                           <a class='fa fa-edit update' data-id=` + employee.pk + `>
                         </td></tr>`;
                   $('#employees').append(row);
                 });
        }).fail(function (response) {
            console.log(response)
        })
}

function deleteEmployee(id, element){
   $.ajax({
           url: apiUrl + "/employees/" + id,
           method: "DELETE"
       }).done(function (response) {
           element.parent().parent().remove()
       }).fail(function (jqXHR, textStatus, error) {

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