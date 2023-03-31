var session = JSON.parse(localStorage.getItem("sessionADMIN"));
var session_id = session.id;
var session_name = session.name;
$('#lblUserName').text(session_name);


loadPendingTournament();
function loadPendingTournament() {
    var todayDate = new Date();
    var month = todayDate.getMonth()+1;
    var year = todayDate.getUTCFullYear() - 0;
    var tdate = todayDate.getDate();
    if(month < 10){
        month = "0" + month
    }
    if(tdate < 10){
        tdate = "0" + tdate;
    }
    var maxDate = year + "-" + month + "-" + tdate;

    $("#tblPendingTournament tbody tr").remove();
    var ajaxConfig = {
        method: "GET",
        url: "http://localhost:8080/api/tournament/findAllStatus?t_status=pending",
        async: true
    };
    $.ajax(ajaxConfig).done(function (dataAll, statusText, jxhr) {
        dataAll.forEach(function (data) {
            if (data.t_start_date <= maxDate) {
                var html = `<tr id="${data.tid}">
                               <td>${data.t_name}</td>
                               <td>${data.t_type_schedule}</td>
                               <td>${data.t_start_date}</td>
                               <td>${data.t_sport}</td>
                               <td>${data.t_type}</td>
                               <td id="${data.tid}">
                                   <button class="btn btn-info btn-sm btnGenerate">Generate</button>
                               </td>
                         </tr>`;
                $("#tblPendingTournament tbody").append(html);
            }
        });

        $('.btnGenerate').click(function () {
            var tid = $(this).parent().attr('id');
            var detail= {
                id:tid
            }
            localStorage.setItem("sessionGenerate",JSON.stringify(detail));
            window.open('a_finalize_team.html');
        });
    }).fail(function (jxhr, statusText, error) {
        console.log(error);
    });

}