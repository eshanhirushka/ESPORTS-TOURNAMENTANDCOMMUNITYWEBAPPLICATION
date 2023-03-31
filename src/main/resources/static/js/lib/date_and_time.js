setToday();

// -----------------------------------------------Date Set-----------------------------------------------------------
function setToday() {
    var today= new Date();
    var formatDate = today.format("yyyy-mm-dd");
    $('#lblDate').text(formatDate);
}

function updateTime(){
    var currentTime = new Date()
    var hours = currentTime.getHours()
    var minutes = currentTime.getMinutes()
    if (minutes < 10){
        minutes = "0" + minutes
    }
    var t_str = hours + ":" + minutes + " ";
    if(hours > 11){
        t_str += "PM";
    } else {
        t_str += "AM";
    }

    $('#lblTime').text(t_str);
}
setInterval(updateTime, 1000);