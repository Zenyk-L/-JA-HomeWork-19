var singleUploadForm = document.querySelector('#singleUploadForm');
var singleFileUploadInput = document.querySelector('#singleFileUploadInput');
var singleFileUploadError = document.querySelector('#singleFileUploadError');
var singleFileUploadSuccess = document
		.querySelector('#singleFileUploadSuccess');



function readRegistrationForm(){	
	var firstName =  document.querySelector('#firstName').value;
	var lastName =  document.querySelector('#lastName').value;
	var age =  document.querySelector('#age').value;
	
	var student ={
			firstName : firstName,
			lastName : lastName,
			age : age
	}
	return student;
}

function uploadSingleFile(file) {
	
	var responsefileDownloadUri;
	var formData = new FormData();
	var student = readRegistrationForm();
	formData.append("file", file);
	formData.append("student", JSON.stringify(student));

	var xhr = new XMLHttpRequest();
	xhr.open("POST", "/uploadFile");
	xhr.onload = function() {
		console.log(xhr.responseText);
		var response = JSON.parse(xhr.responseText);
		if (xhr.status == 200) {
			singleFileUploadError.style.display = "none";
			responsefileDownloadUri = response.fileDownloadUri;
			singleFileUploadSuccess.innerHTML = "<p>File Uploaded Successfully.</p><p>DownloadUrl : <a href='"
					+ response.fileDownloadUri
					+ "' target='_blank'>"
					+ response.fileDownloadUri + "</a></p>";
			singleFileUploadSuccess.style.display = "block";
		} else {
			singleFileUploadSuccess.style.display = "none";
			singleFileUploadError.innerHTML = (response && response.message)
					|| "Some Error Occurred";
		}
		window.location.replace("student_page.html");
	}
	xhr.send(formData);
}



singleUploadForm.addEventListener('submit', function(event) {
	var files = singleFileUploadInput.files;
	if (files.length === 0) {
		singleFileUploadError.innerHTML = "Please select a file";
		singleFileUploadError.style.display = "block";
	}
	uploadSingleFile(files[0]);
	event.preventDefault();
}, true);

