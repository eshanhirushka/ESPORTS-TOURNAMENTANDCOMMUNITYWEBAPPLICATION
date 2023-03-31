var session = JSON.parse(localStorage.getItem("sessionADMIN"));
var session_id = session.id;
var session_name = session.name;

var sessionGenerate = JSON.parse(localStorage.getItem("sessionGenerate"));
var session_id_Generate = sessionGenerate.id;

var ARRAY_USER_JOIN=[];
var ARRAY_USER_JOIN_SOLO=[];
var ARRAY_USER_JOIN_TEAM=[];

$('#areaTeam').hide();

$('#btnHide').click(function () {
    $('#areaTeam').hide();
});

function randomstring(L) {
    var s = '';
    var randomchar = function() {
        var n = Math.floor(Math.random() * 62);
        if (n < 10) return n; //1-10
        if (n < 36) return String.fromCharCode(n + 55); //A-Z
        return String.fromCharCode(n + 61); //a-z
    }
    while (s.length < L) s += randomchar();
    return s;
}

loadTournament();

function loadTournament() {
    $.ajax({
        type: "GET",
        url: 'http://localhost:8080/api/user_tournament_team/getCountAndTeam?tid='+session_id_Generate,
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        success: function (dataAll) {
            dataAll.forEach(function (data) {
                var temdata =`<tr>
                               <td>${data.utt_ut_team}</td>
                               <td>
                                    <button class="btn btn-info btn-sm btnViewTeam">View</button>
                               </td>
                               <td>
                                    <button class="btn btn-info btn-sm btnAdd">Add</button>
                               </td>
                               <td>
                                    <button class="btn btn-danger btn-sm btnRemove">Remove</button>
                               </td>
                            </tr>`;
                $('#tblPendingTournament tbody').append(temdata);
            });
            $('.btnViewTeam').click(function () {
                $('#areaTeam').show();
                var team_name = $(this).parent().parent().find('td:first-child').text();
                console.log(team_name);
                $.ajax({
                    type: "GET",
                    url: 'http://localhost:8080/api/user_tournament_team/findTeamNameANDTeamID?tid='+session_id_Generate+"&team="+team_name,
                    dataType: "json",
                    contentType: "application/json;charset=utf-8",
                    success: function (dataAll) {
                        $('#tblTeam tbody tr').remove();
                        dataAll.forEach(function (data) {
                            console.log(data);
                            var temdata =`<tr>
                               <td>${data.utt_ut_u_name}</td>
                               <td>${data.utt_ut_rank}</td>
                               <td>${data.utt_ut_role}</td>
                               <td>
                                    <button class="btn btn-danger btn-sm btnRemove">Remove</button>
                               </td>
                            </tr>`;
                            $('#tblTeam tbody').append(temdata);
                        });
                    },
                    error: function (data) {
                        swal('Not Found Data');
                    }
                });
            });
        },
        error: function (data) {
            swal('Not Found Data');
        }
    });

    $.ajax({
        type: "POST",
        url: 'http://localhost:8080/api/user_tournament/findTouramentID?tid='+session_id_Generate,
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            data.forEach(function (data_a) {
                if (data_a.ut_join_type == 'Solo'){
                    ARRAY_USER_JOIN_SOLO.push(data_a);
                }else {
                    ARRAY_USER_JOIN_TEAM.push(data_a);
                }
                ARRAY_USER_JOIN.push(data_a);
            });
            var soloRemoveCount =ARRAY_USER_JOIN_SOLO.length%5;
            var teamRemoveCount = ARRAY_USER_JOIN_TEAM.length%5;
            if (soloRemoveCount!=0){
                for (var i = 0; i < soloRemoveCount; i++) {
                    ARRAY_USER_JOIN_SOLO.pop();
                }
            }
            if (teamRemoveCount!=0){
                for (var i = 0; i < soloRemoveCount; i++) {
                    ARRAY_USER_JOIN_TEAM.pop();
                }
            }
            setSoloTeamName();
            setTeamDataInTable();
        },
        error: function (data) {
            swal('Not Found Data');
        }
    });
}

function setSoloTeamName() {
    var count=0;
    ARRAY_USER_JOIN_SOLO.forEach(function (Solo_Data) {
        if (count<=5){
            Solo_Data.ut_team='TeamA';
            count++;
        } else if(count>5 && count <=10){
            Solo_Data.ut_team='TeamB';
            count++;
        } else if(count>10 && count <=15){
            Solo_Data.ut_team='TeamC';
            count++;
        } else if(count>25 && count <=30){
            Solo_Data.ut_team='TeamD';
            count++;
        }
    });
}

function setTeamDataInTable() {
    ARRAY_USER_JOIN_SOLO.forEach(function (solo_Data) {
        var regJSON ={
            uttid:0,
            utt_utid:solo_Data.utid,
            utt_ut_uid:solo_Data.ut_uid,
            utt_ut_tid:solo_Data.ut_tid,
            utt_ut_join_type:solo_Data.ut_join_type,
            utt_ut_team:solo_Data.ut_team,
            utt_ut_role:solo_Data.ut_role,
            utt_ut_rank:solo_Data.ut_rank,
            utt_ut_u_name:solo_Data.ut_u_name,
            utt_ut_u_role:solo_Data.ut_u_role,
            utt_ut_u_rank:solo_Data.ut_u_rank
        };
        $.ajax({
            type: "POST",
            data: JSON.stringify(regJSON),
            url: 'http://localhost:8080/api/user_tournament_team/add',
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                // console.log('ok');
            },
            error: function (data) {
                // console.log('error');
            }
        });
    });

    ARRAY_USER_JOIN_TEAM.forEach(function (team_Data) {
        var regJSON ={
            uttid:0,
            utt_utid:team_Data.utid,
            utt_ut_uid:team_Data.ut_uid,
            utt_ut_tid:team_Data.ut_tid,
            utt_ut_join_type:team_Data.ut_join_type,
            utt_ut_team:team_Data.ut_team,
            utt_ut_role:team_Data.ut_role,
            utt_ut_rank:team_Data.ut_rank,
            utt_ut_u_name:team_Data.ut_u_name,
            utt_ut_u_role:team_Data.ut_u_role,
            utt_ut_u_rank:team_Data.ut_u_rank
        };
        $.ajax({
            type: "POST",
            data: JSON.stringify(regJSON),
            url: 'http://localhost:8080/api/user_tournament_team/add',
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                // console.log('ok');
            },
            error: function (data) {
                // console.log('error');
            }
        });
    });


}