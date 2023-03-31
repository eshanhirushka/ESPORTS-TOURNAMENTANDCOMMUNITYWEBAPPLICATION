var session = JSON.parse(localStorage.getItem("sessionADMIN"));
var session_id = session.id;
var session_name = session.name;
$('#lblUserName').text(session_name);

loadAdmin();
function loadAdmin() {

    $("#tblUser tbody tr").remove();
    var ajaxConfig = {
        method: "GET",
        url: "http://localhost:8080/api/admin/findAll",
        async: true
    };
    $.ajax(ajaxConfig).done(function (dataAll, statusText, jxhr) {
        dataAll.forEach(function (data) {
            var html = `<tr>
                           <td>${data.a_name}</td>
                           <td>${data.a_u_name}</td>
                           <td>${data.a_url}</td>
                           <td>${data.a_rank}</td>
                           <td>${data.a_role}</td>
                         </tr>`;
            $("#tblUser tbody").append(html);
        });
    }).fail(function (jxhr, statusText, error) {
        console.log(error);
    });
}