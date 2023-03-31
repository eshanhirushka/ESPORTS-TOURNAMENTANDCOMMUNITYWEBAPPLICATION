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
            if (data.t_start_date >= maxDate) {
                if (data.t_reg_start >= maxDate) {
                    var html = `<tr id="${data.tid}">
                               <td>${data.t_name}</td>
                               <td>${data.t_type_schedule}</td>
                               <td>${data.t_reg_start}</td>
                               <td>${data.t_reg_end}</td>
                               <td>${data.t_start_date}</td>
                               <td>${data.t_sport}</td>
                               <td>${data.t_type}</td>
                               <td>
                                   <button class="btn btn-info btn-sm btnRegCaster">Reg</button>
                               </td>
                               <td>
                                   <button class="btn btn-info btn-sm btnRef">Reg</button>
                               </td>
                               <td>
                                    <button class="btn btn-warning btn-sm btnEnd">End</button>
                               </td>
                         </tr>`;
                    $("#tblPendingTournament tbody").append(html);
                }
            }
        });
        $('.btnEnd').click(function () {
            var tid = $(this).parent().parent().attr('id');
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/api/tournament/updateStatus?tid="+tid+"&t_status=end",
                dataType: "json",
                contentType: "application/json;charset=utf-8",
                success: function (data) {
                    swal('End Success');
                    setTimeout(function () {
                        location.reload();
                    }, 500);
                },
                error: function (data) {
                    swal('End Unsuccess');
                }
            });
        });
        $('.btnRegCaster').click(function () {
            var tid = $(this).parent().parent().attr('id');
            $.ajax({
                type: "POST",
                url: 'http://localhost:8080/api/admin_tournament/findUserJoinTournament?tid='+tid+"&aid="+session_id,
                dataType: "json",
                contentType: "application/json;charset=utf-8",
                success: function (data) {
                    if (!data){
                        var regJSON ={
                            adid:0,
                            ad_tid:tid,
                            ad_aid:session_id,
                            ad_join_type:'caster',
                        };
                        $.ajax({
                            type: "POST",
                            data: JSON.stringify(regJSON),
                            url: 'http://localhost:8080/api/admin_tournament/add',
                            dataType: "json",
                            contentType: "application/json;charset=utf-8",
                            success: function (data) {
                                swal('Registration Success');
                                setTimeout(function () {
                                    location.reload();
                                }, 500);
                            },
                            error: function (data) {
                                swal('Registration Unsuccess');
                            }
                        });
                    }else {
                        swal('Your Already Register This Tournament');
                    }
                },
                error: function (data) {
                    swal('Registration Unsuccess');
                }
            });
        });

        $('.btnRef').click(function () {
            var tid = $(this).parent().parent().attr('id');
            $.ajax({
                type: "POST",
                url: 'http://localhost:8080/api/admin_tournament/findUserJoinTournament?tid='+tid+"&aid="+session_id,
                dataType: "json",
                contentType: "application/json;charset=utf-8",
                success: function (data) {
                    if (!data){
                        var regJSON ={
                            adid:0,
                            ad_tid:tid,
                            ad_aid:session_id,
                            ad_join_type:'ref',
                        };
                        $.ajax({
                            type: "POST",
                            data: JSON.stringify(regJSON),
                            url: 'http://localhost:8080/api/admin_tournament/add',
                            dataType: "json",
                            contentType: "application/json;charset=utf-8",
                            success: function (data) {
                                swal('Registration Success');
                                setTimeout(function () {
                                    location.reload();
                                }, 500);
                            },
                            error: function (data) {
                                swal('Registration Unsuccess');
                            }
                        });
                    }else {
                        swal('Your Already Register This Tournament');
                    }
                },
                error: function (data) {
                    swal('Registration Unsuccess');
                }
            });
        });
    }).fail(function (jxhr, statusText, error) {
        console.log(error);
    });

}