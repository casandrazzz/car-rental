$(document).ready(function(){
    if(!Cookies.get('user')){
        window.location.href="login.html"
    }
    $(document).on("click","#logout", function () {
               logout()
            });
});

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

function logout(){
    Cookies.remove('user')
    window.location.href="login.html"
}
