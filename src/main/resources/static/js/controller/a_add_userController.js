var session = JSON.parse(localStorage.getItem("sessionADMIN"));
var session_id = session.id;
var session_name = session.name;
$('#lblUserName').text(session_name);

$('#btnRegister').click(function () {
    var txtFullName = $('#txtFullName').val().trim();
    var txtUserName = $('#txtUserName').val().trim();
    var txtPassword = $('#txtPassword').val().trim();
    var txtConformPassword = $('#txtConformPassword').val().trim();
    var txtURL = $('#txtURL').val().trim();
    var cmbGameRank = $('#cmbGameRank').val().trim();
    var cmbGameRole = $('#cmbGameRole').val().trim();

    if (!validateName(txtFullName)) {
        swal("Check Full Name");
        return;
    }

    if (!validateName(txtUserName)) {
        swal("Check User Name");
        return;
    }

    if (!validatePassword(txtPassword)) {
        swal("Check Password");
        return;
    }

    if (!validatePassword(txtConformPassword)) {
        swal("Check Conform Password");
        return;
    }

    if (txtPassword == txtConformPassword) {
        swal("Not Match Password");
        return;
    }

    var crypt = {
        secret : "CIPHERKEY",
        encrypt : function (clear){
            var cipher = CryptoJS.AES.encrypt(clear, crypt.secret);
            cipher = cipher.toString();
            return cipher;
        }
    };
    var passwordENCRYPT = crypt.encrypt(txtConformPassword);

    var ajaxConfig = {
        method: "GET",
        url:'http://localhost:8080/api/user/findUName?u_name='+txtUName,
        async: true
    };
    $.ajax(ajaxConfig).done(function(data,statusText,jxhr){
        swal('User Name Booking.Enter Another User Name');
    }).fail(function(jxhr,statusText,error){
        var regJSON ={
            uid:0,
            u_name:txtFullName,
            u_u_name:txtUserName,
            u_password:passwordENCRYPT,
            u_url:txtURL,
            u_rank:cmbGameRank,
            u_role:cmbGameRole
        };
        $.ajax({
            type: "POST",
            data: JSON.stringify(regJSON),
            url: 'http://localhost:8080/api/user/add',
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
    });
});


function validatePassword(input) {
    const re = /^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\d]){1,})(?=(.*[\W]){1,})(?!.*\s).{8,}$/;
    return re.test(input);
}

function validateName(input) {
    const re = /^[a-zA-Z ]{2,30}$/;
    return re.test(input);
}