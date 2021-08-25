//let studentResponse;
function ready() {

	
    let xhr = new XMLHttpRequest();
    xhr.responseType = 'json';
    xhr.open("GET", "/getStudentPage");
    xhr.onload = function() {

        var studentResponse = xhr.response;
//        console.log(studentResponse);

        var context =
        	'<div class=student>' +
            '<p>First name :  ' + studentResponse.firstName + '</p>'+
            '<p>Last name : '+ studentResponse.lastName + '</p>' +
            '<p>Age : ' + studentResponse.age + '</p>'+ '</div>'+
        	'<div style=" display:block; background-image:url('+studentResponse.fileDownloadUri +'); background-size:100% 100%; width: 500px; height: 500px; "' +
          '</div>';

        document.getElementById('student').innerHTML = context;

    }
    xhr.send();


}

document.addEventListener("DOMContentLoaded", ready);