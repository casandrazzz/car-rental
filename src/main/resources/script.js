$(document).ready(function(){
    getContact()
    getEmployees()
});

$(document).ready(function() {
    $("#create-employee").submit(function (event) {
        event.preventDefault();
        addEmployee();
    });
});


var fields = ['Adresa','Web','Telefon','Email']
var employees = [
    {
        'Id': 1,
        'Firstname': 'Alahu',
        'Lastname': 'Ahbar',
        'Age': 0,
        'Phone': '0756222345',
        'Email': 'bomba@gmail.com'
    },
    {
        'Id': 2,
        'Firstname': 'Mihai',
        'Lastname': 'Viteazu',
        'Age': 69,
        'Phone': '0756231234',
        'Email': 'boss@gmail.com'
    },
    {
        'Id': 3,
        'Firstname': 'Eeee',
        'Lastname': 'BBbbb',
        'Age': 666,
        'Phone': '0788899112',
        'Email': 'Vvvvv@gmail.com'
    }
]

function addEmployee() {
    var firstname = $("input[title='firstname']").val();
    var lastname = $("input[title='lastname']").val();
    var age = $("input[title='age']").val();
    var phone = $("input[title='phone']").val();
    var email = $("input[title='email']").val();

    employees.push({
        'Firstname': firstname,
        'Lastname': lastname,
        'Age': age,
        'Phone': phone,
        'Email': email
    });

    debugger

    window.location.href = "employees.html";
    /*if(title == "" || remindDate == ""){
        bootstrap_alert.warning("Title and/or date can't be empty!");
        return
    }

    var data = {
        'title': title,
        'remindDate': remindDate,

    };

    $.ajax({
        url: apiUrl + "/reminders",
        method: "POST",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data)
    }).done(function (response) {
        bootstrap_alert.success('Reminder added successfully!');
    }).fail(function (jqXHR, textStatus, error) {
        bootstrap_alert.error(error);
    });*/
}

function getContact(){
    fields.forEach(function(field) {
       $("ul#contact").append(`
           <li class="list-group-item">
               <h6 class="label">` + field + `</h6>
               <h4>` + field + `</h6>
           </li>
       `);
     });
}

function getEmployees(){
    employees.forEach(function(employee) {
       $('#employees').append(`
           <tr>
               <td>` + employee.Firstname + `</td>
               <td>` + employee.Lastname + `</td>
               <td>` + employee.Age + `</td>
               <td>` + employee.Phone + `</td>
               <td>` + employee.Email + `</td>
               <td>
                <a href='#' class='fa fa-trash delete'>
               </td>
           </tr>`
       );
     });
}