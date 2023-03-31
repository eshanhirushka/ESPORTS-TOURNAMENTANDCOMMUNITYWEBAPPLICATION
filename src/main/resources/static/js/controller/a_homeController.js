var session = JSON.parse(localStorage.getItem("sessionADMIN"));
var session_id = session.id;
var session_name = session.name;

$('#lblUserName').text(session_name);

$(function() {
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
    document.getElementById("txtRegStartDate").setAttribute("min", maxDate);
    document.getElementById("txtRegEndDate").setAttribute("min", maxDate);
    document.getElementById("txtScheduleCreateDate").setAttribute("min", maxDate);
    document.getElementById("txtScheduleEndDate").setAttribute("min", maxDate);
});

$('#txtRegStartDate').change(function () {
    var date = $(this).val().trim();
    var todayDate = new Date(date);
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
    document.getElementById("txtRegEndDate").setAttribute("min", maxDate);
});

$('#txtRegEndDate').change(function () {
    var date = $(this).val().trim();
    var todayDate = new Date(date);
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
    document.getElementById("txtScheduleCreateDate").setAttribute("min", maxDate);
});

$('#txtScheduleCreateDate').change(function () {
    var date = $(this).val().trim();
    var todayDate = new Date(date);
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
    document.getElementById("txtScheduleEndDate").setAttribute("min", maxDate);
});

$('#btnCreate').click(function () {
    var txtTournamentName = $('#txtTournamentName').val().trim();
    var cmbTypeSchedule = $('#cmbTypeSchedule').val().trim();
    var txtRegStartDate = $('#txtRegStartDate').val().trim();
    var txtRegEndDate = $('#txtRegEndDate').val().trim();
    var txtScheduleCreateDate = $('#txtScheduleCreateDate').val().trim();
    var txtScheduleEndDate = $('#txtScheduleEndDate').val().trim();
    var cmbTourType = $('#cmbTourType').val().trim();
    var txtSport = $('#txtSport').val().trim();

    if (!validateName(txtTournamentName)) {
        swal("Check Tournament Name");
        return;
    }

    if (txtRegEndDate <= txtRegStartDate) {
        swal("Check Registration End Date");
        return;
    }

    if (txtScheduleCreateDate <= txtRegEndDate) {
        swal("Check Schedule Create Date");
        return;
    }

    if (txtScheduleEndDate <= txtScheduleCreateDate) {
        swal("Check Schedule End Date");
        return;
    }

    var regJSON ={
        tid:0,
        t_name:txtTournamentName,
        t_type_schedule:cmbTypeSchedule,
        t_reg_start:txtRegStartDate,
        t_reg_end:txtRegEndDate,
        t_start_date:txtScheduleCreateDate,
        t_end_date:txtScheduleEndDate,
        t_type:cmbTourType,
        t_sport:txtSport,
        t_status:'pending'
    };
    $.ajax({
        type: "POST",
        data: JSON.stringify(regJSON),
        url: 'http://localhost:8080/api/tournament/add',
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        success: function (data) {
            swal('Tournament Added');
            setTimeout(function () {
                location.reload();
            }, 500);
        },
        error: function (data) {
            swal('Tournament Added Unsuccess');
        }
    });
})


/**
 * validation Area
 * @param input
 * @returns {boolean}
 */
function validateName(input) {
    const re = /^[a-zA-Z ]{2,30}$/;
    return re.test(input);
}