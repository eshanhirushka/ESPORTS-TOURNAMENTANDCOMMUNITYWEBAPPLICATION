var session = JSON.parse(localStorage.getItem("sessionUSER"));
var session_id = session.id;
var session_name = session.name;
$('#lblUserName').text(session_name);

loadJoinTournament();
function loadJoinTournament() {

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

    $("#tblJoinTournament tbody tr").remove();
    var ajaxConfig = {
        method: "GET",
        url: "http://localhost:8080/api/tournament/findAllStatusUID?uid="+session_id+"&t_status=pending",
        async: true
    };
    $.ajax(ajaxConfig).done(function (dataAll, statusText, jxhr) {
        dataAll.forEach(function (data) {
            if (data.t_start_date<=maxDate){
                var html = `<tr id="${data.tid}">
                           <td>${data.t_name}</td>
                           <td>${data.t_type_schedule}</td>
                           <td>${data.t_reg_start}</td>
                           <td>${data.t_reg_end}</td>
                           <td>${data.t_start_date}</td>
                           <td>${data.t_sport}</td>
                           <td>${data.t_type}</td>
                           <td>
                               <button class="btn btn-danger btn-sm btnUnReg" disabled>UnReg</button>
                           </td>
                         </tr>`;
                $("#tblJoinTournament tbody").append(html);
            } else {
                var html = `<tr id="${data.tid}">
                           <td>${data.t_name}</td>
                           <td>${data.t_type_schedule}</td>
                           <td>${data.t_reg_start}</td>
                           <td>${data.t_reg_end}</td>
                           <td>${data.t_start_date}</td>
                           <td>${data.t_sport}</td>
                           <td>${data.t_type}</td>
                           <td>
                               <button class="btn btn-danger btn-sm btnUnReg">UnReg</button>
                           </td>
                         </tr>`;
                $("#tblJoinTournament tbody").append(html);
            }

        });
        $('.btnUnReg').click(function () {
            var tid = $(this).parent().parent().attr('id');
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/api/user_tournament/deleteRegisterTournament?tid="+tid+"&uid="+session_id,
                dataType: "json",
                contentType: "application/json;charset=utf-8",
                success: function (data) {
                    swal('Unregister Success');
                    setTimeout(function () {
                        location.reload();
                    }, 500);
                },
                error: function (data) {
                    swal('Unregister Unsuccess');
                }
            });
        })
    }).fail(function (jxhr, statusText, error) {
        console.log(error);
    });

}