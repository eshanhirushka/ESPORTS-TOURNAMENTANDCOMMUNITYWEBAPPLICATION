var session = JSON.parse(localStorage.getItem("sessionUSER"));
var session_id = session.id;
var session_name = session.name;
$('#lblUserName').text(session_name);


$('.popupCloseButton').click(function () {
    $('.hover_bkgr_fricc').hide();
});

var SESSION_JOIN_TYPE;
var SESSION_TID;
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
                    if (data.t_reg_end > maxDate){
                        var html = `<tr id="${data.tid}">
                           <td>${data.t_name}</td>
                           <td>${data.t_type_schedule}</td>
                           <td>${data.t_reg_start}</td>
                           <td>${data.t_reg_end}</td>
                           <td>${data.t_start_date}</td>
                           <td>${data.t_sport}</td>
                           <td>${data.t_type}</td>
                           <td>
                               <button class="btn btn-info btn-sm btnJoin" value="solo">Join</button>
                           </td>
                           <td>
                               <button class="btn btn-info btn-sm btnJoin" value="team">Join</button>
                           </td>
                         </tr>`;
                        $("#tblPendingTournament tbody").append(html);
                    }
                }
            }
        });

        $('.btnJoin').click(function () {
            var value = $(this).val().trim();
            SESSION_TID = $(this).parent().parent().attr('id');
            $.ajax({
                type: "POST",
                url: 'http://localhost:8080/api/user_tournament/findUserJoinTournament?tid='+SESSION_TID+"&uid="+session_id,
                dataType: "json",
                contentType: "application/json;charset=utf-8",
                success: function (data) {
                    if (!data){
                        console.log(SESSION_TID)
                        if (value == 'solo') {
                            SESSION_JOIN_TYPE = 'Solo'
                            $('#areaTeamName').hide();
                        }else if (value == 'team') {
                            SESSION_JOIN_TYPE = 'Team'
                            $('#areaTeamName').show();
                        }
                        $('.hover_bkgr_fricc').show();
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

$('#btnSave').click(function () {
    var txtTeamName = $('#txtTeamName').val().trim();
    var cmbChangeRole = $('#cmbChangeRole').val().trim();
    var cmbRank = $('#cmbRank').val().trim();
    var regJSON ={
        utid:0,
        ut_uid:session_id,
        ut_tid:parseInt(SESSION_TID),
        ut_join_type:SESSION_JOIN_TYPE,
        ut_team:txtTeamName,
        ut_role:cmbChangeRole,
        ut_rank:cmbRank
    };
    console.log(regJSON);
    $.ajax({
        type: "POST",
        data: JSON.stringify(regJSON),
        url: 'http://localhost:8080/api/user_tournament/add',
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            swal('Tournament Join');
            setTimeout(function () {
                $('.hover_bkgr_fricc').hide();
                location.reload();
            }, 500);
        },
        error: function (data) {
            swal('Tournament Join Unsuccess');
        }
    });
})