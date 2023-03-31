var session = JSON.parse(localStorage.getItem("sessionADMIN"));
var session_id = session.id;
var session_name = session.name;
$('#lblUserName').text(session_name);

loadUser();
function loadUser() {

    $("#tblUser tbody tr").remove();
    var ajaxConfig = {
        method: "GET",
        url: "http://localhost:8080/api/user/findAll",
        async: true
    };
    $.ajax(ajaxConfig).done(function (dataAll, statusText, jxhr) {
        dataAll.forEach(function (data) {
            var html = `<tr>
                           <td>${data.u_name}</td>
                           <td>${data.u_u_name}</td>
                           <td>${data.u_url}</td>
                           <td>${data.u_rank}</td>
                           <td>${data.u_role}</td>
                         </tr>`;
            $("#tblUser tbody").append(html);
        });
    }).fail(function (jxhr, statusText, error) {
        console.log(error);
    });
}