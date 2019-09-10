$(document).ready(function(){
    if(!getCookie("user")){
        window.location.href="login.html"
    }
});

function getCookie(cname) {
  var name = cname + "=";
  var decodedCookie = decodeURIComponent(document.cookie);
  var ca = decodedCookie.split(';');
  for(var i = 0; i <ca.length; i++) {
    var c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
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
