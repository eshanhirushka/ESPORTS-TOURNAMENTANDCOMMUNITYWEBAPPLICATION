
$('#btnLogIn').click(function () {
    var cmbAccountType = $('#cmbAccountType').val().trim();
    var txtUName = $('#txtUName').val().trim();
    var txtPassword = $('#txtPassword').val().trim();

    if (!validateName(txtUName)) {
        swal("Check User Name");
        return;
    }

    if (!validatePassword(txtPassword)) {
        swal("Check Password");
        return;
    }

    var crypt = {
        secret : "CIPHERKEY",
        decrypt : function (cipher) {
            var decipher = CryptoJS.AES.decrypt(cipher, crypt.secret);
            decipher = decipher.toString(CryptoJS.enc.Utf8);
            return decipher;
        }
    };

    if (cmbAccountType == 'Admin') {
        var ajaxConfig = {
            method: "GET",
            url:'http://localhost:8080/api/admin/findUName?u_name='+txtUName,
            async: true
        };
        $.ajax(ajaxConfig).done(function(data,statusText,jxhr){
            var decipherPassword = crypt.decrypt(data.a_password);
            if (decipherPassword==txtPassword){
                swal('Sign In Success');
                var detail= {
                    id:data.aid,
                    name:data.a_u_name
                }
                localStorage.setItem("sessionADMIN",JSON.stringify(detail));
                setTimeout(function () {
                    window.location='a_home.html';
                }, 500);
            }else {
                swal('Not Match Password');
            }
        }).fail(function(jxhr,statusText,error){
            swal('Not Found User');
        });
    }else if (cmbAccountType == 'User') {
        var ajaxConfig = {
            method: "GET",
            url:'http://localhost:8080/api/user/findUName?u_name='+txtUName,
            async: true
        };
        $.ajax(ajaxConfig).done(function(data,statusText,jxhr){
            var decipherPassword = crypt.decrypt(data.u_password);
            if (decipherPassword==txtPassword){
                var detail= {
                    id:data.uid,
                    name:data.u_u_name
                }
                localStorage.setItem("sessionUSER",JSON.stringify(detail));
                swal('Sign In Success');
                setTimeout(function () {
                    window.location='u_home.html';
                }, 500);
            }else {
                swal('Not Match Password');
            }
        }).fail(function(jxhr,statusText,error){
            swal('Not Found User');
        });
    }
});


function validatePassword(input) {
    const re = /^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\d]){1,})(?=(.*[\W]){1,})(?!.*\s).{8,}$/;
    return re.test(input);
}

function validateName(input) {
    const re = /^[a-zA-Z ]{2,30}$/;
    return re.test(input);
}